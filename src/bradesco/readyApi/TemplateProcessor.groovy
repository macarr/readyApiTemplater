package bradesco.readyApi

import javax.swing.JOptionPane

class TemplateProcessor {

    static String templateLocation = null

    /**
     * Tokenize a template, replacing ReadyAPI properties with property tokens in order
     * to create well-formed JSON
     * @param template the template to escapeProperties
     */
    static void escapeProperties(Template template) {
        def text = template.body

        //replace all ${expression} with "${expression}" so that we end up with valid JSON
        for(def i=0; i<text.length(); i++) {
            if(text[i] == '$' && text[i+1] == '{' && text[i-1] != '"') {
                def end = text.indexOf('}', i)
                if(end == -1) {
                    println("\${ with no matching close bracket")
                    continue
                }
                def property = text[i..end]
                text = "${text.substring(0, i)}\"$property\"${text.substring(end+1, text.length())}"
                i++
            }
        }
        template.escaped = text
    }

    /**
     * Detokenize a template, replacing property tokens with ReadyAPI properties so that
     * it can be used as a ReadyAPI request object. The template will most likely no
     * longer be valid JSON.
     * @param template The template to detokenize
     */
    static void restoreProperties(Template template) {
        def text = template.escaped
        //unquote all properties
        for(def i=0; i<text.length(); i++) {
            if(text[i] == '"' && text[i+1] == '$' && text[i+2] == '{') {
                def end = text.indexOf('}', i)
                if(end == -1) {
                    println("\${ with no matching close bracket")
                    continue
                }
                if(text[end+1] != '"') {
                    println "escaped property missing closing quote"
                    continue
                }
                def property = text[i+1..end]
                text = "${text.substring(0, i)}\"$property\"${text.substring(end+2, text.length())}"
            }
        }
        template.body = text
    }

    static void createTemplateClassFile(File templateFile) {
        if(!templateLocation) {
            throw new RuntimeException("Template file location is not yet defined! Did you run the setup script?")
        }
        Template template = new Template()
        template.load templateFile
        String name = template.name
        boolean validName = false
        while(!validName) {
            name = JOptionPane.showInputDialog(null, "Choose a name for the template loaded from ${templateFile}." +
                    "\nLetters and numbers only, using camel case (ThisIsHowToWriteInCamelCase)" +
                    "\nExample: PostDeviceRegistrationDocuments, for a template for POST /deviceRegistration/documents", name)
            if(name.matches("[a-zA-Z0-9]+")) {
                validName = true
            } else {
                JOptionPane.showMessageDialog(null, "Letters and Numbers only, please.", "Invalid Input", JOptionPane.ERROR_MESSAGE)
            }
        }
        def classStructure =
"""package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class $name extends Template {

    ${name}Change change
    File templateFile
    def templateName = "$template.name"

    ${name}() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new ${name}Change(this)
    }

    class ${name}Change extends Change {
        ${name}Change(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}"""
        File outFile = new File("${templateLocation}\\${name}.groovy")
        println outFile.path
        File directory = new File(templateLocation)
        if(directory.exists() && directory.canWrite()) {
            if(!outFile.exists()) {
                outFile.text = classStructure
                JOptionPane.showMessageDialog(null, "File created at $outFile", "File Created", JOptionPane.INFORMATION_MESSAGE)
            } else if (outFile.exists()) {
                TemplateViewer.showClass(name, classStructure)
            }
        } else {
            JOptionPane.showMessageDialog(null, "Directory does not exist, or file could not be created", "Error!", JOptionPane.ERROR_MESSAGE)
        }

    }

}

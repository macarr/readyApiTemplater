package bradesco.readyApi

import groovy.swing.SwingBuilder

class TemplateLoader {

    /**
     * Map of template name -> template file
     * for use by template objects
     */
    static Map<String, File> templatesMap = [:]

    static List<File> getTemplateFiles() {
        def templates = []
        def dir = new File('../resources')
        dir.eachFile { file ->
            if(file.name.endsWith('.template')) {
//                println "Loaded file $file.name"
                templates << file
            }
        }
        mapTemplates(templates)
    }

    static mapTemplates(List<File> templateFiles) {
        templateFiles.each { file ->
            def templateName
            file.withReader { templateName = it.readLine().trim() }
//            println templateName
            if(templateName)
                templatesMap << [(templateName):file]
        }
    }

    static generateTemplateMap() {
        getTemplateFiles()
    }

    static File fetch(templateName) {
        return templatesMap.get(templateName)
    }

    /*static Template pick() {
        getTemplateFiles()
        def templateNames = templatesMap.keySet().asList()
        def templateKey = null
        new SwingBuilder().edt {
            dialog(modal: true,
                    title: 'Enter program name',
                    alwaysOnTop: true,
                    resizable: true,
                    locationRelativeTo: null,
                    pack: true,
                    show: true
            ) {
                vbox { // Put everything below each other
                    label(text: "Template Name")
                    scrollPane {
                        list(id: 'templateName', items: templateNames, visibleRowCount: 10)
                    }
                    button(defaultButton: true, text: 'Select', actionPerformed: {
                        templateKey = templateName.selectedValuesList
                        dispose() // Close dialog
                    })
                }
            }
        }
//        println templateKey[0].getClass()
//        println(templateKey[0])
        Template template = templatesMap.get(templateKey[0].toString())
        return template
    }*/
}

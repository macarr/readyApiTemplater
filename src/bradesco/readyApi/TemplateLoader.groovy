package bradesco.readyApi

class TemplateLoader {

    /**
     * Map of template name -> template file
     * for use by template objects
     */
    static Map<String, File> templatesMap = [:]

    /**
     * @return a list of all template files in the template resources directory
     * (probably located in C:\Program Files\SmartBear\ReadyAPI-2.1.0\bin\resources)
     */
    static List<File> getTemplateFiles() {
        def templates = []
        def dir = new File('./resources')
        dir.eachFile { file ->
            if(file.name.endsWith('.template')) {
//                println "Loaded file $file.name"
                templates << file
            }
        }
        mapTemplates(templates)
    }

    /**
     * Populate the static template map with name -> file mappings
     * @param templateFiles the template files to map
     */
    static mapTemplates(List<File> templateFiles) {
        templateFiles.each { file ->
            def templateName
            file.withReader { templateName = it.readLine().trim() }
//            println templateName
            if(templateName)
                templatesMap << [(templateName):file]
        }
    }

    /**
     * Load the template files and store them in the static template map
     */
    static void generateTemplateMap() {
        getTemplateFiles()
    }

    /**
     * Fetch a template from the template map
     * @param templateName
     * @return
     */
    static File fetch(templateName) {
        return templatesMap.get(templateName)
    }

    /**
     * Load the contents of the provided template files
     * @param templateFiles the files containing template data
     * @return a list of loaded Template objects
     */
    static List<Template> loadTemplates(List<File> templateFiles) {
        def templateList = []
        templateFiles.each { file ->
            def template = new Template()
            template.load(file)
            templateList << template
        }
        return templateList
    }

    /**
     * Given a list of Template objects, create a name -> Template map
     * @param templateList the list of Templates
     * @return a mapping of Template.name -> Template
     */
    static Map<String, Template> mapLoadedTemplates(List<Template> templateList) {
        def templateMap = [:]
        templateList.each {
            templateMap << [(it.name):it]
        }
        return templateMap
    }
}

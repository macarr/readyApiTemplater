package bradesco.readyApi

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

    static List<Template> loadTemplates(List<File> templateFiles) {
        def templateList = []
        templateFiles.each { file ->
            def template = new Template()
            template.load(file)
            templateList << template
        }
        return templateList
    }

    static Map<String, Template> mapLoadedTemplates(List<Template> templateList) {
        def templateMap = [:]
        templateList.each {
            templateMap << [(it.name):it]
        }
        return templateMap
    }
}

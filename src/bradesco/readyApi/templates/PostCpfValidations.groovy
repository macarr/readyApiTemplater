package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostCpfValidations extends Template {

    PostCpfValidationsChange change
    File templateFile
    def templateName = "GBL_CPFVALIDATIONS_POST_DEFAULT"

    PostCpfValidations() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostCpfValidationsChange(this)
    }

    class PostCpfValidationsChange extends Change {
        PostCpfValidationsChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
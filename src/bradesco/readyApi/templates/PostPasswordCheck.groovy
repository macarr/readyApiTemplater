package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostPasswordCheck extends Template {

    PostPasswordCheckChange change
    File templateFile
    def templateName = "GBL_PASSWORD_CHECK_POST_DEFAULT"

    PostPasswordCheck() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostPasswordCheckChange(this)
    }

    class PostPasswordCheckChange extends Change {
        PostPasswordCheckChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
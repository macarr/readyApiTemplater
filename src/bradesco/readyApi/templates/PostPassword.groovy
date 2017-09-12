package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostPassword extends Template {

    PostPasswordChange change
    File templateFile
    def templateName = "GBL_PASSWORD_POST_DEFAULT"

    PostPassword() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostPasswordChange(this)
    }

    class PostPasswordChange extends Change {
        PostPasswordChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
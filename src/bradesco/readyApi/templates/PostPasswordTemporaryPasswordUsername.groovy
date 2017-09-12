package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostPasswordTemporaryPasswordUsername extends Template {

    PostPasswordTemporaryPasswordUsernameChange change
    File templateFile
    def templateName = "GBL_PASSWORD_TEMPORARYPASSWORD_USERNAME_POST_DEFAULT"

    PostPasswordTemporaryPasswordUsername() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostPasswordTemporaryPasswordUsernameChange(this)
    }

    class PostPasswordTemporaryPasswordUsernameChange extends Change {
        PostPasswordTemporaryPasswordUsernameChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostPasswordTemporaryPasswordVerify extends Template {

    PostPasswordTemporaryPasswordVerifyChange change
    File templateFile
    def templateName = "GBL_PASSWORD_TEMPORARYPASSWORD_VERIFY_POST_DEFAULT"

    PostPasswordTemporaryPasswordVerify() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostPasswordTemporaryPasswordVerifyChange(this)
    }

    class PostPasswordTemporaryPasswordVerifyChange extends Change {
        PostPasswordTemporaryPasswordVerifyChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
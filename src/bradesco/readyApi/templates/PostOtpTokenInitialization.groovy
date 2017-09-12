package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostOtpTokenInitialization extends Template {

    PostOtpTokenInitializationChange change
    File templateFile
    def templateName = "GBL_OTPTOKEN_INITIALIZATION_POST_DEFAULT"

    PostOtpTokenInitialization() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostOtpTokenInitializationChange(this)
    }

    class PostOtpTokenInitializationChange extends Change {
        PostOtpTokenInitializationChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
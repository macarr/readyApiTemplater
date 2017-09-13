package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /otpToken/validation
 */
class PostOtpTokenValidation extends Template {

    PostOtpTokenValidationChange change
    File templateFile
    def templateName = "GBL_OTPTOKEN_VALIDATION_POST_DEFAULT"

    PostOtpTokenValidation() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostOtpTokenValidationChange(this)
    }

    class PostOtpTokenValidationChange extends Change {
        PostOtpTokenValidationChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
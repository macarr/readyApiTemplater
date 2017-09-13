package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * PUT /password/reset
 */
class PutPasswordReset extends Template {

    PutPasswordResetChange change
    File templateFile
    def templateName = "GBL_PASSWORD_RESET_PUT_DEFAULT"

    PutPasswordReset() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutPasswordResetChange(this)
    }

    class PutPasswordResetChange extends Change {
        PutPasswordResetChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
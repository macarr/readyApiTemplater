package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /transfers/registerAccount
 */
class PostTransfersRegisterAccount extends Template {

    PostTransfersRegisterAccountChange change
    File templateFile
    def templateName = "GBL_TRANSFERS_REGISTERACCOUNT_DEFAULT"

    PostTransfersRegisterAccount() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostTransfersRegisterAccountChange(this)
    }

    class PostTransfersRegisterAccountChange extends Change {
        PostTransfersRegisterAccountChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
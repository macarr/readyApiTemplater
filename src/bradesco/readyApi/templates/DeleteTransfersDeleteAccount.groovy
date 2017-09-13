package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * DELETE /transfers/deleteAccount
 */
class DeleteTransfersDeleteAccount extends Template {

    DeleteTransferDeleteAccountChange change
    File templateFile
    def templateName = "GBL_TRANSFER_DELETEACCOUNT_DELETE_DEFAULT"

    DeleteTransfersDeleteAccount() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new DeleteTransferDeleteAccountChange(this)
    }

    class DeleteTransferDeleteAccountChange extends Change {
        DeleteTransferDeleteAccountChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
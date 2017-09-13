package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /transfers/transferId/reciepts/emails
 *
 * Requires the ReadyAPI property ${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_YESTERDAY} to be set
 */
class PostTransfersTransferIdRecieptsEmail extends Template {

    PostTransfersTransferIdRecieptsEmailChange change
    File templateFile
    def templateName = "GBL_TRANSFERS_TRANSFERID_RECEIPTS_EMAIL_DEFAULT"

    PostTransfersTransferIdRecieptsEmail() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostTransfersTransferIdRecieptsEmailChange(this)
    }

    class PostTransfersTransferIdRecieptsEmailChange extends Change {
        PostTransfersTransferIdRecieptsEmailChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
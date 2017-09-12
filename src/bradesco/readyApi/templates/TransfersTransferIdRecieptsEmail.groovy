package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class TransfersTransferIdRecieptsEmail extends Template {

    TransfersTransferIdRecieptsEmailChange change
    File templateFile
    def templateName = "GBL_TRANSFERS_TRANSFERID_RECEIPTS_EMAIL_DEFAULT"

    TransfersTransferIdRecieptsEmail() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new TransfersTransferIdRecieptsEmailChange(this)
    }

    class TransfersTransferIdRecieptsEmailChange extends Change {
        TransfersTransferIdRecieptsEmailChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
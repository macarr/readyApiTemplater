package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostTransfers extends Template {

    PostTransfersChange change
    File templateFile
    def templateName = "GBL_TRANSFER_POST_TO_NEXTER"

    PostTransfers() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostTransfersChange(this)
    }

    class PostTransfersChange extends Change {
        PostTransfersChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

        void toExternalTransferDefault() {
            reset()
            json.contactBankAccount = null
            json.modality = "TED"
            json.recipientBranchId = 212
            json.recipientAccountNumber = 2121
            json.recipientBankId = 144
            json.recipientName = "CA3"
            json.recipientCpfCnpj = "11122233344"
            json.recipientBankIspb = "00000000"
            json.purpose = "0000"
            json.description = "Validate External Transfer"
            json.transferTypeCode = "0"
        }

        void toVaquinhaTransferDefault() {
            reset()
            json.contactBankAccountId = null
            json.purpose = "0"
            json.accountType = "0"
            json.amount = 10.00
            json.description = "Submit Vaquinha Payment"
            json.vaquinhaId = 22
        }

    }

}

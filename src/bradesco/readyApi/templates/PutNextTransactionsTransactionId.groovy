package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * PUT /nextTransactions/transactionId
 */
class PutNextTransactionsTransactionId extends Template {

    PutNextTransactionsTransactionIdChange change
    File templateFile
    def templateName = "GBL_NEXTTRANSACTIONS_TRANSACTIONID_PUT_DEFAULT"

    PutNextTransactionsTransactionId() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutNextTransactionsTransactionIdChange(this)
    }

    class PutNextTransactionsTransactionIdChange extends Change {
        PutNextTransactionsTransactionIdChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
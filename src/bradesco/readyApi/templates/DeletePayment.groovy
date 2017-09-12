package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class DeletePayment extends Template {

    DeletePaymentChange change
    File templateFile
    def templateName = "GBL_PAYMENT_DELETE_DEFAULT"

    DeletePayment() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new DeletePaymentChange(this)
    }

    class DeletePaymentChange extends Change {
        DeletePaymentChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
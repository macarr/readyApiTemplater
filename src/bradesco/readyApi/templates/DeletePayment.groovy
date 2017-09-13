package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * DELETE /payment
 *
 * Requires ${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_TOMORROW} property to be set
 */
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
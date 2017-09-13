package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * PUT /payment/id
 *
 * Requires the ReadyAPI property ${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_TOMORROW} to be set
 */
class PutPaymentId extends Template {

    PutPaymentIdChange change
    File templateFile
    def templateName = "GBL_PAYMENT_ID_PUT_FULL"

    PutPaymentId() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutPaymentIdChange(this)
    }

    class PutPaymentIdChange extends Change {
        PutPaymentIdChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
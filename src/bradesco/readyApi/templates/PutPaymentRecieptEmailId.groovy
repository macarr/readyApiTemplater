package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PutPaymentRecieptEmailId extends Template {

    PutPaymentRecieptEmailIdChange change
    File templateFile
    def templateName = "GBL_PAYMENTRECEIPTEMAIL_ID_PUT_DEFAULT"

    PutPaymentRecieptEmailId() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutPaymentRecieptEmailIdChange(this)
    }

    class PutPaymentRecieptEmailIdChange extends Change {
        PutPaymentRecieptEmailIdChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
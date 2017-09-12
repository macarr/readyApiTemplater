package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostPayment extends Template {

    PostPaymentChange change
    File templateFile
    def templateName = "GBL_PAYMENT_POST_FULL"

    PostPayment() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostPaymentChange(this)
    }

    class PostPaymentChange extends Change {
        PostPaymentChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

        void toNoPayerNoBeneficiaryDefault() {
            reset()
            json.cpfCnpjBeneficiary = null
            json.cpfCnpjPayer = null
        }

    }

}
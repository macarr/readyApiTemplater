package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PutDebitCreditCardsActivation extends Template {

    PutDebitCreditCardsActivationChange change
    File templateFile
    def templateName = "GBL_DEBITCREDITCARDS_ACTIVATION_PUT"

    PutDebitCreditCardsActivation() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutDebitCreditCardsActivationChange(this)
    }

    class PutDebitCreditCardsActivationChange extends Change {
        PutDebitCreditCardsActivationChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PutCreditCardsReplacements extends Template {

    PutCreditCardsReplacementsChange change
    File templateFile
    def templateName = "GBL_CREDITCARDS_REPLACEMENTS_PUT_DEFAULT"

    PutCreditCardsReplacements() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutCreditCardsReplacementsChange(this)
    }

    class PutCreditCardsReplacementsChange extends Change {
        PutCreditCardsReplacementsChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PutOffer extends Template {

    PutOfferChange change
    File templateFile
    def templateName = "GBL_OFFER_PUT_DEFAULT"

    PutOffer() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutOfferChange(this)
    }

    class PutOfferChange extends Change {
        PutOfferChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
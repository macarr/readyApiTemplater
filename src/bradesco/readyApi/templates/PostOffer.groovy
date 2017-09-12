package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostOffer extends Template {

    PostOfferChange change
    File templateFile
    def templateName = "GBL_OFFER_POST_DEFAULT"

    PostOffer() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostOfferChange(this)
    }

    class PostOfferChange extends Change {
        PostOfferChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
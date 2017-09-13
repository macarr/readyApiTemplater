package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /offer
 *
 * Requires the following ReadyAPI properties to be set:
 *
 * ${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_MINUS_14_DAYS}
 * ${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_PLUS_3_MONTHS}
 * ${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_TOMORROW}
 */
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
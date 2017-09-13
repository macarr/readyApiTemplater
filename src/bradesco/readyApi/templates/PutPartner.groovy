package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * PUT /partner
 *
 * Requires the ReadyAPI property ${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_MINUS_14_DAYS}
 * to be set
 */
class PutPartner extends Template {

    PutPartnerChange change
    File templateFile
    def templateName = "GBL_PARTNER_PUT_DEFAULT"

    PutPartner() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutPartnerChange(this)
    }

    class PutPartnerChange extends Change {
        PutPartnerChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /partner
 *
 * Requires the ReadyAPI property ${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_MINUS_14_DAYS}
 * to be set
 */
class PostPartner extends Template {

    PostPartnerChange change
    File templateFile
    def templateName = "GBL_PARTNER_POST_DEFAULT"

    PostPartner() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostPartnerChange(this)
    }

    class PostPartnerChange extends Change {
        PostPartnerChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
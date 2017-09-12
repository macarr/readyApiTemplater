package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostCreditCardsTravelNoticeNorthAmerica extends Template {

    PostCreditCardsTravelNoticeNorthAmericaChange change
    File templateFile
    def templateName = "GBL_CREDITCARDS_TRAVELNOTICE_POST_NORTHAMERICA"

    PostCreditCardsTravelNoticeNorthAmerica() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostCreditCardsTravelNoticeNorthAmericaChange(this)
    }

    class PostCreditCardsTravelNoticeNorthAmericaChange extends Change {
        PostCreditCardsTravelNoticeNorthAmericaChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostCreditCardsTravelNoticeEurope extends Template {

    PostCreditCardsTravelNoticeEuropeChange change
    File templateFile
    def templateName = "GBL_CREDITCARDS_TRAVELNOTICE_POST_EUROPE"

    PostCreditCardsTravelNoticeEurope() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostCreditCardsTravelNoticeEuropeChange(this)
    }

    class PostCreditCardsTravelNoticeEuropeChange extends Change {
        PostCreditCardsTravelNoticeEuropeChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

        void toEurope() {
            json.oceaniaEndDate=null
            json.oceaniaEndDate=null
            json.oceaniaEndDate=null
            json.oceaniaEndDate=null
            json.oceaniaEndDate=null
        }

        void toNorthAmerica() {

        }

        void toSouthAmerica() {

        }

    }

}
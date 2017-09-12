package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostCreditCardsTravelNoticeWorldWide extends Template {

    PostCreditCardsTravelNoticeWorldWideChange change
    File templateFile
    def templateName = "GBL_CREDITCARDS_TRAVELNOTICE_POST_ALL_AROUND_THE_WORLD"

    PostCreditCardsTravelNoticeWorldWide() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostCreditCardsTravelNoticeWorldWideChange(this)
    }

    class PostCreditCardsTravelNoticeWorldWideChange extends Change {
        PostCreditCardsTravelNoticeWorldWideChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
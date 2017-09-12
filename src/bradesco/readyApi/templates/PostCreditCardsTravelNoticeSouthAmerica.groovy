package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostCreditCardsTravelNoticeSouthAmerica extends Template {

    PostCreditCardsTravelNoticeSouthAmericaChange change
    File templateFile
    def templateName = "GBL_CREDITCARDS_TRAVELNOTICE_POST_SOUTHAMERICA"

    PostCreditCardsTravelNoticeSouthAmerica() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostCreditCardsTravelNoticeSouthAmericaChange(this)
    }

    class PostCreditCardsTravelNoticeSouthAmericaChange extends Change {
        PostCreditCardsTravelNoticeSouthAmericaChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
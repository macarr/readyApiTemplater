package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

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
package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

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
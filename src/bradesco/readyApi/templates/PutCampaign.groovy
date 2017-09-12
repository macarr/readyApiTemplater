package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PutCampaign extends Template {

    PutCampaignChange change
    File templateFile
    def templateName = "GBL_CAMPAIGN_PUT_DEFAULT"

    PutCampaign() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutCampaignChange(this)
    }

    class PutCampaignChange extends Change {
        PutCampaignChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
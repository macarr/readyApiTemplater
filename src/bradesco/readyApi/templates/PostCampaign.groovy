package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /campaign
 */
class PostCampaign extends Template {

    PostCampaignChange change
    File templateFile
    def templateName = "GBL_CAMPAIGN_POST_DEFAULT"

    PostCampaign() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostCampaignChange(this)
    }

    class PostCampaignChange extends Change {
        PostCampaignChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
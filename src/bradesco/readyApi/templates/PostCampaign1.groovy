package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostCampaign1 extends Template {

    PostCampaign1Change change
    File templateFile
    def templateName = "GBL_CAMPAIGN_POST_DEFAULT"

    PostCampaign1() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostCampaign1Change(this)
    }

    class PostCampaign1Change extends Change {
        PostCampaign1Change(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
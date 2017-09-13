package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /prospects
 */
class PostProspects extends Template {

    PostProspectsChange change
    File templateFile
    def templateName = "GBL_PROSPECTS_POST_FULL"

    PostProspects() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostProspectsChange(this)
    }

    class PostProspectsChange extends Change {
        PostProspectsChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

        void toOnlyCpfNameEmailDefault() {
            reset()
            json.remove "origin"
            json."smsPermission"
            json."phoneNumber"
            json."areaCode"
            json."countryCode"
        }

    }

}
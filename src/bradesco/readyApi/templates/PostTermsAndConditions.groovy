package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostTermsAndConditions extends Template {

    PostTermsAndConditionsChange change
    File templateFile
    def templateName = "GBL_TERMSANDCONDITIONS_POST_DEFAULT"

    PostTermsAndConditions() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostTermsAndConditionsChange(this)
    }

    class PostTermsAndConditionsChange extends Change {
        PostTermsAndConditionsChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
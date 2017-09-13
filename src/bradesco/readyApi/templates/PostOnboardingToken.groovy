package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /onboardingToken
 */
class PostOnboardingToken extends Template {

    PostOnboardingTokenChange change
    File templateFile
    def templateName = "GBL_ONBOARDINGTOKEN_POST_DEFAULT"

    PostOnboardingToken() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostOnboardingTokenChange(this)
    }

    class PostOnboardingTokenChange extends Change {
        PostOnboardingTokenChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
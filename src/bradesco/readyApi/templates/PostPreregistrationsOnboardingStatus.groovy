package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /preregistrations/onboardingStatus
 */
class PostPreregistrationsOnboardingStatus extends Template {

    PostPreregistrationsOnboardingStatusChange change
    File templateFile
    def templateName = "GBL_PREREGISTRATIONS_ONBOARDINGSTATUS_POST_APPROVED"

    PostPreregistrationsOnboardingStatus() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostPreregistrationsOnboardingStatusChange(this)
    }

    class PostPreregistrationsOnboardingStatusChange extends Change {
        PostPreregistrationsOnboardingStatusChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

        void toRejectedDefault() {
            reset()
            json.applicationStatus = "2"
            json.rejectionReasonDescription = "Too Ugly"
            json.userResponsibleId = "2"
        }

    }

}
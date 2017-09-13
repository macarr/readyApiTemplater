package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /invitations/self
 */
class PostInvitationsSelf extends Template {

    PostInvitationsSelfChange change
    File templateFile
    def templateName = "GBL_INVITATIONS_SELF_POST_FULL"

    PostInvitationsSelf() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostInvitationsSelfChange(this)
    }

    class PostInvitationsSelfChange extends Change {
        PostInvitationsSelfChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

        /**
         * Removes phone number, but maintains smsPermission=true
         */
        void toNoPhone() {
            json.remove "phoneNumber"
            json.remove "areaCode"
            json.remove "countryCode"
        }

    }

}
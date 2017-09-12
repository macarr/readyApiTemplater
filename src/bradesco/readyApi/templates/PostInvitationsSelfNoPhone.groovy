package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostInvitationsSelfNoPhone extends Template {

    PostInvitationsSelfNoPhoneChange change
    File templateFile
    def templateName = "GBL_INVITATIONS_SELF_POST_NO_PHONE"

    PostInvitationsSelfNoPhone() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostInvitationsSelfNoPhoneChange(this)
    }

    class PostInvitationsSelfNoPhoneChange extends Change {
        PostInvitationsSelfNoPhoneChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostInvitationsSharableInvitations extends Template {

    PostInvitationsSharableInvitationsChange change
    File templateFile
    def templateName = "GBL_INVITATIONS_SHAREABLEINVITATION_POST_DEFAULT"

    PostInvitationsSharableInvitations() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostInvitationsSharableInvitationsChange(this)
    }

    class PostInvitationsSharableInvitationsChange extends Change {
        PostInvitationsSharableInvitationsChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
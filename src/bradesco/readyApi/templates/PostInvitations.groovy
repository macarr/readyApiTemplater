package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostInvitations extends Template {

    PostInvitationsChange change
    File templateFile
    def templateName = "GBL_INVITATIONS_POST_DEFAULT"

    PostInvitations() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostInvitationsChange(this)
    }

    class PostInvitationsChange extends Change {
        PostInvitationsChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
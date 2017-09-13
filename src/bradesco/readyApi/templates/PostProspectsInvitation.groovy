package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /prospects/invitation
 */
class PostProspectsInvitation extends Template {

    PostProspectsInvitationChange change
    File templateFile
    def templateName = "GBL_PROSPECTS_INVITATION_POST_DEFAULT"

    PostProspectsInvitation() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostProspectsInvitationChange(this)
    }

    class PostProspectsInvitationChange extends Change {
        PostProspectsInvitationChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
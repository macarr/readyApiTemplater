package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /login/contactInvitation
 */
class LoginContactInvitation extends Template {

    LoginContactInvitationChange change
    File templateFile
    def templateName = "GBL_LOGIN_CONTACTINVITATION_DEFAULT"

    LoginContactInvitation() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new LoginContactInvitationChange(this)
    }

    class LoginContactInvitationChange extends Change {
        LoginContactInvitationChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
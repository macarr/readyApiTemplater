package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class LoginContactInformation extends Template {

    LoginContactInformationChange change
    File templateFile
    def templateName = "GBL_LOGIN_CONTACTINVITATION_DEFAULT"

    LoginContactInformation() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new LoginContactInformationChange(this)
    }

    class LoginContactInformationChange extends Change {
        LoginContactInformationChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
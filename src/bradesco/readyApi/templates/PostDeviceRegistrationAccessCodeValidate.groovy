package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /deviceRegistration/accessCode/validate
 */
class PostDeviceRegistrationAccessCodeValidate extends Template {

    PostDeviceRegistrationAccessCodeValidateChange change
    File templateFile
    def templateName = "GBL_DEVICEREGISTRATION_ACCESSCODE_VALIDATE_POST_DEFAULT"

    PostDeviceRegistrationAccessCodeValidate() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostDeviceRegistrationAccessCodeValidateChange(this)
    }

    class PostDeviceRegistrationAccessCodeValidateChange extends Change {
        PostDeviceRegistrationAccessCodeValidateChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
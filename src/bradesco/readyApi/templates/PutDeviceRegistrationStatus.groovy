package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PutDeviceRegistrationStatus extends Template {

    PutDeviceRegistrationStatusChange change
    File templateFile
    def templateName = "GBL_DEVICEREGISTRATION_STATUS_PUT_DEFAULT"

    PutDeviceRegistrationStatus() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutDeviceRegistrationStatusChange(this)
    }

    class PutDeviceRegistrationStatusChange extends Change {
        PutDeviceRegistrationStatusChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
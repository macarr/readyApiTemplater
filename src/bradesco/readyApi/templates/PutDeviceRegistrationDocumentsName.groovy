package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PutDeviceRegistrationDocumentsName extends Template {

    PutDeviceRegistrationDocumentsNameChange change
    File templateFile
    def templateName = "GBL_DEVICEREGISTRATION_DOCUMENTS_NAME_PUT_DEFAULT"

    PutDeviceRegistrationDocumentsName() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutDeviceRegistrationDocumentsNameChange(this)
    }

    class PutDeviceRegistrationDocumentsNameChange extends Change {
        PutDeviceRegistrationDocumentsNameChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
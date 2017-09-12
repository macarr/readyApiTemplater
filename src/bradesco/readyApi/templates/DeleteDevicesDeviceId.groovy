package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class DeleteDevicesDeviceId extends Template {

    DeleteDevicesDeviceIdChange change
    File templateFile
    def templateName = "GBL_DEVICES_DEVICEID_DELETE_DEFAULT"

    DeleteDevicesDeviceId() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new DeleteDevicesDeviceIdChange(this)
    }

    class DeleteDevicesDeviceIdChange extends Change {
        DeleteDevicesDeviceIdChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * Device subobject
 */
class DeviceObject extends Template {

    DeviceObjectChange change
    File templateFile
    def templateName = "device_json"

    DeviceObject() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new DeviceObjectChange(this)
    }

    class DeviceObjectChange extends Change {
        DeviceObjectChange(Template template) {
            super(template)
        }

        /**
         * Change the device ID
         * @param deviceId
         */
        void deviceId(deviceId) {
            json.deviceId = deviceId
        }

        /**
         * Change the phone number
         * @param countryCode
         * @param areaCode
         * @param phone
         */
        void phoneNumber(countryCode, areaCode, phone) {
            json.countryCode = countryCode
            json.areaCode = areaCode
            json.phone = phone
        }

        /**
         * Change the device make and model
         * @param make
         * @param model
         */
        void makeAndModel(make, model) {
            json.make = make
            json.model = model
        }

    }

}


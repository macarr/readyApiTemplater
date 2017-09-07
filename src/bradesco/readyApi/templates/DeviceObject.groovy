package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * Template for device JSON objects in requests
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
        void deviceId(String deviceId) {
            json.deviceId = deviceId
        }

        /**
         * Change the phone number
         * @param countryCode
         * @param areaCode
         * @param phone
         */
        void phoneNumber(int countryCode, int areaCode, int phone) {
            json.countryCode = countryCode
            json.areaCode = areaCode
            json.phone = phone
        }

        /**
         * Change the device make and model
         * @param make
         * @param model
         */
        void makeAndModel(String make, String model) {
            json.make = make
            json.model = model
        }

    }

}


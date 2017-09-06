package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class LoginDeviceJsonTemplate extends Template {

    LoginDeviceJsonTemplateChange change
    File templateFile
    def templateName = "device_json"

    LoginDeviceJsonTemplate() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new LoginDeviceJsonTemplateChange(this)
    }

    class LoginDeviceJsonTemplateChange extends Change {
        LoginDeviceJsonTemplateChange(Template template) {
            super(template)
        }

        void deviceId(String deviceId) {
            json.deviceId = deviceId
        }

        void phoneNumber(int countryCode, int areaCode, int phone) {
            json.countryCode = countryCode
            json.areaCode = areaCode
            json.phone = phone
        }

        void makeAndModel(String make, String model) {
            json.make = make
            json.model = model
        }

    }

}


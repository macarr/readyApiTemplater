package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * Template for POST /login requests
 *
 * Requests using this template will require #TestCase#Device_JSON to have a valid Device object
 * set, potentially using LoginDeviceJsonTemplate.groovy
 */
class PostLoginTemplate extends Template {

    PostLoginTemplateChange change
    File templateFile
    def templateName = "post_login"

    PostLoginTemplate() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostLoginTemplateChange(this)
    }

    class PostLoginTemplateChange extends Change {
        PostLoginTemplateChange(Template template) {
            super(template)
        }

        /**
         * Change the login credentials (CPF and password)
         * @param cpf
         * @param password
         */
        void loginCredentials(String cpf, String password) {
            json.cpf = cpf
            json.password = password
        }

        /**
         * Change the risk score
         * @param riskScore
         */
        void riskScore(int riskScore) {
            json.riskScore = riskScore
        }

        /**
         * Change the latitude and longitude
         * @param latitude
         * @param longitude
         */
        void latitudeAndLongitude(int latitude, int longitude) {
            json.latitude = latitude
            json.longitude = longitude
        }

        void deviceId(String deviceId) {
            json.device.deviceId = deviceId
        }
    }

}


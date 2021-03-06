package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * Template for POST /login requests
 *
 * Requests using this template will require #TestCase#Device_JSON to have a valid Device object
 * set, potentially using DeviceObject.groovy
 */
class PostLogin extends Template {

    PostLoginChange change
    File templateFile
    def templateName = "post_login"

    PostLogin() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostLoginChange(this)
    }

    class PostLoginChange extends Change {

        PostLoginChange(Template template) {
            super(template)
        }

        /**
         * Change the login credentials (CPF and password)
         * @param cpf
         * @param password
         */
        void loginCredentials(cpf, password) {
            json.cpf = cpf
            json.password = password
        }

        /**
         * Change the risk score
         * @param riskScore
         */
        void riskScore(riskScore) {
            json.riskScore = riskScore
        }

        void changeRiskScoreAndLatitude(riskScore, latitude) {
            json.riskScore = riskScore
            json.latitude = latitude
        }

        /**
         * Change the latitude and longitude
         * @param latitude
         * @param longitude
         */
        void latitudeAndLongitude(latitude, longitude) {
            json.latitude = latitude
            json.longitude = longitude
        }
    }
}


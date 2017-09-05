package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

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

        void loginCredentials(String cpf, String password) {
            json.username = cpf
            json.password = password
        }

        void riskScore(int riskScore) {
            json.riskScore = riskScore
        }

        void latitudeAndLongitude(int latitude, int longitude) {
            json.latitude = latitude
            json.longitude = longitude
        }
    }

}


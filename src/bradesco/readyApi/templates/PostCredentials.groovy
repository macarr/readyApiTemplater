package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /credentials
 */
class PostCredentials extends Template {

    PostCredentialsChange change
    File templateFile
    def templateName = "GBL_CREDENTIALS_POST_DEFAULT"

    PostCredentials() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostCredentialsChange(this)
    }

    class PostCredentialsChange extends Change {
        PostCredentialsChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

        /**
         * Change the cpf and password
         * @param cpf
         * @param password
         */
        void cpfAndPassword(cpf, password) {
            json.cpf = cpf
            json.password = password
        }

    }

}
package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * Template for POST /vaquinha requests
 */
class PostVaquinha extends Template {

    PostVaquinhaChange change
    File templateFile
    def templateName = "post_vaquinha"

    PostVaquinha() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostVaquinhaChange(this)
    }

    class PostVaquinhaChange extends Change {
        PostVaquinhaChange(Template template) {
            super(template)
        }

        /**
         * Change the amount of the vaquinha
         * @param value
         */
        void amount(String value) {
            json.amount = value
        }

        /**
         * Change the name and description of the vaquinha
         * @param name
         * @param description
         */
        void nameAndDescription(String name, String description) {
            json.name = name
            json.description = description
        }

        /**
         * Change the expiry date of the vaquinha
         * @param expiryDate
         */
        void expiryDate(String expiryDate) {
            json.expiryDate = expiryDate
        }

        /**
         * Change the type code of the vaquinha
         * @param typeCode
         */
        void typeCode(String typeCode) {
            json.typeCode = typeCode
        }

        /**
         * Change the terms and Conditions UID of the vaquinha
         * @param termsAndConditionsUid
         */
        void termsAndConditions(int termsAndConditionsUid) {
            json.termsAndConditionsUID = termsAndConditionsUid
        }

    }

}


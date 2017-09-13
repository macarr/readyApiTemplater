package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST or PUT /vaquinhas
 */
class PostOrPutVaquinhas extends Template {

    PostOrPutVaquinhasChange change
    File templateFile
    def templateName = "GBL_VAQUINHAS_POST_DEFAULT"

    PostOrPutVaquinhas() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostOrPutVaquinhasChange(this)
    }

    class PostOrPutVaquinhasChange extends Change {
        PostOrPutVaquinhasChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

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
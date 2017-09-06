package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

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

        void value(String value) {
            json.value = value
        }

        void nameAndDescription(String name, String description) {
            json.name = name
            json.description = description
        }

        void expiryDate(String expiryDate) {
            json.expiryDate = expiryDate
        }

        void typeCode(String typeCode) {
            json.typeCode = typeCode
        }

        void termsAndConditions(int termsAndConditionsUid) {
            json.termsAndConditionsUID = termsAndConditionsUid
        }

    }

}


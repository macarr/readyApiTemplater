package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PutProfilesFatca extends Template {

    PutProfilesFatcaChange change
    File templateFile
    def templateName = "GBL_PROFILES_PUT_FACTA"

    PutProfilesFatca() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutProfilesFatcaChange(this)
    }

    class PutProfilesFatcaChange extends Change {
        PutProfilesFatcaChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
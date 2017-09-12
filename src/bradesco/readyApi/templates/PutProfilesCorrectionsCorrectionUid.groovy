package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PutProfilesCorrectionsCorrectionUid extends Template {

    PutProfilesCorrectionsCorrectionUidChange change
    File templateFile
    def templateName = "GBL_PROFILES_CORRECTIONS_CORRECTIONUID_PUT_DEFAULT"

    PutProfilesCorrectionsCorrectionUid() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutProfilesCorrectionsCorrectionUidChange(this)
    }

    class PutProfilesCorrectionsCorrectionUidChange extends Change {
        PutProfilesCorrectionsCorrectionUidChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
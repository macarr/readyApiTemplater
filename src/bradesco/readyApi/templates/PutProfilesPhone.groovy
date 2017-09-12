package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PutProfilesPhone extends Template {

    PutProfilesPhoneChange change
    File templateFile
    def templateName = "GBL_PROFILES_PUT_PHONE"

    PutProfilesPhone() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutProfilesPhoneChange(this)
    }

    class PutProfilesPhoneChange extends Change {
        PutProfilesPhoneChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 *
 */
class PutProfilesAddress extends Template {

    PutProfilesAddressChange change
    File templateFile
    def templateName = "GBL_PROFILES_PUT_ADDRESS"

    PutProfilesAddress() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutProfilesAddressChange(this)
    }

    class PutProfilesAddressChange extends Change {
        PutProfilesAddressChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
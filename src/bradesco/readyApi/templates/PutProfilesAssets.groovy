package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PutProfilesAssets extends Template {

    PutProfilesAssetsChange change
    File templateFile
    def templateName = "GBL_PROFILES_PUT_ASSETS"

    PutProfilesAssets() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutProfilesAssetsChange(this)
    }

    class PutProfilesAssetsChange extends Change {
        PutProfilesAssetsChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
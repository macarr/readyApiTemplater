package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PutProfilesFull extends Template {

    PutProfilesFullChange change
    File templateFile
    def templateName = "GBL_PROFILES_PUT_FULL"

    PutProfilesFull() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutProfilesFullChange(this)
    }

    class PutProfilesFullChange extends Change {
        PutProfilesFullChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

        void toAddressDefault() {
            json = [:]
            json << [addresses: ['${LOCAL_JSON_TEMPLATES#TC_ADDRESS_BLOCK_DEFAULT}']]
        }

        void toAssetDefault() {
            json = [:]
            json << [customerAssets: ['${LOCAL_JSON_TEMPLATES#TC_ASSETS_BLOCK_DEFAULT}']]
        }

        void toFatcaDefault() {
            json = [:]
            json << [fatcaResponses: ['${LOCAL_JSON_TEMPLATES#TC_FACTARESPONSE_BLOCK_DEFAULT}']]
        }

        void toPhoneDefault() {
            json = [:]
            json << [phoneNumbers: ['${LOCAL_JSON_TEMPLATES#TC_PHONENUMBER_BLOCK_DEFAULT}']]
        }



    }

}
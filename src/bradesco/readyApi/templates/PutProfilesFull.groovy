package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * PUT /profiles
 *
 * Requires the following ReadyAPI properties to be set:
 *
 * ${LOCAL_JSON_TEMPLATES#TC_ADDRESS_BLOCK_DEFAULT}
 * @see bradesco.readyApi.templates.AddressObject
 * ${LOCAL_JSON_TEMPLATES#TC_ASSET_BLOCK_DEFAULT}
 * @see bradesco.readyApi.templates.AssetObject
 * ${LOCAL_JSON_TEMPLATES#TC_FACTARESPONSE_BLOCK_DEFAULT}
 * @see bradesco.readyApi.templates.FatcaResponseObject
 * ${LOCAL_JSON_TEMPLATES#TC_PHONENUMBER_BLOCK_DEFAULT}
 * @see bradesco.readyApi.templates.PhoneNumberObject
 * ${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_MINUS_6_MONTH}
 */
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

        /**
         * Requires ${LOCAL_JSON_TEMPLATES#TC_ADDRESS_BLOCK_DEFAULT} to be set
         * @see bradesco.readyApi.templates.AddressObject
         */
        void toAddressDefault() {
            json = [:]
            json << [addresses: ['${LOCAL_JSON_TEMPLATES#TC_ADDRESS_BLOCK_DEFAULT}']]
        }

        /**
         * Requires ${LOCAL_JSON_TEMPLATES#TC_ASSETS_BLOCK_DEFAULT} to be set
         * @see bradesco.readyApi.templates.AssetObject
         */
        void toAssetDefault() {
            json = [:]
            json << [customerAssets: ['${LOCAL_JSON_TEMPLATES#TC_ASSETS_BLOCK_DEFAULT}']]
        }

        /**
         * Requires ${LOCAL_JSON_TEMPLATES#TC_FACTARESPONSE_BLOCK_DEFAULT} to be set
         * @see bradesco.readyApi.templates.FatcaResponseObject
         */
        void toFatcaDefault() {
            json = [:]
            json << [fatcaResponses: ['${LOCAL_JSON_TEMPLATES#TC_FACTARESPONSE_BLOCK_DEFAULT}']]
        }

        /**
         * Requires ${LOCAL_JSON_TEMPLATES#TC_PHONENUMBER_BLOCK_DEFAULT} to be set
         * @see bradesco.readyApi.templates.PhoneNumberObject
         */
        void toPhoneDefault() {
            json = [:]
            json << [phoneNumbers: ['${LOCAL_JSON_TEMPLATES#TC_PHONENUMBER_BLOCK_DEFAULT}']]
        }



    }

}
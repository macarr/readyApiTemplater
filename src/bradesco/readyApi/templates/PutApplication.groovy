package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader
import groovy.json.JsonSlurper

class PutApplication extends Template {

    PutApplicationChange change
    File templateFile
    def templateName = "GBL_APPLICATION_PUT_FULL"

    PutApplication() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutApplicationChange(this)
    }

    class PutApplicationChange extends Change {
        PutApplicationChange(Template template) {
            super(template)
        }

        /************************************************
         * Put new change functions beneath this comment *
         ************************************************/

        void phoneNumber(int position, String areaCode, String countryCode, String number) {
            if(json.phoneNumbers[position]) {
                json.phoneNumbers[position].areaCode = areaCode
                json.phoneNumbers[position].countryCode = countryCode
                json.phoneNumbers[position].phoneNumber = number
            }
        }

        void addPhone(String areaCode, String countryCode, String number, String type, String primaryPhoneInd) {
            json.phoneNumbers << [areaCode:areaCode, countryCode:countryCode, phoneNumber:number, phoneType: type, primaryPhoneInd:primaryPhoneInd]
        }

        void toNoNestedJsonDefault() {
            JsonSlurper slurper = new JsonSlurper()
            slurper.parseText(template.escaped)
            json.addresses = null
            json.customerAssets = null
            json.fatcaResponses = null
            json.phoneNumbers = null
            json.proposal = null
        }
    }

}
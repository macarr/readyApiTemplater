package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PutApplications extends Template {

    PutApplicationsChange change
    File templateFile
    def templateName = "put_application"

    PutApplications() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutApplicationsChange(this)
    }

    class PutApplicationsChange extends Change {
        PutApplicationsChange(Template template) {
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
    }

}
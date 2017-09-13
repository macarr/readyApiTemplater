package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader
import groovy.json.JsonSlurper

/**
 * PUT /application
 *
 * Requires the following Ready API properties to be set:
 * ${LOCAL_JSON_TEMPLATES#TC_ADDRESS_BLOCK_DEFAULT}
 * @see bradesco.readyApi.templates.AddressObject
 * ${LOCAL_JSON_TEMPLATES#TC_ASSET_BLOCK_DEFAULT}
 * @see bradesco.readyApi.templates.AssetObject
 * ${LOCAL_JSON_TEMPLATES#TC_FACTARESPONSE_BLOCK_DEFAULT}
 * @see bradesco.readyApi.templates.FatcaResponseObject
 * ${LOCAL_JSON_TEMPLATES#TC_PHONENUMBER_BLOCK_DEFAULT}
 * @see bradesco.readyApi.templates.PhoneNumberObject
 * ${LOCAL_JSON_TEMPLATES#TC_PROPOSAL_BLOCK_DEFAULT}
 * @see bradesco.readyApi.templates.ProposalObject
 * ${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_MINUS_6_MONTH}
 */
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
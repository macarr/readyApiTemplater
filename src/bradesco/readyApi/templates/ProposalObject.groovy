package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * Proposal subobject
 *
 * Requires the following ReadyAPI properties to be set:
 *
 * ${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_PLUS_1_YEAR}
 * ${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_MINUS_1_MONTH}
 * ${LOCAL_JSON_TEMPLATES#TC_PRODUCT_BLOCK_NO_UNIQUEID}
 * @see @see bradesco.readyApi.templates.AccountObject
 */
class ProposalObject extends Template {

    ProposalObjectChange change
    File templateFile
    def templateName = "GBL_PROPOSAL_BLOCK_DEFAULT"

    ProposalObject() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new ProposalObjectChange(this)
    }

    class ProposalObjectChange extends Change {
        ProposalObjectChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

        void removeUniqueId() {
            json.uniqueID = null
        }

    }

}
package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /proposal
 *
 * Requires the following ReadyAPI properties to be set:
 *
 * ${LOCAL_JSON_TEMPLATES#TC_PRODUCT_BLOCK_DEFAULT}
 * @see bradesco.readyApi.templates.ProductObject
 * ${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_PLUS_1_YEAR}
 */
class PostProposal extends Template {

    PostProposalChange change
    File templateFile
    def templateName = "GBL_PROPOSAL_POST_DEFAULT"

    PostProposal() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostProposalChange(this)
    }

    class PostProposalChange extends Change {
        PostProposalChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
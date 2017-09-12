package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

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
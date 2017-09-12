package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

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
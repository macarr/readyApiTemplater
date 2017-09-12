package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class FatcaResponseObject extends Template {

    FatcaResponseObjectChange change
    File templateFile
    def templateName = "GBL_FACTARESPONSE_BLOCK_DEFAULT"

    FatcaResponseObject() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new FatcaResponseObjectChange(this)
    }

    class FatcaResponseObjectChange extends Change {
        FatcaResponseObjectChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
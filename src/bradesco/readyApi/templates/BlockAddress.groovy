package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class BlockAddress extends Template {

    BlockAddressChange change
    File templateFile
    def templateName = "GBL_ADDRESS_BLOCK_DEFAULT"

    BlockAddress() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new BlockAddressChange(this)
    }

    class BlockAddressChange extends Change {
        BlockAddressChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
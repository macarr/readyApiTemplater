package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * Address subobject
 */
class AddressObject extends Template {

    AddressObjectChange change
    File templateFile
    def templateName = "GBL_ADDRESS_BLOCK_DEFAULT"

    AddressObject() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new AddressObjectChange(this)
    }

    class AddressObjectChange extends Change {
        AddressObjectChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * Phone number subobject
 */
class PhoneNumberObject extends Template {

    PhoneNumberObjectChange change
    File templateFile
    def templateName = "GBL_PHONENUMBER_BLOCK_DEFAULT"

    PhoneNumberObject() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PhoneNumberObjectChange(this)
    }

    class PhoneNumberObjectChange extends Change {
        PhoneNumberObjectChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class TransfersRegisterAccount extends Template {

    TransfersRegisterAccountChange change
    File templateFile
    def templateName = "GBL_TRANSFERS_REGISTERACCOUNT_DEFAULT"

    TransfersRegisterAccount() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new TransfersRegisterAccountChange(this)
    }

    class TransfersRegisterAccountChange extends Change {
        TransfersRegisterAccountChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
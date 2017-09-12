package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class AccountBlockObject extends Template {

    AccountBlockObjectChange change
    File templateFile
    def templateName = "GBL_ACCOUNT_BLOCK_DEFAULT"

    AccountBlockObject() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new AccountBlockObjectChange(this)
    }

    class AccountBlockObjectChange extends Change {
        AccountBlockObjectChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
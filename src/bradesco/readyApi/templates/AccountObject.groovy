package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * Account Subobject
 */
class AccountObject extends Template {

    AccountObjectChange change
    File templateFile
    def templateName = "GBL_ACCOUNT_BLOCK_DEFAULT"

    AccountObject() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new AccountObjectChange(this)
    }

    class AccountObjectChange extends Change {
        AccountObjectChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
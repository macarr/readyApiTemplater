package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostAccountsExternalAccounts extends Template {

    PostAccountsExternalAccountsChange change
    File templateFile
    def templateName = "GBL_ACCOUNTS_EXTERNALACCOUNTS_POST_DEFAULT"

    PostAccountsExternalAccounts() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostAccountsExternalAccountsChange(this)
    }

    class PostAccountsExternalAccountsChange extends Change {
        PostAccountsExternalAccountsChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
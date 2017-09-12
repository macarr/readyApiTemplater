package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostAccountsNonNextAccount extends Template {

    PostAccountsNonNextAccountChange change
    File templateFile
    def templateName = "GBL_ACCOUNTS_NONNEXTACCOUNT_POST_DEFAULT"

    PostAccountsNonNextAccount() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostAccountsNonNextAccountChange(this)
    }

    class PostAccountsNonNextAccountChange extends Change {
        PostAccountsNonNextAccountChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
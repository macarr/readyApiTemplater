package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostContactsContactIdAccounts extends Template {

    PostContactsContactIdAccountsChange change
    File templateFile
    def templateName = "GBL_CONTACTS_CONTACTID_ACCOUNTS_POST_DEFAULT"

    PostContactsContactIdAccounts() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostContactsContactIdAccountsChange(this)
    }

    class PostContactsContactIdAccountsChange extends Change {
        PostContactsContactIdAccountsChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
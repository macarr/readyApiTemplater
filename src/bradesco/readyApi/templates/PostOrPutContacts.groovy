package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST or PUT /contacts
 */
class PostOrPutContacts extends Template {

    PostOrPutContactsChange change
    File templateFile
    def templateName = "GBL_CONTACTS_POST_FULL"

    PostOrPutContacts() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostOrPutContactsChange(this)
    }

    class PostOrPutContactsChange extends Change {
        PostOrPutContactsChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

        void removeAccounts() {
            json.remove "accounts"
        }

        void toNoAccountsNoCpfDefault() {
            reset()
            json.remove "accounts"
            json.remove "cpfCnpj"
            json.remove "cpfCnpjType"
        }

    }

}
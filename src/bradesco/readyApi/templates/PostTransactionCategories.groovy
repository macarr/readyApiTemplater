package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /transactionCategories
 */
class PostTransactionCategories extends Template {

    PostTransactionCategoriesChange change
    File templateFile
    def templateName = "GBL_TRANSACTIONCATEGORIES_POST_DEFAULT"

    PostTransactionCategories() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostTransactionCategoriesChange(this)
    }

    class PostTransactionCategoriesChange extends Change {
        PostTransactionCategoriesChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostBudgetsTransactionCategoryId extends Template {

    PostBudgetsTransactionCategoryIdChange change
    File templateFile
    def templateName = "GBL_BUDGETS_TXN_CAT_ID_POST_DEFAULT"

    PostBudgetsTransactionCategoryId() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostBudgetsTransactionCategoryIdChange(this)
    }

    class PostBudgetsTransactionCategoryIdChange extends Change {
        PostBudgetsTransactionCategoryIdChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
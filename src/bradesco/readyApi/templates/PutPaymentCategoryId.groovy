package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PutPaymentCategoryId extends Template {

    PutPaymentCategoryIdChange change
    File templateFile
    def templateName = "GBL_PAYMENT_CATEGORY_ID_PUT_DEFAULT"

    PutPaymentCategoryId() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutPaymentCategoryIdChange(this)
    }

    class PutPaymentCategoryIdChange extends Change {
        PutPaymentCategoryIdChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
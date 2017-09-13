package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * Product subobject
 *
 * Requires the following ReadyAPI properties to be set:
 *
 * ${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_PLUS_1_YEAR}
 * ${#[Main#MAIN_TEST_PARAM#Global_Dates]#GBL_DATE_MINUS_14_DAYS}
 */
class ProductObject extends Template {

    ProductObjectChange change
    File templateFile
    def templateName = "GBL_PRODUCT_BLOCK_FULL"

    ProductObject() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new ProductObjectChange(this)
    }

    class ProductObjectChange extends Change {
        ProductObjectChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

        void removeUniqueId() {
            json.remove uniqueID
        }

    }

}
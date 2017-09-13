package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * Asset subobject
 */
class AssetObject extends Template {

    AssetObjectChange change
    File templateFile
    def templateName = "GBL_ASSET_BLOCK_DEFAULT"

    AssetObject() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new AssetObjectChange(this)
    }

    class AssetObjectChange extends Change {
        AssetObjectChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
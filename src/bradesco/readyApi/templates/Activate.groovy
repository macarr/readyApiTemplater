package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * Activate for P&O
 */
class Activate extends Template {

    ActivateChange change
    File templateFile
    def templateName = "GLB_ACTIVATE"

    Activate() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new ActivateChange(this)
    }

    class ActivateChange extends Change {
        ActivateChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
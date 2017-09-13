package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * Empty template
 */
class Empty extends Template {

    EmptyChange change
    File templateFile
    def templateName = "GLB_EMPTY"

    Empty() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new EmptyChange(this)
    }

    class EmptyChange extends Change {
        EmptyChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostApplicationParameters extends Template {

    PostApplicationParametersChange change
    File templateFile
    def templateName = "GBL_APPLICATIONPARAMETERS_POST_DEFAULT"

    PostApplicationParameters() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostApplicationParametersChange(this)
    }

    class PostApplicationParametersChange extends Change {
        PostApplicationParametersChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
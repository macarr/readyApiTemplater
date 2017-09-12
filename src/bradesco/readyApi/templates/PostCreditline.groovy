package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostCreditline extends Template {

    PostCreditlineChange change
    File templateFile
    def templateName = "GBL_CREDITLINE_POST_DEFAULT"

    PostCreditline() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostCreditlineChange(this)
    }

    class PostCreditlineChange extends Change {
        PostCreditlineChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
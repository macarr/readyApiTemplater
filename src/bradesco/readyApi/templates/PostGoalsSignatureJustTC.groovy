package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostGoalsSignatureJustTC extends Template {

    PostGoalsSignatureJustTCChange change
    File templateFile
    def templateName = "GBL_GOALS_SIGNATURE_POST_JUST_TC"

    PostGoalsSignatureJustTC() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostGoalsSignatureJustTCChange(this)
    }

    class PostGoalsSignatureJustTCChange extends Change {
        PostGoalsSignatureJustTCChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
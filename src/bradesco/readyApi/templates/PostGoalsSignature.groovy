package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /goals/signature
 */
class PostGoalsSignature extends Template {

    PostGoalsSignatureChange change
    File templateFile
    def templateName = "GBL_GOALS_SIGNATURE_POST_JUST_TC"

    PostGoalsSignature() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostGoalsSignatureChange(this)
    }

    class PostGoalsSignatureChange extends Change {
        PostGoalsSignatureChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
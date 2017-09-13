package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /password/check/ivr
 */
class PostPasswordCheckIvr extends Template {

    PostPasswordCheckIvrChange change
    File templateFile
    def templateName = "GBL_PASSWORD_CHECK_IVR_POST_DEFAULT"

    PostPasswordCheckIvr() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostPasswordCheckIvrChange(this)
    }

    class PostPasswordCheckIvrChange extends Change {
        PostPasswordCheckIvrChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /login/ivr
 */
class PostIvrLogin extends Template {

    PostIvrLoginChange change
    File templateFile
    def templateName = "GBL_IVR_LOGIN_POST_DEFAULT"

    PostIvrLogin() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostIvrLoginChange(this)
    }

    class PostIvrLoginChange extends Change {
        PostIvrLoginChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
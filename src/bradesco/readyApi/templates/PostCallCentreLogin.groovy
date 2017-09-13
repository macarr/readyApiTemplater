package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /callCenterLogin
 */
class PostCallCentreLogin extends Template {

    PostCallCentreLoginChange change
    File templateFile
    def templateName = "GBL_CALLCENTERLOGIN_POST_DEFAULT"

    PostCallCentreLogin() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostCallCentreLoginChange(this)
    }

    class PostCallCentreLoginChange extends Change {
        PostCallCentreLoginChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
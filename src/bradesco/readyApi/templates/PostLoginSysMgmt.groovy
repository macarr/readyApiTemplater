package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostLoginSysMgmt extends Template {

    PostLoginSysMgmtChange change
    File templateFile
    def templateName = "GBL_LOGIN_SYSMGMT_POST_DEFAULT"

    PostLoginSysMgmt() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostLoginSysMgmtChange(this)
    }

    class PostLoginSysMgmtChange extends Change {
        PostLoginSysMgmtChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
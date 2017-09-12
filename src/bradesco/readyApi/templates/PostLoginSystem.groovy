package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostLoginSystem extends Template {

    PostLoginSystemChange change
    File templateFile
    def templateName = "GBL_LOGIN_SYSTEM_POST_DEFAULT"

    PostLoginSystem() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostLoginSystemChange(this)
    }

    class PostLoginSystemChange extends Change {
        PostLoginSystemChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
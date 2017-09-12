package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostCardPassword extends Template {

    PostCardPasswordChange change
    File templateFile
    def templateName = "GBL_CARDPASSWORD_POST_DEFAULT"

    PostCardPassword() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostCardPasswordChange(this)
    }

    class PostCardPasswordChange extends Change {
        PostCardPasswordChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
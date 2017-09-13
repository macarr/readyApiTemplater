package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /notification/template
 */
class PostNotificationTemplate extends Template {

    PostNotificationTemplateChange change
    File templateFile
    def templateName = "GBL_NOTIFICATION_TEMPLATE_POST_DEFAULT"

    PostNotificationTemplate() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostNotificationTemplateChange(this)
    }

    class PostNotificationTemplateChange extends Change {
        PostNotificationTemplateChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
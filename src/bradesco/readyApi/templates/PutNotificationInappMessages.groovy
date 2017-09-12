package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PutNotificationInappMessages extends Template {

    PutNotificationInappMessagesChange change
    File templateFile
    def templateName = "GBL_NOTIFICATION_INAPPMESSAGES_PUT_DEFAULT"

    PutNotificationInappMessages() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutNotificationInappMessagesChange(this)
    }

    class PutNotificationInappMessagesChange extends Change {
        PutNotificationInappMessagesChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
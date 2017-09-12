package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostQueue extends Template {

    PostQueueChange change
    File templateFile
    def templateName = "GBL_QUEUE_POST_DEFAULT"

    PostQueue() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostQueueChange(this)
    }

    class PostQueueChange extends Change {
        PostQueueChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
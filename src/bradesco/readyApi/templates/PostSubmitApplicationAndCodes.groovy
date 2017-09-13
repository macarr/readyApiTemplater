package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /submitApplicationAndCodes
 */
class PostSubmitApplicationAndCodes extends Template {

    PostSubmitApplicationAndCodesChange change
    File templateFile
    def templateName = "GBL_SUBMITAPPLICATIONANDCODES_POST_DEFAULT"

    PostSubmitApplicationAndCodes() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostSubmitApplicationAndCodesChange(this)
    }

    class PostSubmitApplicationAndCodesChange extends Change {
        PostSubmitApplicationAndCodesChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
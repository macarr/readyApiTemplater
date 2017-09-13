package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * POST /vaquinhas/signature
 */
class PostVaquinhasSignature extends Template {

    PostVaquinhasSignatureChange change
    File templateFile
    def templateName = "GBL_VAQUINHAS_SIGNATURE_POST_DEFAULT"

    PostVaquinhasSignature() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostVaquinhasSignatureChange(this)
    }

    class PostVaquinhasSignatureChange extends Change {
        PostVaquinhasSignatureChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
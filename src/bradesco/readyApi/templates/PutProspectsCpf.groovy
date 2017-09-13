package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * PUT /prospects/cpf
 */
class PutProspectsCpf extends Template {

    PutProspectsCpfChange change
    File templateFile
    def templateName = "GBL_PROSPECTS_CPF_PUT_DEFAULT"

    PutProspectsCpf() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutProspectsCpfChange(this)
    }

    class PutProspectsCpfChange extends Change {
        PutProspectsCpfChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
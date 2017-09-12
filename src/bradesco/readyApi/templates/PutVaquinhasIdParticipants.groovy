package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PutVaquinhasIdParticipants extends Template {

    PutVaquinhasIdParticipantsChange change
    File templateFile
    def templateName = "GBL_VAQUINHAS_ID_PARTICIPANTS_PUT_DEFAULT"

    PutVaquinhasIdParticipants() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutVaquinhasIdParticipantsChange(this)
    }

    class PutVaquinhasIdParticipantsChange extends Change {
        PutVaquinhasIdParticipantsChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
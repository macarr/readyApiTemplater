package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

/**
 * PUT /vaquinhas/vaquinhaId/participant/participantId/status
 */
class PutVaquinhaIdParticipantIdStatus extends Template {

    PutVaquinhaIdParticipantIdStatusChange change
    File templateFile
    def templateName = "GBL_VAQUINHA_ID_PARTICIPANT_ID_STATUS_PUT_DEFAULT"

    PutVaquinhaIdParticipantIdStatus() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PutVaquinhaIdParticipantIdStatusChange(this)
    }

    class PutVaquinhaIdParticipantIdStatusChange extends Change {
        PutVaquinhaIdParticipantIdStatusChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
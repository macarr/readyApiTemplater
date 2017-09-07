package bradesco.readyApi

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

class Change {

    /**
     * The template that will be changed
     */
    Template template
    /**
     * The current JSON representation of the escaped template, including all changes applied
     * by this Change object
     */
    def json

    Change(Template template) {
        this.template = template
        JsonSlurper jsonSlurper = new JsonSlurper()
        TemplateProcessor.escapeProperties(template)
        json = jsonSlurper.parseText(template.escaped)
    }

    /**
     * Write out the changes contained in the json field to a String
     * @return the original template with changes applied
     */
    String apply() {
        template.escaped = new JsonBuilder(json).toPrettyString()
        TemplateProcessor.restoreProperties(template)
        return template.body
    }

    void theseFields(Map replacements) {
        replacements.keySet().each {
            json."$it" = replacements.get(it)
        }
    }

}

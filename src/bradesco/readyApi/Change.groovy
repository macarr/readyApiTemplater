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

    private JsonSlurper slurper = new JsonSlurper()

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

    /**
     * Provided a map of field:value pairs, replace the value of each field with
     * the provided value
     *
     * e.g. theseFields([foo:"Bar", qux:"baz"]) will replace the value of foo with "Bar"
     * and the value of qux with "Baz"
     * @param replacements the replacements map
     */
    void theseFields(Map replacements) {
        replacements.keySet().each {
            json."$it" = replacements.get(it)
        }
    }

    /**
     * Open a dialog displaying the outcome of all the changes that have been applied to the
     * template so far
     *
     * Helpful for debugging
     */
    void show() {
        TemplateViewer.viewChange(new JsonBuilder(json).toPrettyString())
    }

    /**
     * Reload the template with default values
     */
    void reset() {
        json = slurper.parseText(template.escaped)
    }

}

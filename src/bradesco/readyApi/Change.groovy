package bradesco.readyApi

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

class Change {

    /**
     * The template that will be changed
     */
    Template template
    /**
     * The current JSON representation of the tokenized template, including all changes applied
     * by this Change object
     */
    def json

    Change(Template template) {
        this.template = template
        JsonSlurper jsonSlurper = new JsonSlurper()
        TemplateProcessor.tokenize(template)
        json = jsonSlurper.parseText(template.tokenized)
    }

    /**
     * Write out the changes contained in the json field to a String
     * @return the original template with changes applied
     */
    String apply() {
        template.tokenized = new JsonBuilder(json).toString()
        TemplateProcessor.deTokenize(template)
        return template.body
    }

    /**
     * Replace a json field with a property token that will be replaced with a
     * ReadyAPI property when the changes are applied
     * @param key the json key to replace
     * @param propertyName the property to replace the value with
     */
    void keyToProperty(String key, String propertyName) {
        def count = template.tokensmap.size()
        def token = '$$token' + count + '$$'
        json."$key" = token
        def property = '${' + propertyName + '}'
        template.tokensmap << [(token):property]
    }

}

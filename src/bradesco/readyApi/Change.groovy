package bradesco.readyApi

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

class Change {

    Template template
    def json

    Change(Template template) {
        this.template = template
        JsonSlurper jsonSlurper = new JsonSlurper()
        TemplateProcessor.tokenize(template)
        json = jsonSlurper.parseText(template.tokenized)
    }

    String apply() {
        template.tokenized = new JsonBuilder(json).toString()
        TemplateProcessor.deTokenize(template)
        return template.body
    }

    void keyToProperty(String key, String propertyName) {
        def count = template.tokensmap.size()
        def token = '$$token' + count + '$$'
        json."$key" = token
        def property = '${' + propertyName + '}'
        template.tokensmap << [(token):property]
    }

}

package bradesco.readyApi

class TemplateProcessor {

    /**
     * Tokenize a template, replacing ReadyAPI properties with property tokens in order
     * to create well-formed JSON
     * @param template the template to escapeProperties
     */
    static void escapeProperties(Template template) {
        def text = template.body

        //replace all ${expression} with "${expression}" so that we end up with valid JSON
        for(def i=0; i<text.length(); i++) {
            if(text[i] == '$' && text[i+1] == '{') {
                def end = text.indexOf('}', i)
                if(end == -1) {
                    println("\${ with no matching close bracket")
                    continue
                }
                def property = text[i..end]
                text = "${text.substring(0, i)}\"$property\"${text.substring(end+1, text.length())}"
                i++
            }
        }
        template.escaped = text
    }

    /**
     * Detokenize a template, replacing property tokens with ReadyAPI properties so that
     * it can be used as a ReadyAPI request object. The template will most likely no
     * longer be valid JSON.
     * @param template The template to detokenize
     */
    static void restoreProperties(Template template) {
        def text = template.escaped
        //unquote all properties
        for(def i=0; i<text.length(); i++) {
            if(text[i] == '"' && text[i+1] == '$' && text[i+2] == '{') {
                def end = text.indexOf('}', i)
                if(end == -1) {
                    println("\${ with no matching close bracket")
                    continue
                }
                if(text[end+1] != '"') {
                    println "escaped property missing closing quote"
                    continue
                }
                def property = text[i+1..end]
                text = "${text.substring(0, i)}\"$property\"${text.substring(end+2, text.length())}"
            }
        }
        template.body = text
    }

}

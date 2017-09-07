package bradesco.readyApi

class TemplateProcessor {

    /**
     * Tokenize a template, replacing ReadyAPI properties with property tokens in order
     * to create well-formed JSON
     * @param template the template to tokenize
     */
    static void tokenize(Template template) {
        def count = 0
        def text = template.body
        def tokensMap = [:]

        //replace all ${expression} with "$$token#$$" so that we end up with valid JSON
        for(def i=0; i<text.length(); i++) {
            if(text[i] == '$' && text[i+1] == '{') {
                def end = text.indexOf('}', i)
                if(end == -1) {
                    println("\${ with no matching close bracket")
                    continue
                }
                def key = '\"$$token' + count + '$$\"'
//                println key
                tokensMap << [(key):text[i..end]]
                text = "${text.substring(0, i)}$key${text.substring(end+1, text.length())}"
                count++
            }
        }
//        println tokensMap
//        println text
        template.tokenized = text
        template.tokensmap = tokensMap
    }

    /**
     * Detokenize a template, replacing property tokens with ReadyAPI properties so that
     * it can be used as a ReadyAPI request object. The template will most likely no
     * longer be valid JSON.
     * @param template The template to detokenize
     */
    static void deTokenize(Template template) {
        def text = template.tokenized
        template.tokensmap.each {
            text = text.replace(it.key.toString(), it.value.toString())
        }
        template.body = text
    }

}

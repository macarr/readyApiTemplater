package bradesco.readyApi

class TemplateProcessor {

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
                println key
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

    static void deTokenize(Template template) {
        def text = template.tokenized
        template.tokensmap.each {
            text = text.replace(it.key.toString(), it.value.toString())
        }
        template.body = text
    }

}

package bradesco.readyApi

class Template {

    /**
     * The file this template is sourced from
     */
    File file
    /**
     * The user-friendly title of this template
     */
    String title
    /**
     * The mapping name of this template
     */
    String name
    /**
     * The text body of this template (pre-edit)
     */
    String body
    /**
     * The text body of this template, with ReadyAPI properties replaced with property tokens
     * (e.g. ${propertyname} ==> $$token0$$)
     */
    String tokenized
    /**
     * The map of property tokens to ReadyAPI property names
     */
    Map tokensmap

    /**
     * Load this template with the data from its source file
     * @param file
     */
    void load(File file) {
        this.file = file
        StringBuilder sb = new StringBuilder("")
        def getTitle = true
        def getName = false
        file.eachLine { line ->
            if(getTitle) {
                title = line
                getTitle = false
                getName = true
            } else if(getName) {
                getName = false
                name = line
            } else {
                sb.append(line)
            }
        }
        body = sb.toString()
//        println "Name: $name"
//        println "Body: $body"
    }

    /**
     * Revert this template to its detokenized form
     * @return
     */
    String build() {
        TemplateProcessor.deTokenize(this)
    }
}

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
     * The text body of this template, with ReadyAPI properties escaped
     * (e.g. ${propertyname} ==> $$token0$$)
     */
    String escaped

    /**
     * Load this template with the data from its source file
     * @param file
     */
    void load(File file) {
        this.file = file
        StringBuilder sb = new StringBuilder("")
        def getTitle = false
        def getName = true
        try {
            file.eachLine { line ->
                if (getName) {
                    name = line
                    getTitle = true
                    getName = false
                } else if (getTitle) {
                    getTitle = false
                    title = line
                } else {
                    sb.append(line + "\n")
                }
            }
        } catch (NullPointerException e) {
            throw new RuntimeException("Failed to process template $file. If this is null, the template map has not been loaded with this template", e)
        }
        body = sb.toString()
    }
}

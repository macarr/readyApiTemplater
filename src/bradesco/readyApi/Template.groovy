package bradesco.readyApi

class Template {

    File file
    String title
    String name
    String body
    String tokenized
    Map tokensmap

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

    String build() {
        TemplateProcessor.deTokenize(this)
    }
}

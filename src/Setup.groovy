import groovy.sql.Sql

def sql = Sql.newInstance("jdbc:sqlite:readyApi.db", "org.sqlite.JDBC")

def templatesSql = new File("../resources/json_templates.sql")
def suitesSql = new File("../resources/test_suites.sql")
def stepsSql = new File("../resources/test_steps.sql")
def editsSql = new File("../resources/template_edits.sql")

def sqlFiles = [templatesSql, suitesSql, stepsSql, editsSql]

sqlFiles.each { file ->
    println("Reading file [" + file.name + "]")
    sql.withBatch { stmt ->
        file.text.split(';').each { order ->
            if(order.trim()) {
                println("Adding [" + order.trim().substring(0, 20) + "] to batch")
                stmt.addBatch order.trim()
            }
        }
        println "Executing batch"
    }
}
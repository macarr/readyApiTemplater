import bradesco.readyApi.TemplateLoader
import bradesco.readyApi.templates.LoginDeviceJsonTemplate
import bradesco.readyApi.templates.PostLoginTemplate

def cpf = "88888888888"
def password = "88888888888"
def deviceId = "FV92J3N847YG9W873452GHJ9"

/*
    Ideally this method will always be run in the project setup script
*/
TemplateLoader.generateTemplateMap()

/*
    Old method, not sure about suitability
 */
//def template = TemplateLoader.pick()

PostLoginTemplate postLoginTemplate = new PostLoginTemplate()

//println template
//println template.name
//println template.file.path
println "Original:::\t$postLoginTemplate.body"
postLoginTemplate.change.loginCredentials(cpf, password)
postLoginTemplate.change.riskScore(4)
def output = postLoginTemplate.change.apply()
println "Output:::\t\t$output"
//testRunner.testCase.setPropertyValue('template', output)

LoginDeviceJsonTemplate deviceJsonTemplate = new LoginDeviceJsonTemplate()
println "Original:::\t$deviceJsonTemplate.body"
deviceJsonTemplate.change.deviceId(deviceId)
output = deviceJsonTemplate.change.apply()
println "Output:::\t\t$output"
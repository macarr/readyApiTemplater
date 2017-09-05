import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader
import bradesco.readyApi.TemplateViewer
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
//Change Creator Test

Template template = new Template()
template.load(TemplateViewer.pick())

TemplateViewer.createChange(template)
*/

//Template Viewer Test

//TemplateViewer.view()



/*
//Specific Change Test

PostLoginTemplate postLoginTemplate = new PostLoginTemplate()
println "Original:::\t$postLoginTemplate.body"
postLoginTemplate.change.loginCredentials(cpf, password)
postLoginTemplate.change.riskScore(4)
def output = postLoginTemplate.change.apply()
println "Output:::\t\t$output"
//testRunner.testCase.setPropertyValue('template', output)

LoginDeviceJsonTemplate deviceJsonTemplate = new LoginDeviceJsonTemplate()
println "Original:::\t$deviceJsonTemplate.body"
deviceJsonTemplate.change.deviceId(deviceId)
deviceJsonTemplate.change.phoneNumber(1, 416, 5551234)
output = deviceJsonTemplate.change.apply()
println "Output:::\t\t$output"*/



/*//Generic Change Test

PostLoginTemplate postLoginTemplate = new PostLoginTemplate()
println "Original:::\t$postLoginTemplate.body"
postLoginTemplate.change.allOf([cpf:'1234567890', password:'thisis_apassword'])
def output = postLoginTemplate.change.apply()
println "Output:::\t\t$output"*/

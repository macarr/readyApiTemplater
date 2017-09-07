import bradesco.readyApi.TemplateLoader
import bradesco.readyApi.TemplateProcessor
import bradesco.readyApi.TemplateViewer
import bradesco.readyApi.templates.DeviceObject
import bradesco.readyApi.templates.PostLogin
import bradesco.readyApi.templates.PostVaquinha
import bradesco.readyApi.templates.PutApplications

def cpf = "88888888888"
def password = "88888888888"
def deviceId = "FV92J3N847YG9W873452GHJ9"

/*
    Ideally this method will always be run in the project setup script
*/
TemplateLoader.generateTemplateMap()
//TemplateProcessor.createTemplateClassFile("PutApplications", TemplateViewer.pick())

//TemplateViewer.createChange(new PostLogin())
//Change Creator Test
/*
Template template = new Template()
template.load(TemplateViewer.pick())

TemplateViewer.createChange(template)*/

//Template Viewer Test

//TemplateViewer.view()



//Specific Change Test

PostLogin postLoginTemplate = new PostLogin()
println "Original:::\t$postLoginTemplate.body"
postLoginTemplate.change.loginCredentials(cpf, password)
postLoginTemplate.change.riskScore(4)
def output = postLoginTemplate.change.apply()
println "Output:::\t\t$output\n"
//testRunner.testCase.setPropertyValue('template', output)

DeviceObject deviceJsonTemplate = new DeviceObject()
println "Original:::\t$deviceJsonTemplate.body"
deviceJsonTemplate.change.deviceId(deviceId)
deviceJsonTemplate.change.phoneNumber(1, 416, 5551234)
output = deviceJsonTemplate.change.apply()
println "Output:::\t\t$output\n"

PostVaquinha vaquinha = new PostVaquinha()
println "Original:::\t$vaquinha.body"
vaquinha.change.amount('${#TestCase#amount}')
vaquinha.change.theseFields([name:"Matt C", description:"This is a test vaquinha!"])
output = vaquinha.change.apply()
println "Output:::\t\t$output\n"

PutApplications applications = new PutApplications()
println "Original:::\t$applications.body"
applications.change.phoneNumber(0, "416", "1", "5551234")
applications.change.addPhone("647", "1", "1110987", "6", "N")
println "Output:::\t\t${applications.change.apply()}"



//Generic Change Test

/*PostLogin postLoginTemplate = new PostLogin()
println "Original:::\t$postLoginTemplate.body"
postLoginTemplate.change.allOf([cpf:'1234567890', password:'thisis_apassword'])
def output = postLoginTemplate.change.apply()
println "Output:::\t\t$output"*/

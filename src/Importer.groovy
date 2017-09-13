import bradesco.readyApi.*
import bradesco.readyApi.templates.*

def cpf = "88888888888"
def password = "88888888888"
def deviceId = "FV92J3N847YG9W873452GHJ9"

/*
    Always run these methods before testing
*/
TemplateLoader.templateLocation = './bradesco/readyApi/templates'
TemplateLoader.generateTemplateMap()
//====================================================================

/*
    Create a new Template class
 */
//TemplateProcessor.createTemplateClassFile(TemplateViewer.pick())

/*
    View all template files
 */
TemplateViewer.view()

/*
    Create a change method for a template
 */
/*Template template = new Template()
template.load(TemplateViewer.pick())

TemplateViewer.createChange(template)*/

//Specific Change Test

/*
def postLoginTemplate = new PostLogin()
println "Original:::\t$postLoginTemplate.body"
postLoginTemplate.change.loginCredentials(cpf, password)
postLoginTemplate.change.riskScore(4)
def output = postLoginTemplate.change.apply()
println "Output:::\t\t$output\n"

def deviceJsonTemplate = new DeviceObject()
println "Original:::\t$deviceJsonTemplate.body"
deviceJsonTemplate.change.deviceId(deviceId)
deviceJsonTemplate.change.phoneNumber(1, 416, 5551234)
output = deviceJsonTemplate.change.apply()
println "Output:::\t\t$output\n"

def vaquinha = new PostOrPutVaquinhas()
println "Original:::\t$vaquinha.body"
vaquinha.change.amount('${#TestCase#amount}')
vaquinha.change.theseFields([name:"Matt C", description:"This is a test vaquinha!"])
output = vaquinha.change.apply()
println "Output:::\t\t$output\n"

def applications = new PutApplication()
println "Original:::\t$applications.body"
applications.change.toNoNestedJsonDefault()
println "Output:::\t\t${applications.change.apply()}"



def contacts = new PostOrPutContacts()
println "Original:::\t$contacts.body"
contacts.change.toNoAccountNoCpfDefault()
println "Output:::\t\t${contacts.change.apply()}"

PostPreregistrationsOnboardingStatus onboardingStatus = new PostPreregistrationsOnboardingStatus()
println "Original:::\t$onboardingStatus.body"
onboardingStatus.change.toRejectedDefault()
println "Output:::\t\t${onboardingStatus.change.apply()}"
*/


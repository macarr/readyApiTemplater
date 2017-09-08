SCRIPT STORAGE LOCATION:

{Nextbank Project Location}\nextbank\next-integration-tests\next-soapui\scripts

TEMPLATE FILE STORAGE LOCATION:

{ReadyAPI Installation Folder}\bin\resources

TEMPLATE CLASS FILE STORAGE LOCATION:

{Script Storage Location}\bradesco\readyApi\templates

=====================================================================================

INSTALLATION INSTRUCTIONS:

checkout project:
git clone https://github.com/macarr/readyApiTemplater.git

copy readyApiTemplater/src/bradesco folder to {SCRIPT STORAGE LOCATION} (above)

copy readyApiTemplater/resources folder to {TEMPLATE FILE STORAGE LOCATION} (above)

=====================================================================================

READYAPI SETUP:

Create a new Test Suite+Case with three Groovy Script steps. These will be for
standalone helper scripts.

SETUP STEP:

TemplateLoader.generateTemplateMap()

(this must be run before any testing can be performed)

CREATE NEW TEMPLATE CLASS STEP:

(this will be used to create a new template groovy file for use in test setup,
replace {name} with the name you wish to use for the file, e.g. GetCustomerInfo)

TemplateLoader.createTemplateClassFile({name}, TemplateViewer.pick())

CREATE NEW CHANGE FUNCTION STEP:

(this will be used to create a change function, which will be pasted into the
template groovy file and used to change template data)

Template template = new Template()
template.load(TemplateViewer.pick())
TemplateViewer.createChange(template)

=====================================================================================

For more details on how these tools work, please see readyApiTemplater\output\index.html
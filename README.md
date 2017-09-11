<h1>Important Information</h1></h1>
Please make note of the following information before proceeding with installation

<h2>ReadyAPI Installation Folder</h2>
This will be different per computer, but you will likely find it in one of the following 
locations:

C:\Program Files\SmartBear\ReadyAPI-2.1.0\

C:\Program Files(x86)\SmartBear\ReadyAPI-2.1.0\bin\scripts\bradesco\readyApi

C:\Program Files\SmartBear\ReadyAPI-1.8.0\bin\scripts\bradesco\readyApi

C:\Program Files(x86)\SmartBear\ReadyAPI-1.8.0\bin\scripts\bradesco\readyApi

<h2>Nextbank Project Location</h2>
This is where the nextbank code and tests are checked out to. This will be different per 
computer.

<h2>Script Storage Location</h2>
{Nextbank Project Location}\nextbank\next-integration-tests\next-soapui\scripts

<h2>Template File Storage Location</h2>
{ReadyAPI Installation Folder}\bin\resources

<h2>Template Class File Storage Location</h2>
{Script Storage Location}\bradesco\readyApi\templates

<h1>Installation Instructions</h1>

<ol><li>checkout project to the location of your choice, using the following command in 
git bash (or your git client of choice):

git clone https://github.com/macarr/readyApiTemplater.git
<li>close readyAPI
<li>copy readyApiTemplater/src/bradesco folder to {SCRIPT STORAGE LOCATION} (above)
<li>copy readyApiTemplater/resources folder to {TEMPLATE FILE STORAGE LOCATION} (above)
<li>open readyAPI
</ol>

<h1>READYAPI SETUP</h1>

Create a new Test Suite and Test Case named "Test Utilities" (or your choice of alternative). 
This will be where your standalone test tools are located.

<h3>SETUP STEP:</h3>

Create a new Groovy Script Step called "Load Templates" (or your choice of alternative) and
copy the following code into it: 

```TemplateLoader.generateTemplateMap()```

This must be run before any testing can be performed.

<h3>CREATE NEW TEMPLATE CLASS STEP:</h3>

Create a new Groovy Script Step called "Create New Template" (or your choice of alternative)
and copy the following code into it:

```TemplateProcessor.createTemplateClassFile("{name}", TemplateViewer.pick())```

This will be used to create new template groovy file for use in test setup, replace {name}
with the name you wish to use for the file, e.g. GetCustomerInfo)

<h3>CREATE NEW CHANGE FUNCTION STEP:</h3>

Create a new Groovy Script Step called "Create New Change Function" (or your choice of 
alternative) and copy the following code into it:

```
Template template = new Template()
template.load(TemplateViewer.pick())
TemplateViewer.createChange(template)
```

This will be used to create a change function, which you will then paste into the
template groovy file and then use in your groovy scripts to to change template data)

<h1>Use In Groovy Scripting</h1>

TBC

For more details on how these tools work, please see readyApiTemplater\output\index.html
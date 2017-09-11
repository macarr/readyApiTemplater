<h1>Important Information</h1>
Please make note of the following information before proceeding with installation

##ReadyAPI Installation Folder
This will be different per computer, but you will likely find it in one of the following 
locations:

C:\Program Files\SmartBear\ReadyAPI-2.1.0\

C:\Program Files(x86)\SmartBear\ReadyAPI-2.1.0\bin\scripts\bradesco\readyApi

C:\Program Files\SmartBear\ReadyAPI-1.8.0\bin\scripts\bradesco\readyApi

C:\Program Files(x86)\SmartBear\ReadyAPI-1.8.0\bin\scripts\bradesco\readyApi

##Nextbank Project Location
This is where the nextbank code and tests are checked out to. This will be different per 
computer.

##Script Storage Location
{Nextbank Project Location}\nextbank\next-integration-tests\next-soapui\scripts

##Template File Storage Location
{ReadyAPI Installation Folder}\bin\resources

##Template Class File Storage Location
{Script Storage Location}\bradesco\readyApi\templates

#Installation Instructions

<ol><li>checkout project to the location of your choice, using the following command in 
git bash (or your git client of choice):

git clone https://github.com/macarr/readyApiTemplater.git
<li>close readyAPI
<li>copy readyApiTemplater/src/bradesco folder to {SCRIPT STORAGE LOCATION} (above)
<li>copy readyApiTemplater/resources folder to {TEMPLATE FILE STORAGE LOCATION} (above)
<li>open readyAPI
</ol>

#READYAPI SETUP

Create a new Test Suite and Test Case named "Test Utilities" (or your choice of alternative). 
This will be where your standalone test tools are located.

###SETUP STEP:

Create a new Groovy Script Step called "Load Templates" (or your choice of alternative) and
copy the following code into it: 

```TemplateLoader.generateTemplateMap()```

This must be run before any testing can be performed.

###CREATE NEW TEMPLATE CLASS STEP:

Create a new Groovy Script Step called "Create New Template" (or your choice of alternative)
and copy the following code into it:

```TemplateProcessor.createTemplateClassFile("{name}", TemplateViewer.pick())```

This will be used to create new template groovy file for use in test setup, replace {name}
with the name you wish to use for the file, e.g. GetCustomerInfo)

###CREATE NEW CHANGE FUNCTION STEP:

Create a new Groovy Script Step called "Create New Change Function" (or your choice of 
alternative) and copy the following code into it:

```
Template template = new Template()
template.load(TemplateViewer.pick())
TemplateViewer.createChange(template)
```

This will be used to create a change function, which you will then paste into the
template groovy file and then use in your groovy scripts to to change template data)

#Use In Groovy Scripting

TBC

For more details on how these tools work, please see readyApiTemplater\output\index.html
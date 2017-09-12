<h1>Important Information</h1>
Please make note of the following information before proceeding with installation

<h2>Nextbank Project Location</h2>
This is where the nextbank code and tests are checked out to. This will be different per 
computer.

<h2>Script Storage Location</h2>
{Nextbank Project Location}\nextbank\next-integration-tests\next-soapui\scripts<br /><br />
This is where Ready API reads external script libraries from. 

<h2>Core Groovy Code Storage Location</h2>
{Script Storage Location}\bradesco\readyApi<br /><br />
This is where the core Groovy code that controls the scripts is stored

<h2>Groovy Template File Storage Location</h2>
{Script Storage Location}\bradesco\readyApi\templates<br /><br />
This is where the Groovy code that controls Templates and Template changes is stored

<h2>Raw Template Storage Location</h2>
{Groovy Template File Storage Location}\rawTemplates<br /><br />
This is where the raw templates (the .template files) that are used to define request bodies are
stored

<h1>Installation Instructions</h1>

<ol><li>checkout project to the location of your choice, using the following command in 
git bash (or your git client of choice):

git clone https://github.com/macarr/readyApiTemplater.git

Ensure this is a location you can easily find again (e.g. C:\\, My Documents, Downloads, etc).
The code will be checked out to {location}/readyApiTemplater/, herefore referred to as {project
checkout location}
<li>close readyAPI
<li>copy readyApiTemplater/src/bradesco folder to {SCRIPT STORAGE LOCATION} (above)
<li>open readyAPI
</ol>

<h1>READYAPI SETUP</h1>

Create a new Test Suite and Test Case named "Test Utilities" (or your choice of alternative). 
This will be where your standalone test tools are located. These are not meant to be run as a
complete test suite/case. Instead, you should run scripts individually as you require them.

<h3>SETUP STEP</h3>

Create a new Groovy Script Step called "Load Script Data" (or your choice of alternative) and
copy the following code into it: 

```
import bradesco.readyApi.*
/*
    Always run these methods before testing
*/
TemplateProcessor.templateLocation = "${context.expand('${projectDir}')}\\next-soapui\\scripts\\bradesco\\readyApi\\templates"
TemplateLoader.generateTemplateMap()
```

This must be run before any testing can be performed.

<h3>CREATE NEW TEMPLATE CLASS STEP</h3>

Create a new Groovy Script Step called "Create New Template" (or your choice of alternative)
and copy the following code into it:

```
import bradesco.readyApi.*
TemplateProcessor.createTemplateClassFile(TemplateViewer.pick())
```

This will be used to create new template groovy file for use in test setup. When you complete the
process, the program will attempt to create the new groovy file in the same location as the rest
of the template .groovy files. If it cannot, it will show all the data you need to do so yourself in an
output dialog window.

<h3>CREATE NEW CHANGE FUNCTION STEP</h3>

Create a new Groovy Script Step called "Create New Change Function" (or your choice of 
alternative) and copy the following code into it:

```
import bradesco.readyApi.*
Template template = new Template()
template.load(TemplateViewer.pick())
TemplateViewer.createChange(template)
```

This will be used to create a change function, which you will then paste into the
template .groovy file and then use in your ReadyAPI groovy scripts to to change template data

<h3>SHOW ALL TEMPLATES STEP</h3>

Create a new Groovy Script Step called "Show Templates" (or your choice of 
alternative) and copy the following code into it: 

```
import bradesco.readyApi.*
TemplateViewer.view()
```

This will be used to open a viewer in which you can display the contents of any template file
in your currently configured templates directory

<h1>Use In Groovy Scripting</h1>

TBC

<h1>Troubleshooting</h1>

TBC

<h1>GroovyDoc</h1>

For more details on how these tools work, please see readyApiTemplater\output\index.html
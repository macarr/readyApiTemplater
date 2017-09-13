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
<li>copy {project checkout location}/src/bradesco folder to {SCRIPT STORAGE LOCATION} (above)
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
TemplateLoader.templateLocation = "${context.expand('${projectDir}')}\\next-soapui\\scripts\\bradesco\\readyApi\\templates"
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

<h2>Setting up a Test Case</h2>
 
Start by importing the files to your script:
```
import bradesco.readyApi.*
import bradesco.readyApi.templates.*
```

Look in the groovydoc (see bottom of page) for the template you wish to load, e.g. for
POST /vaquinhas, we will use the PostOrPutVaquinhas template class

```
def vaquinhasTemplate = new PostOrPutVaquinhas()
```

Using the functions described in the template change object (usually {templateName}Change.groovy,
in this case PostOrPutVaquinhasChange), alter the template with the values you want to change. This is
done by giving instructions to the template class's Change object, which can be instructed via
{templateVariableName}.change (in this case, vaquinhasTemplate.change). You can use the change
functions you have created, or that are described in the groovydoc to change the contents of the
template.

```
vaquinhaTemplate.change.amount("15")
``` 

If you wish to add a Ready API property to your template for later substitution, you can
set it in the same manner.

```
vaquinhaTemplate.change.typeCode('${DataSource Create Vaquinha#Type Code}')
```

Note that you must set up a ReadyAPI property with the appropriate name and scope in order for
this to work when used in a REST call (in this case, you must have a property named "Type Code"
in the "DataSource Create Vaquinha" scope).

If you wish to see what the template will look like with your changes, tell the Change object
to display them with the .show() function, which will display a window with the full template,
with your changes (as above) applied

```
vaquinhaTemplate.change.show()
```


With the previously displayed changes, this will show a window containing the text of the
PostOrPutVaquinhas template, with the amount changed to 15 and the name changed to 
"${DataSource Create Vaquinha#Name}". Be sure to remove this when you are finished with your
test case, otherwise it will pop up every time this script is run.

Once you have finished with your changes, you need to save them to a Ready API property so that
other test steps can access them.

First, apply your changes

```
def output = vaquinhaTemplate.change.apply()
```

This fills in the templates with your changed values, and saves the entire thing to a string
variable (in this case, called "output")
 
Next, set up the Ready API property. We do this by calling 
testRunner.testCase.setPropertyValue({propertyName}, {propertyValue}). This saves the value in
{propertyValue} to the test case's custom properties section under the name {propertyName}. In
our example, we will call our {propertyName} "vaquinhaBody", and give it the output of apply()
that we saved to the variable "output" in the previous step.

```
testRunner.testCase.setPropertyValue("vaquinhaBody", output)
```

Now, if you run the script, you will see that in the definition of the Test Case it resides
within, under the "Custom Properties" tab, there is a new property with the name "vaquinhaBody"
and a value that looks like the request body for the POST or PUT /vaquinhas endpoint. You are
now ready to use this in a REST call.

To perform the rest call, simply place the property in the section that you would normally have
the full JSON request body, like so:

```
${vaquinhaBody}
```
 
This will automatically be replaced with the request body that we saved to the property in the
previous step. Set your headers and query parameters as usual, and execute the REST step. Once
it finishes, look at the Raw tab of the request. It should look something like this:

```
{
    "amount": "15",
    "description": "QaVaqCreateName6",
    "expiryDate": "2018-07-20",
    "name": "QaVaqCreateName6",
    "termsAndConditionsUID": "2",
    "typeCode": Carnaval,
    "vaquinhaTypeCode": "Carnaval"
}
```

Note that we had previously used 
```vaquinhaTemplate.change.typeCode('${DataSource Create Vaquinha#Type Code}')```
to change the field "vaquinhaTypeCode" to "${DataSource Create Vaquinha#Type Code}". As you
can see in the output, this has been automatically substituted with the value of the ReadyApi
property "DataSource Create Vaquinha#Type Code" we had created with the value of "Carnaval".
Additionally, you can see that the value of "amount" has been changed to 15.

In general, the process you will follow to set up a REST call is as follows:
1. Load the appropriate template
(```def variablename = new TemplateYouWantToUse()```)
2. Use change functions to alter the template
(```variableName.change.changeFunction(value1, value2)```)
3. Repeat step 2 as necessary
4. Apply the changes and export to a variable
(```def outputVariable = variableName.change.apply()```)
5. Create a ReadyAPI property with the output
(```testRunner.testCase.setProperty("propertyName", outputVariable)```)
6. Create a REST step, using the new property as the request body
(```${#TestCase#propertyName)```)

<h2>Creating a new change function
 

<h1>Troubleshooting</h1>

<h3>FileNotFoundException</h3>

ReadyApi doesn't know where to find your template files. Run the "Load Script Data" script to
set the location.

<h3>NullPointerException when trying to see template files</h3>

ReadyApi hasn't loaded your templates into memory yet. Run the "Load Script Data" script to load 
the data into memory

<h3>MissingPropertyException</h3>

ReadyApi hasn't imported the groovy code required to run your script. Make sure your script has
the following code at the top:
```
import bradesco.readyApi.*
import bradesco.readyApi.templates.*
```

<h1>GroovyDoc</h1>

For more details on how these tools work, please see {project checkout location}\output\index.html
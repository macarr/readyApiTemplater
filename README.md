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
"${DataSource Create Vaquinha#Name}". Be sure to remove this line when you are finished with your
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

<h2>Creating a new change function</h2>

If you need to change a field in a template, but a function doesn't exist that does what you
need yet, you need to create it and paste it into the template .groovy file manually.

To do so, first find the file you need to edit. In this example, we will use the template for
POST /credentials, PostCredentials.groovy. This file can be found in {Groovy Template File
Storage Location}. In my case, this is located in
C:\nextbank\next-integration-tests\next-soapui\scripts\bradesco\readyApi\templates .

Next, open the file with a text editor - preferably something code-sensitive like Notepad++
or Sublime Text. This will display the full code of the template file.

```
package bradesco.readyApi.templates

import bradesco.readyApi.Change
import bradesco.readyApi.Template
import bradesco.readyApi.TemplateLoader

class PostCredentials extends Template {

    PostCredentialsChange change
    File templateFile
    def templateName = "GBL_CREDENTIALS_POST_DEFAULT"

    PostCredentials() {
        templateFile = TemplateLoader.fetch(templateName)
        load(templateFile)
        this.change = new PostCredentialsChange(this)
    }

    class PostCredentialsChange extends Change {
        PostCredentialsChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }

}
```

The only part that you will need to worry about in this case is the part at the end between
the second time the word "class" appears, and the second-last closing curly brace:

```
class PostCredentialsChange extends Change {
        PostCredentialsChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/

    }
```

This is called the Change class. The names will change based on what file you are editing
(so, for example, in PostOrPutVaquinhas.groovy, this would say PostOrPutVaquinhasChange
instead of PostCredentialsChange). In some cases, the "Put new change functions beneath
this comment:" section may be missing, but it's not important. Just make sure that your new
functions always go between the closing curly brace of the constructor (the brace on the line right after
```super(template)```) and the closing curly brace of the class (the curly brace on the
second-last line of the file.

There are two ways of creating a change function.

<h3>Automatically</h3>

Run the (#Create New Change Function Step) script. This will load a window that allows you
to input a name and select the fields in the template that you wish to change. Check the box
next to each field that you wish to change and click the "Save" button on the lower left of
the window. The text area in the lower right of the window will populate with the function
that you need to copy. In our case, we will frequently want to change the cpf and password, 
so we will select the checkboxes next to those and name the function cpfAndPassword. This
will output the following:

```
void cpfAndPassword(cpf, password) {
	json.cpf = cpf
	json.password = password
}
```

Which we will then paste into the appropriate location in the PostCredentials.groovy file. The
Change class now looks like this:

```
class PostCredentialsChange extends Change {
        PostCredentialsChange(Template template) {
            super(template)
        }
        
        /************************************************
        * Put new change functions beneath this comment *
        ************************************************/
        
        void cpfAndPassword(cpf, password) {
        	json.cpf = cpf
        	json.password = password
        }

    }
```

and we can use the new function in setup scripts:

```
def template = new PostCredentials()
template.change.cpfAndPassword(cpf, password)
```

**Keep in Mind:** the naming conventions are designed to ensure that the scripts are as easy
to read as possible, and so that when you read the script you will have a general idea of what
is happening. In this example, we named the new function cpfAndPassword, the line we use to
execute this function looks like ```template.change.cpfAndPassword```, which reads like an
instruction. We are telling the ```template``` to ```change``` the ```cpf And Password```. This
reads nicer than, for example, calling the function ```setupTheCredentials```, which will look
like ```template.change.setupTheCredentials```. While still a valid function name, this does
not read as nicely as the previous instruction (telling the ```template``` to ```change``` the
```setupTheCredentials``` is a nonsensical instruction to a human).

<h3>Manually</h3>

If you feel slightly more proficient at coding, or if you need to set up a slightly more
complicated change, you can create one manually. This will not require you to run the
"Create New Change Function" script. 

Each change object has access to a variable called "json". This variable contains the JSON
representation of the template, and is what the Change class edits when you execute a change
function.

Functions follow a basic structure:

```
void functionName(newValue1, newValue2, ..., lastNewValue) {
    json.fieldToChange1 = newValue1
    json.fieldToChange2 = newValue2
    ...
    json.lastFieldToChange = lastNewValue
}
```

For a simple example, we will manually create the same function we created in the Automatic
section:

```
void cpfAndPassword(newCpf, newPassword) {
    json.cpf = newCpf
    json.password = newPassword
}
```

Here, we have named our function "cpfAndPassword" (per the naming conventions at the end of
the "Automatic" section), given it two new values, and changed those fields in the JSON to
the new values. 

For a more advanced example, we will create a default setup method. Say, for example, we
regularly have to call POST /credentials with a certain set of values in order to create
credentials for a VIP customer. We can use a change function to set these up all at once,
without requiring us to provide those values every time:

```
void toVipCredentials() {
    reset()
    json.cpf = "12345678901"
    json.password = "0987896789"
    json.invitationId = "f29h847"
}
```

Here, we set our template to the default (using ```reset()```), and set each field of our
request body with the value that it will take when we create credentials for this VIP.

There are a couple of important things to note here:

1 - ```reset()```. This is a function I have not yet mentioned. You will likely not have to
use it very often. All it does is reset the changes to the defaults. This is helpful if you
are reusing the same template variable to set up different calls, e.g.:

```
def template = new PostCredentials()
template.change.cpf("2569348756293")
testRunner.testCase.setPropertyValue("postCredentials1", template.change.apply())
template.reset()
template.change.password("23457896")
testRunner.testCase.setPropertyValue("postCredentials2", template.change.apply())
``` 

In this case, we are using the same template (so that we don't have to ```def``` a new
variable - this lowers the lines of code we need), but resetting it after changing the CPF
for postCredentials1 so that that CPF change doesn't affect postCredentials2.

We use this in our default template setup so that we clear out any other changes, so that the
function operates as expected. This leads us to our second point.

2 - Naming. In the Automatic section, we mentioned naming conventions, and how to select
function names for human readability. Note that in our new function, we've selected the name
```toVipCredentials```. This will read in the code as ```template.change.toVipCredentials```.
This succeeds in our goal of making script commands read like human commands - we are telling
the ```template``` to ```change``` ```toVipCredentials```, i.e. change the template into
vip credentials.

In a final example, we will use more advanced JSON principles. Please ensure that you understand
JSON fundamentals before attempting this - additionally, most developers will be able to help
you. In groovy, it is possible to address JSON using its native notation. If a JSON object
is contained in a variable, you can access fields in that object by executing the command
```variable.field```. If the field is a sub-object (i.e. an object contained within another
object), you can access the fields of that sub-object in the same way by adding another dot
after the field of the sub-object, followed by the name of a field inside the sub-object,
e.g. ```variable.subObjectField.field```. If the field is a list, you can use array notation
to access the n'th element of that list (where n is the numeric position of the element you want),
e.g. ```variable.listField[n]```. For example, given the following JSON object:
 
```
{
   name: "Robert",
   phoneNumber: {
       "areaCode":416,
       "number":5551234
   },
   nicknames: ["bob", "rob", "bert"]
}
```

stored in the variable named "person":

```person.name``` would result in "Robert"

```person.phoneNumber.number``` would result in 5551234

```person.nicknames[1]``` would result in "rob" (remember - arrays start at 0!)

these are all interchangeable - if each nickname was a subobject, you could access fields of
that subobject with ```person.nickname[1].fieldName```. If phoneNumber.number was a list of
phone numbers, you would get the first number using ```person.phoneNumber.number[0]```, et
cetera.

We will apply this to the PUT /applications template (PutApplications). This template contains
one phone number by default. We want to change the field "primaryPhoneInd" in that one phone
number. The root object is stored in the json variable of the Change class. The phone numbers
are a list in the root object under the field "phones". The function to execute this change is
as follows:

```
void firstPhonePrimaryPhoneInd(primaryPhoneInd) {
    json.phones[0].primaryPhoneInd = primaryPhoneInd
}
```

<h3>Advanced Scripting</h3>

All of these scripts are run with groovy. If you have learned some groovy and feel comfortable
with more complex logic, feel free to use it in these scripts. Certain features, like adding
an extra element to a list, or checking to see if an element exists, may be required for more
complex functions.

<h3>Quick Advanced Command Reference</h3>

```json.remove "key"``` => removes the "key" field from the json object

e.g.
```
start:
{
  "foo":"bar",
  "qux":"baz"
}

json.remove "foo"

result:
{
  "qux":"baz"
}
```

```json.list << newListElement``` => adds another element to a list

e.g.
```
start:
{
  "foo":["bar", "baz"]
}

json.foo << "qux"

result:
{
  "foo":["bar", "baz", "qux"]
}
```

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
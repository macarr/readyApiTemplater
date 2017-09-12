package bradesco.readyApi

import groovy.swing.SwingBuilder

import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JOptionPane
import javax.swing.ListSelectionModel
import java.awt.Dimension

class TemplateViewer {

    /**
     * Display a Template viewer
     */
    static void view() {
        def templates = TemplateLoader.loadTemplates(TemplateLoader.getTemplateFiles())
        def templateNames = templates.collect { it.name }
        def templateMap = TemplateLoader.mapLoadedTemplates(templates)
        new SwingBuilder().edt {
            dialog(modal: true,
                    title: 'Template Viewer',
                    alwaysOnTop: true,
                    resizable: true,
                    locationRelativeTo: null,
                    pack: true,
                    show: true,
                    defaultCloseOperation: JFrame.DISPOSE_ON_CLOSE
            ) {
                vbox {
                    label(text: "Template Viewer")
                    hbox {
                        vbox {
                            label(text: "Template Name")
                            scrollPane {
                                list(id: 'templateName', items: templateNames,
                                        visibleRowCount: 10, selectionMode: ListSelectionModel.SINGLE_SELECTION,
                                        size: new Dimension(100, 1))
                            }
                            button(defaultButton: true, text: 'Select', actionPerformed: {
                                Template template = templateMap.get(templateName.selectedValuesList[0])
                                templateView.setText(template ? "${template.title}\n\n${template.body}": "")
                            })
                        }
                        vbox {
                            label(text: "Template Text")
                            scrollPane {
                                textArea(id: 'templateView', lineWrap: true, size: new Dimension(500, 1))
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * View the provided change output in a dialog
     * @param changeOutput the result of Change.apply()
     */
    static void viewChange(String changeOutput) {
        new SwingBuilder().edt {
            dialog(modal: true,
                    title: 'Change Viewer',
                    alwaysOnTop: true,
                    resizable: true,
                    locationRelativeTo: null,
                    pack: true,
                    show: true,
                    defaultCloseOperation: JFrame.DISPOSE_ON_CLOSE
            ) {
                vbox() {
                    label(text: "The results of your applied changes are shown below")
                    textArea(text: changeOutput)
                }
            }
        }
    }

    /**
     * Using the json values of the provided template, open a dialog to select values to include
     * in a change function
     *
     * @param template the template to source data from
     */
    static void createChange(Template template) {
        Change change = new Change(template)
        def json = change.json
        def frame = new SwingBuilder()
        frame.frame(title: 'Create a change',
                resizable: true,
                locationRelativeTo: null,
                pack: true,
                show: true,
                defaultCloseOperation: JFrame.DISPOSE_ON_CLOSE) {
            hbox() {
                vbox() {
                    scrollPane() {
                        panel(size: new Dimension(0, 400)) {
                            gridLayout(cols: 2, rows: 0)
                            label(text: "Name of the function to be created:")
                            textField(id: "functionName")
                            label(text: "Fields to change:")
                            label()
                            json.keySet().each { key ->
                                label(text: key)
                                if (json.get(key) instanceof Map) {
                                    label(text: "subobject")
                                } else {
                                    checkBox(id: key)
                                }
                            }

                        }
                    }
                    button(defaultButton: true, text: "Save", actionPerformed: {
                        if(frame.functionName.getText().matches("[a-zA-Z0-9]+")) {
                            def edits = []
                            json.keySet().each {
                                if (frame."$it".isSelected()) {
                                    edits << it
                                }
                            }
                            if(edits.isEmpty()) {
                                JOptionPane.showMessageDialog(null,
                                        "Please select at least one field to edit",
                                        "Invalid number of fields", JOptionPane.WARNING_MESSAGE)
                            } else {
                                println(edits)
                                StringBuilder sb = new StringBuilder("void ${frame.functionName.getText()}(")
                                edits.each { sb.append("$it, ") }
                                sb.replace(sb.length() - 2, sb.length(), ") {\n")
                                edits.each {
                                    sb.append("\tjson.$it = $it\n")
                                }
                                sb.append("}")
                                frame.output.text = sb.toString()
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Function name should have letters and numbers only",
                                    "Invalid function name", JOptionPane.WARNING_MESSAGE)
                        }
                    })
                }
                vbox() {
                    label(text: "<html>Copy the text below into the $template.title template file<br />" +
                            "under ${TemplateLoader.templateLocation}</html>", horizontalTextPosition: JLabel.CENTER)
                    textArea(id: "output", editable: false, size: new Dimension(200, 200))
                }
            }
        }
    }

    /**
     * Open a list of all template files, and return the selected file
     *
     * @return the file selected when the "Select" button is pressed, or null if the window is
     * closed or the button is pressed without anything selected
     */
    static File pick() {
        def templateNames = TemplateLoader.templatesMap.keySet().asList()
        def templateKey = null
        new SwingBuilder().edt {
            dialog(modal: true,
                    title: 'Pick a Template File',
                    alwaysOnTop: true,
                    resizable: true,
                    locationRelativeTo: null,
                    pack: true,
                    show: true,
                    defaultCloseOperation: JFrame.DISPOSE_ON_CLOSE
            ) {
                vbox { // Put everything below each other
                    label(text: "Choose a template File")
                    scrollPane {
                        list(id: 'templateName', items: templateNames, visibleRowCount: 10)
                    }
                    button(defaultButton: true, text: 'Select', actionPerformed: {
                        templateKey = templateName.selectedValuesList
                        dispose() // Close dialog
                    })
                }
            }
        }
//        println templateKey[0].getClass()
//        println(templateKey[0])
        return TemplateLoader.fetch(templateKey[0].toString())
    }

    /**
     * Show the results of TemplateProcessor.createTemplateClassFile(), in the case that
     * it is unable to write the file to the configured location
     *
     * @param name The name of the file
     * @param classStructure the text of the class file, to be copied into {template location}/{name}.groovy
     */
    static void showClass(String name, String classStructure) {
        new SwingBuilder().edt {
            dialog(modal: true,
                    title: 'Class structure',
                    alwaysOnTop: true,
                    resizable: true,
                    locationRelativeTo: null,
                    pack: true,
                    show: true,
                    defaultCloseOperation: JFrame.DISPOSE_ON_CLOSE
            ) {
                vbox{ // Put everything below each other
                    label(text: "File exists, please manually overwrite.")
                    label(text: "Place this in bradesco/readyApi/templates/${name}.groovy")
                    textArea(text: classStructure, size: new Dimension(400,400))
                    label(text: "Remember to restart ReadyAPI to use the new file!")
                }
            }
        }
    }
}

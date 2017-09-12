package bradesco.readyApi

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import groovy.swing.SwingBuilder

import javax.swing.JFrame
import javax.swing.JLabel
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
                    title: 'Enter program name',
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
     * Unsupported
     * @param template
     */
    static void createChange(Template template) {
        Change change = new Change(template)
        def json = change.json
        def frame = new SwingBuilder()
        frame.frame(title: 'Enter program name',
                alwaysOnTop: true,
                resizable: true,
                locationRelativeTo: null,
                pack: true,
                show: true) {
            hbox() {
                panel() {
                    gridLayout(cols: 2, rows:0)
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
                    button(defaultButton: true, text: "Save", actionPerformed: {
                        def edits = []
                        json.keySet().each {
                            if (frame."$it".isSelected()) {
                                edits << it
                            }
                        }
                        println(edits)
                        StringBuilder sb = new StringBuilder("void ${frame.functionName.getText()}(")
                        edits.each { sb.append("$it, ")}
                        sb.replace(sb.length() - 2, sb.length(), ") {\n")
                        edits.each {
                            sb.append("\tjson.$it = $it\n")
                        }
                        sb.append("}")
                        frame.output.text = sb.toString()
                    })
                }
                vbox() {
                    label(text: "Copy the text below into the $template.title template file", horizontalTextPosition: JLabel.CENTER)
                    textArea(id: "output", editable: false, size: new Dimension(200, 200))
                }
            }
        }
    }

    /**
     * Unsupported
     * @return
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

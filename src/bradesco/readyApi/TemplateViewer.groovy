package bradesco.readyApi

import groovy.swing.SwingBuilder
import org.apache.tools.ant.taskdefs.Java

import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.ListSelectionModel
import javax.swing.event.DocumentListener
import java.awt.Dimension

class TemplateViewer {

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
                                def template = templateMap.get(templateName.selectedValuesList[0])
                                templateView.setText(template ? template.body : "")
                            })
                        }
                        vbox {
                            label(text: "Template Text")
                            textArea(id: 'templateView', lineWrap: true, size: new Dimension(200, 1))
                        }
                    }
                }
            }
        }
    }

    static JPanel jsonToPanel(def json) {

    }

    static void createChange(Template template) {
        Change change = new Change(template)
        def editMap = [:]
        def json = change.json
        def sb = new SwingBuilder()
        sb.frame(title: 'Enter program name',
                alwaysOnTop: true,
                resizable: true,
                locationRelativeTo: null,
                pack: true,
                show: true,
                defaultCloseOperation: JFrame.EXIT_ON_CLOSE) {
            gridLayout(columns:2, rows: json.keySet().size() + 2)
            label(text: "thing")
            label()
            json.keySet().each { key ->
                label(text: key)
                if(json.get(key) instanceof Map) {
                    label(text: "subobject")
                } else {
                    textField(id: key, text:json.get(key)).document.addDocumentListener(
                            [insertUpdate: {e ->
                                println "${e.getDocument().getText(0, e.getDocument().getLength())} ::: ${json.get(key)}"
                                if(!sb."$key".getText().equals(json.get(key).toString())) {
                                    sb."$key".background = java.awt.Color.ORANGE
                                }else {
                                    sb."$key".background = java.awt.Color.WHITE
                                }
                            },
                            removeUpdate: { e ->
                                println "${e.getDocument().getText(0, e.getDocument().getLength())} ::: ${json.get(key)}"
                                if(!sb."$key".getText().equals(json.get(key).toString())) {
                                    sb."$key".background = java.awt.Color.ORANGE
                                }else {
                                    sb."$key".background = java.awt.Color.WHITE
                                }
                            },
                            changedUpdate: {}] as DocumentListener)
                }
            }
            button(defaultButton: true, text:"Save", actionPerformed: {
                def edits = [:]
                json.keySet().each {
                    println "${sb."$it".getText()} ::: ${json.get(it)} ::: ${!sb."$it".getText().equals(json.get(it).toString())} "
                    if(!sb."$it".getText().equals(json.get(it).toString())) {
                        edits << [(it):sb."$it".getText()]
                    }
                }
                println(edits)
            })
        }
    }

    static File pick() {
        def templateNames = TemplateLoader.templatesMap.keySet().asList()
        def templateKey = null
        new SwingBuilder().edt {
            dialog(modal: true,
                    title: 'Enter program name',
                    alwaysOnTop: true,
                    resizable: true,
                    locationRelativeTo: null,
                    pack: true,
                    show: true
            ) {
                vbox { // Put everything below each other
                    label(text: "Template Name")
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
}

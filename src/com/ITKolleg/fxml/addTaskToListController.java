package com.ITKolleg.fxml;

import com.ITKolleg.Aufgabe;
import com.ITKolleg.AufgabenListe;
import com.ITKolleg.Einzelaufgabe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Lässt den Benutzer eine Liste aussuchen und fügt dieser eine Ausgesuchte Aufgabe hinzu
 *
 *
 */
public class addTaskToListController {

    @FXML
    private Label head1;
    @FXML
    private ListView<String> listOfLists;
    @FXML
    private ListView listOfTasks;
    @FXML
    private Button end;

    private AufgabenListe toAdd;

    private AufgabenListe list;

    /**
     * Konstruktor setzt die Default liste und startet das füllen der List Views
     */
    public addTaskToListController() {
         toAdd=aufgabenmanagerController.getList();

    }

    /**
     * Füllt die Listen und wartet auf Klicks
     */
    @FXML
    public void initialize(){
        fillList();
    }
    private void fillList() {
        listOfLists.setOpacity(1);
        head1.setOpacity(1);
        listOfTasks.setOpacity(0);
        list = aufgabenmanagerController.getList();
        if (list.getAufgaben().size() == 0) {
            list.getAufgaben().add(new AufgabenListe("Nothing here"));
            {

            }
            ArrayList<AufgabenListe> listSort = new ArrayList<>();
            for (Aufgabe a : list.getAufgaben()) {
                if (a instanceof AufgabenListe) {
                    listSort.add((AufgabenListe) a);
                }
            }
            ArrayList<String> beschreibungen = new ArrayList<>();
            for (Aufgabe a : listSort) {
                beschreibungen.add(a.getBeschreibung());

            }

            listOfLists.getItems().setAll(beschreibungen);
            listOfLists.setOnMouseClicked(new EventHandler<MouseEvent>() {
                /**
                 * Wird auf eine Liste geklickt wird diese gespeichert und die Aufgaben die hinzugefügt werden können werden angezeigt
                 * @param event
                 */
                @Override
                public void handle(MouseEvent event) {
                    String description = (String) listOfLists.getSelectionModel().getSelectedItem();


                    for (Aufgabe a : list.getAufgaben()) {
                        if (description == a.getBeschreibung()) {
                            toAdd = (AufgabenListe) a;

                        }

                    }
                    listOfLists.setOpacity(0);
                    head1.setOpacity(0);
                    listOfTasks.setOpacity(1);
                    ArrayList<String> tasksToChose = new ArrayList<>();
                    for (Aufgabe a : aufgabenmanagerController.getList().getAufgaben()) {
                        tasksToChose.add(a.getBeschreibung());

                    }
                    listOfTasks.setItems(FXCollections.observableArrayList(tasksToChose));
                    listOfTasks.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        /**
                         * Fügt die ausgewählte Aufgabe der entsprechenden Liste hinzu
                         * @param event
                         */
                        @Override
                        public void handle(MouseEvent event) {
                            String description = (String) listOfTasks.getSelectionModel().getSelectedItem();
                            for (Aufgabe a : aufgabenmanagerController.getList().getAufgaben()) {
                                if (a.getBeschreibung() == description) {
                                    toAdd.getAufgaben().add(a);

                                }
                            }
                        }
                    });
                }
            });
        }
    }

    /**
     * Schließt das Fenster
     * @param event
     */
        @FXML
        public void end(ActionEvent event)
        {
            Stage stage1 = (Stage) end.getScene().getWindow();
            stage1.close();
        }
        }



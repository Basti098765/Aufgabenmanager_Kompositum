package com.ITKolleg.fxml;

import com.ITKolleg.AufgabenListe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * Kontrolliert die Basis navigation auf die einzellnen Formulare
 */
public class aufgabenmanagerController {
    @FXML
    private Button newTask;
    @FXML
    private Button newTaskList;
    @FXML
    private Button addTaskToList;
    @FXML
    private Button showDone;
    @FXML
    private Button showToDo;
    @FXML
    private Button markDone;
    private static AufgabenListe list;

    /**
     * Setzt die Standard Aufgabenliste
     */
    public aufgabenmanagerController()
{
    list =new AufgabenListe("Alle Aufgaben");
}

    /**
     * ruft beim Klick loadStage() mit dem Namen der FXML Datei auf
     * @param event
     */
    public void newTask(ActionEvent event)
    {
    loadStage("newTask");

    }
    /**
     * ruft beim Klick loadStage() mit dem Namen der FXML Datei auf
     * @param event
     */
    public void newTaskList(ActionEvent event)
    {
    loadStage("newTaskList");
    }
    /**
     * ruft beim Klick loadStage() mit dem Namen der FXML Datei auf
     * @param event
     */
    public void addTaskToList(ActionEvent event)
    {
    loadStage("addTaskToList");
    }
    /**
     * ruft beim Klick loadStage() mit dem Namen der FXML Datei auf
     * @param event
     */
    public void showDone (ActionEvent event)
    {
    loadStage("showDone");
    }
    /**
     * ruft beim Klick loadStage() mit dem Namen der FXML Datei auf
     * @param event
     */
    public void showToDo(ActionEvent event)
    {
    loadStage("showUndone");
    }
    /**
     * ruft beim Klick loadStage() mit dem Namen der FXML Datei auf
     * @param event
     */
    public void markDone(ActionEvent event)
    {
        loadStage("markDone");

    }
    /**
     * Öffnet die jeweilige Stage die im Vorhinein ausgesucht wurde
     * @param link der Name der fxml Datei
     */
    public void loadStage(String link)
    {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(link + ".fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));


            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static AufgabenListe getList()
    {
        return list;
    }
    public static void setList(AufgabenListe liste)
    {
        list=liste;
    }
}

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


    public void newTask(ActionEvent event)
    {
    loadStage("newTask");

    }
    public void newTaskList(ActionEvent event)
    {
    loadStage("newTaskList");
    }
    public void addTaskToList(ActionEvent event)
    {
    loadStage("addTaskToList");
    }
    public void showDone (ActionEvent event)
    {
    loadStage("showDone");
    }
    public void showToDo(ActionEvent event)
    {
    loadStage("showToDo");
    }
    public void markDone(ActionEvent event)
    {
        loadStage("markDone");

    }
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

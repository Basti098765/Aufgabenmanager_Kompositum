package com.ITKolleg.fxml;

import com.ITKolleg.Aufgabe;
import com.ITKolleg.AufgabenListe;
import com.ITKolleg.Einzelaufgabe;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.event.ActionEvent;

public class newTaskListController {
    @FXML
    private TextField beschreibung;
    @FXML
    private Button end;

    private AufgabenListe list;

    @FXML
    /**
     * Erstelllt eine neue Aufgabenliste z
     */
    public void submit(ActionEvent event)
    {
        list= aufgabenmanagerController.getList();
        AufgabenListe a = new AufgabenListe(beschreibung.getText());
        a.hinzufuegen(new Einzelaufgabe("def"));
        list.hinzufuegen(a);
        aufgabenmanagerController.setList(list);
        beschreibung.setText("");


    }
    @FXML
    public void end(ActionEvent event)
    {
            Stage stage1 = (Stage) end.getScene().getWindow();
            stage1.close();
    }

}

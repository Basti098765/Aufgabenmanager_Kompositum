package com.ITKolleg.fxml;

import com.ITKolleg.Aufgabe;
import com.ITKolleg.AufgabenListe;
import com.ITKolleg.Einzelaufgabe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class newTaskControll {
    @FXML
    private TextField beschreibung;
    @FXML
    private Button end;
    private AufgabenListe list;

    @FXML
    public void submit(ActionEvent event)
    {
        list= aufgabenmanagerController.getList();
        Aufgabe a = new Einzelaufgabe(beschreibung.getText());
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

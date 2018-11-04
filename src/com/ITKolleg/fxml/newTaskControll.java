package com.ITKolleg.fxml;

import com.ITKolleg.Aufgabe;
import com.ITKolleg.AufgabenListe;
import com.ITKolleg.Einzelaufgabe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class newTaskControll {
    @FXML
    private TextField beschreibung;

    private AufgabenListe list;


    public void submit(ActionEvent event)
    {
        list= aufgabenmanagerController.getList();
        Aufgabe a = new Einzelaufgabe(beschreibung.getText());
        list.hinzufuegen(a);
        aufgabenmanagerController.setList(list);
        beschreibung.setText("");

    }

}

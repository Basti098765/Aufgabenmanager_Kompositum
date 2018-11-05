package com.ITKolleg.fxml;

import com.ITKolleg.Aufgabe;
import com.ITKolleg.AufgabenListe;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;


public class markDoneController {
    @FXML
    private Button end;
    @FXML
    private ListView undone;
    private AufgabenListe all;
    private AufgabenListe undoneList;
    public markDoneController()
    {
        all = aufgabenmanagerController.getList();
        loadList();
    }
    public void loadList(){
        ArrayList<String> done=  new ArrayList<>();
        for (Aufgabe a: all.getAufgaben())
        {
            if(!a.istErledigt())
            {
                done.add(a.getBeschreibung());
            }


        }
        if(done.size() ==0)
        {
            done.add("Alles erledigt");

        }
        undone.setItems(FXCollections.observableArrayList(done));

        undone.setOnMouseClicked(new EventHandler<MouseEvent>() {
            /**
             * Fügt die ausgewählte Aufgabe der entsprechenden Liste hinzu
             * @param event
             */
            @Override
            public void handle(MouseEvent event) {
                String description = (String) undone.getSelectionModel().getSelectedItem();
                for (Aufgabe a : aufgabenmanagerController.getList().getAufgaben()) {
                    if (a.getBeschreibung() == description) {
                        a.wirdErledigt();

                    }
                }
            }
        });
    }



    @FXML
    public void end(ActionEvent event)
    {
        Stage stage1 = (Stage) end.getScene().getWindow();
        stage1.close();
    }
}

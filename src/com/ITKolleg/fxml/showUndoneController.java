package com.ITKolleg.fxml;

import com.ITKolleg.Aufgabe;
import com.ITKolleg.AufgabenListe;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.ArrayList;

public class showUndoneController {
    @FXML
    private ListView doneList;
    @FXML
    private Button end;
    private AufgabenListe all;
    public showUndoneController()
    {
        all = aufgabenmanagerController.getList();

    }
    @FXML
    public void initialize(){
        loadList();
    }

    /**
     * Befüllt die Kiste mit allen Aufgaben die nicht erledigt sind
     */
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
        doneList.setItems(FXCollections.observableArrayList(done));


    }
    @FXML
    public void end(ActionEvent event)
    {
        Stage stage1 = (Stage) end.getScene().getWindow();
        stage1.close();
    }
}

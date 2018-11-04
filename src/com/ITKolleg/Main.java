package com.ITKolleg;

import com.ITKolleg.fxml.aufgabenmanagerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    //Startet die erste Scene
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/aufgabenmanager.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Aufgabenmananger");
        primaryStage.setScene(new Scene(root, 1080, 720));
        loader.<aufgabenmanagerController>getController().setList(new AufgabenListe("Alle Meine Aufgaben"));;
        primaryStage.show();
    }

}

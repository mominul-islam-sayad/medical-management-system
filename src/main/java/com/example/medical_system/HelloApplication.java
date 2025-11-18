package com.example.medical_system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Welcome_Page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Medical system");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        DataBaseManagement db = new DataBaseManagement();
//        System.out.println("working ...");
        launch();

    }

}
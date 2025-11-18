package com.example.medical_system;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationPageController extends Thread{
    @FXML
    private TextField UserName;
    @FXML
    private TextField UserPassword;
    @FXML
    private TextField Address;
    @FXML
    private TextField Age;
    @FXML
    private TextField Blood_Group;
    @FXML
    private TextField UserID;
    private Stage stage;
    private Scene scene;

    DataBaseManagement db = new DataBaseManagement();
//     int age = Integer.parseInt(Age.getText());

//    public void switchToSuccessfulPage(ActionEvent event) throws IOException {
////        try {
////            db.addNewUser(UserID.getText(), UserName.getText(), UserPassword.getText(), Address.getText(), Age.getText(), Blood_Group.getText());
////        }catch (Exception e1) {
////            System.out.println(e1);
////        }
////        try {
////
////            Parent root = FXMLLoader.load(getClass().getResource("SuccessfullPage.fxml"));
////            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
////            scene = new Scene(root);
////            stage.setScene(scene);
////            stage.show();
////        }catch (Exception exception){
////            System.out.println(exception);
////        }
//    }

    public void backToWelcomePage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Welcome_Page.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void nextToHomePage (ActionEvent event) throws IOException{
        if (UserName.getText().isEmpty() || UserPassword.getText().isEmpty() || Address.getText().isEmpty() || Age.getText().isEmpty() || Blood_Group.getText().isEmpty() ) {
            if (UserName.getText().isEmpty()){
                UserName.setStyle("-fx-border-color: #ff0b0b");
            }
            else{
                UserName.setStyle("-fx-border-color: DEFAULT");
            }
            if(UserPassword.getText().isEmpty()) {
                UserPassword.setStyle("-fx-border-color: #ff0b0b");
                System.out.println("Button working");
            }
            else {
                UserPassword.setStyle("-fx-border-color: DEFAULT");
            }
            if(Address.getText().isEmpty()){
                Address.setStyle("-fx-border-radius: RED");
            }
            else{
                Address.setStyle("-fx-border-color: DEFAULT");
            }
            if(Age.getText().isEmpty()){
                Age.setStyle("-fx-border-color: RED");
            }
            else{
                Age.setStyle("-fx-border-color: DEFAULT");
            }
            if(Blood_Group.getText().isEmpty()){
                Blood_Group.setStyle("-fx-border-color: RED");
            }
            else{
                Blood_Group.setStyle("-fx-border-color: DEFAULT");
            }
        }
        else{
            new Thread(() -> {
                try {
                    db.addNewUser(UserName.getText(), UserPassword.getText(), Address.getText(), Age.getText(), Blood_Group.getText());

                    Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }catch (Exception exception){
                    System.out.println(exception);
                }
            }).start();

        }
    }
}

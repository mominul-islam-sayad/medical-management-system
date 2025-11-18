package com.example.medical_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginPageController extends Thread{
    DataBaseManagement dataBaseManagement = new DataBaseManagement();

//
//    @FXML
//    private ComboBox<String> myChoiceBox;

//    @FXML
//    private Label passwordHint ;
    String currentUser;
    String[] user = {"Public", "Admin"};

    private Stage stage;
    private Scene scene;

    @FXML
    private TextField User_Name;

    @FXML
    private TextField User_Password;

    @FXML
    public void backToWeclomePage (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Welcome_Page.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void nextToHomePage(ActionEvent event) {

        new Thread(() -> {
            try {
//            passwordHint.setText(" ");
                if (User_Name.getText().isEmpty() || User_Password.getText().isEmpty()) {
                    if (User_Name.getText().isEmpty()) {
                        User_Name.setStyle("-fx-border-color: RED");
                    } else {
                        User_Name.setStyle("-fx-border-color: DEFAULT");
                    }
                    if (User_Password.getText().isEmpty()) {
                        User_Password.setStyle("-fx-border-color: RED");
                    }
                }
                else if (dataBaseManagement.userAuthentication(User_Name.getText(), User_Password.getText())) {
                    Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
//            else{
//                passwordHint.setText("Incorrect Password or UserName");
//            }

//        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
            }catch (Exception e){
                System.out.println(e);
            }
        }).start();

    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        myChoiceBox.getItems().addAll(user);
//    }
//
//    public void getUser(ActionEvent event){
//        this.currentUser = myChoiceBox.getValue();
//
//    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        buttonToHomePage.setOnAction(event -> {
//
//        });
//    }
}

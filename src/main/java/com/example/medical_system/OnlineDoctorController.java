package com.example.medical_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OnlineDoctorController implements Initializable {
    Stage stage;
    Scene scene;
    @FXML
    private VBox pnItems = null;
    private Label Name;
    private Label Department;
    private Label PhoneNo;

    String[] Doctors = new String[3];
    ItemController itemController = new ItemController();
    DataBaseManagement dataBaseManagement = new DataBaseManagement();



    public void HospitalInfoButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void AmbulanceServiceButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AmbulanceService.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Node [] nodes = new Node[3];

        for (int i = 0; i< dataBaseManagement.noOfRowInDb(); i++){
            try{
                final int j = i;

//                nodes[i] = FXMLLoader.load(getClass().getResource(itemController.changeSecen()));
//                pnItems.getChildren().add(nodes[i]);
                nodes[i] = itemController.sakib(i);

            }catch(Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

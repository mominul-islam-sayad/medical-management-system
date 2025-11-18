package com.example.medical_system;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;

import java.io.IOException;

public class ItemController {

    @FXML
    private Label DoctorLabelName ;
    @FXML
    private Label doctorsDepartment;
    @FXML
    private Label doctorsPhoneNumber;
    DataBaseManagement db = new DataBaseManagement();

//    ItemController(){
//        DoctorLabelName.setText("zaber");
//        System.out.println("Executing ItemController");
//    }

    public Label getDoctorLabelName() {
        return DoctorLabelName;
    }

    String changeSecen(){
        DoctorLabelName.setText("Al");
        return "HospitalItem.fxml";

    }

    public Node sakib(int no) throws IOException {
        String nto =db.infoOfDoctor(no);
        DoctorLabelName.setText(nto);
        doctorsDepartment.setText(nto);
        doctorsPhoneNumber.setText(nto);
        Node node = FXMLLoader.load(getClass().getResource("DoctorsItem.fxml"));
        return node;
    }
}

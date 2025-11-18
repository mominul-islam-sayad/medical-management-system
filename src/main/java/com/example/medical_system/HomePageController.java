package com.example.medical_system;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable{
    @FXML
    private TableView<Doctors> table;
    @FXML
    private TableColumn<HospitalInfo, String> hospitalName;
    @FXML
    private TableColumn<HospitalInfo, String> noOfAvailableSeat;
    @FXML
    private TableColumn<HospitalInfo, String> costPerSeat;



    DataBaseManagement dataBaseManagement = new DataBaseManagement();
    @FXML
    private TableColumn<Doctors, String> SeatColumnInTable;
    @FXML
    private TableColumn<Doctors, String> costColumnInTable;
    @FXML
    private TableColumn<Doctors, Integer> idColumnInTable;
    @FXML
    private VBox pnItems = null;
    private Stage stage;

    @FXML
    public void ToDoctorsPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OnlineDoctor.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public ObservableList<Doctors> getDoctors() {
        ObservableList<Doctors> doctors = FXCollections.observableArrayList();
        for(int i = 1; i<dataBaseManagement.noOfRowInHospitalDb() ;i ++){
            String name = dataBaseManagement.getHospitalName(i);
            String department = dataBaseManagement.getNoOfSeatInHospital(i);
            String phoneNo =dataBaseManagement.costPerSeat(i);

            Doctors doctor = new Doctors(name, department, phoneNo);
            doctors.add(doctor);

        }

        return doctors;
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumnInTable.setCellValueFactory(new PropertyValueFactory<Doctors, Integer>("id"));
        SeatColumnInTable.setCellValueFactory(new PropertyValueFactory<Doctors, String>("Name"));
        costColumnInTable.setCellValueFactory(new PropertyValueFactory<Doctors, String>("Department"));

        table.setItems(getDoctors());

    }
//
//    public ObservableList<HospitalInfo> getHospitals() {
//            ObservableList<HospitalInfo> hospitalInfos = FXCollections.observableArrayList();
//            int noOfRowInHospital = dataBaseManagement.noOfRowInHospitalDb();
//            for(int i = 1; i<noOfRowInHospital; i++){
//                String hospitalName = dataBaseManagement.getHospitalName(i);
//                String noOfAvailableSeat = dataBaseManagement.getNoOfSeatInHospital(i);
//                String costPerSeat =dataBaseManagement.costPerSeat(i);
//
//                HospitalInfo hospitalInfo = new HospitalInfo(hospitalName, noOfAvailableSeat, costPerSeat);
//                hospitalInfos.add(hospitalInfo);
//            }
//
//            return hospitalInfos;
//        }

//        public void initialize(URL url, ResourceBundle resourceBundle) {
//            idColumnInTable.setCellValueFactory(new PropertyValueFactory<HospitalInfo, String>("name"));
//            SeatColumnInTable.setCellValueFactory(new PropertyValueFactory<HospitalInfo, String>("no_of_available_seat"));
//            costPerSeat.setCellValueFactory(new PropertyValueFactory<HospitalInfo, String>("cost_per_seat"));
//
//            table.setItems(getHospitals());
//
//        }

//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        hospitalName.setCellValueFactory(new PropertyValueFactory<HospitalInfo, String>("name"));
//        noOfAvailableSeat.setCellValueFactory(new PropertyValueFactory<HospitalInfo, String>("no_of_available_seat"));
//        costPerSeat.setCellValueFactory(new PropertyValueFactory<HospitalInfo, String>("cost_per_seat"));
//
//        table.setItems(getHospitals());
//
//    }





}
package com.example.medical_system;

import javafx.event.ActionEvent;

import java.sql.*;

public class DataBaseManagement {
    String dbmsUrl = "jdbc:mysql://localhost:3306/medical_system";
    String dbmsUserName = "root";
    String dbmsUserPassword = "root";
//    int noOfRowInDb =;


    public int noOfRowInDb (){
        try {
            int noOfRow;
            Connection connection = DriverManager.getConnection(dbmsUrl, dbmsUserName, dbmsUserPassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user_credential");
            noOfRow = 1;
            while(resultSet.next()) {
                noOfRow++;
            };
            return noOfRow;
        }catch (Exception exception){
            System.out.println(exception);
        }
        return 0;
    }

    public int noOfRowInHospitalDb (){
        try {
            int noOfRow;
            Connection connection = DriverManager.getConnection(dbmsUrl, dbmsUserName, dbmsUserPassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from hospitals");
            noOfRow = 1;
            while(resultSet.next()) {
                noOfRow++;
                System.out.println("no of row in hospital" + noOfRow);
            };
            return noOfRow;
        }catch (Exception exception){
            System.out.println(exception);
        }
        return 0;
    }



    public boolean userAuthentication(String userName, String userPassword){
        try {
            Connection connection = DriverManager.getConnection(dbmsUrl, dbmsUserName, dbmsUserPassword);
            Statement statement = connection.createStatement();
            String query = "select UserPassword from user_credential where UserName ='" + userName +"'";

            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            String userPasswordFromDbms = resultSet.getString(1);
            if (userPasswordFromDbms.equals(userPassword.trim())) {
                return true;
            }
            return false;
        }catch (Exception exception){
            System.out.println("Authentication failed");
            System.out.println(exception);
            return false;
        }
    }

    public void addNewUser(String userName, String userPassword, String Address, String age, String bloodGroup ) throws SQLException {
        System.out.println("Enter in the method");
        Connection connection = DriverManager.getConnection(dbmsUrl, dbmsUserName, dbmsUserPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user_credential");
        int userId = 1;
        while(resultSet.next()) {
            userId++;
        };
        String addNewUserQuerry = "insert into user_credential values ('"+userId + "','"+userName +"','" +userPassword+ "','"+ Address+"','"+ age +"','"+ bloodGroup+ "')";

        statement.executeUpdate(addNewUserQuerry);
    }

    public String infoOfDoctor(int no) {
        try {
            Connection connection = DriverManager.getConnection(dbmsUrl, dbmsUserName, dbmsUserPassword);
            Statement statement = connection.createStatement();
            String sql = "select UserName from user_credential where UserID ='"+no+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            String userNameFromDbms = resultSet.getString(1);

        }catch (Exception e){

        }

        return null;
    }

//    public void numberOfRowInDBMS() throws SQLException {
//        Connection connection = DriverManager.getConnection(dbmsUrl, dbmsUserName, dbmsUserPassword);
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("select * from user_credential");
//        int count = 0;
//        while (resultSet.next()) {
//            count++;
//        }
//        System.out.println(count);
//    }
    
    public String getDoctorInfo(int idNo){
        try {
            Connection connection = DriverManager.getConnection(dbmsUrl, dbmsUserName, dbmsUserPassword);
            Statement statement = connection.createStatement();
            String sql = "select UserName from user_credential where UserID ='"+idNo+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            String userNameFromDbms = resultSet.getString(1);
            return userNameFromDbms;
        }catch (Exception e){
            System.out.println(e);
        }
        return "null";
    }

    public String phoneNoOfDoctor(int idNo) {
        try {
            Connection connection = DriverManager.getConnection(dbmsUrl, dbmsUserName, dbmsUserPassword);
            Statement statement = connection.createStatement();
            String sql = "select UserPassword from user_credential where UserID ='"+idNo+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            String userNameFromDbms = resultSet.getString(1);
            return userNameFromDbms;
        }catch (Exception e){
            System.out.println(e);
        }
        return "null";
//        return "nothing";
    }

    public String departmentOfDoctor(int idNo) {
        try {
            Connection connection = DriverManager.getConnection(dbmsUrl, dbmsUserName, dbmsUserPassword);
            Statement statement = connection.createStatement();
            String sql = "select Address from user_credential where UserID ='"+idNo+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            String userNameFromDbms = resultSet.getString(1);
            return userNameFromDbms;
        }catch (Exception e){
            System.out.println(e);
        }
        return "null";
//        return "nothing";
    }

    public String getHospitalName(int idNo){
        try {
            Connection connection = DriverManager.getConnection(dbmsUrl, dbmsUserName, dbmsUserPassword);
            Statement statement = connection.createStatement();
            String sql = "select name from hospitals where hospital_id ='"+idNo+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            String hospitalNameFromFbms = resultSet.getString(1);
            return hospitalNameFromFbms;
        }catch (Exception e){
            System.out.println(e);
        }
        return "null";
    }
    public String getNoOfSeatInHospital(int idNo){
        try {
            Connection connection = DriverManager.getConnection(dbmsUrl, dbmsUserName, dbmsUserPassword);
            Statement statement = connection.createStatement();
            String sql = "select no_of_available_seat from hospitals where hospital_id ='"+idNo+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();

            String noOfAvailableSeat = resultSet.getString(1);
            System.out.println(noOfAvailableSeat);
            return noOfAvailableSeat;
        }catch (Exception e){
            System.out.println(e);
        }
        return "null";
    }
    public String costPerSeat(int idNo){
        try {
            Connection connection = DriverManager.getConnection(dbmsUrl, dbmsUserName, dbmsUserPassword);
            Statement statement = connection.createStatement();
            String sql = "select cost_per_seat from hospitals where hospital_id ='"+idNo+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            String costPerSeat = resultSet.getString(1);
            return costPerSeat;
        }catch (Exception e){
            System.out.println(e);
        }
        return "null";
    }

    public void addHospitalInfo(String hospitalName, String noOfAvailableSeat, String costPerSeat) throws SQLException {
        System.out.println("Enter in the method");
        Connection connection = DriverManager.getConnection(dbmsUrl, dbmsUserName, dbmsUserPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from hospitals");
        int userId = 1;
        while(resultSet.next()) {
            userId++;
        };
        String addNewUserQuerry = "insert into hospitals values ('"+hospitalName + "','"+noOfAvailableSeat +"','"+costPerSeat+ "')";

        statement.executeUpdate(addNewUserQuerry);
    }
}

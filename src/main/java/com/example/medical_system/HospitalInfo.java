package com.example.medical_system;

public class HospitalInfo {
    String hospitalName, noOfAvailableSeat, costPerSeat;

    public HospitalInfo(String hospitalName, String noOfAvailableSeat, String costPerSeat) {
        this.hospitalName = hospitalName;
        this.noOfAvailableSeat = noOfAvailableSeat;
        this.costPerSeat = costPerSeat;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getNoOfAvailableSeat() {
        return noOfAvailableSeat;
    }

    public void setNoOfAvailableSeat(String noOfAvailableSeat) {
        this.noOfAvailableSeat = noOfAvailableSeat;
    }

    public String getCostPerSeat() {
        return costPerSeat;
    }

    public void setCostPerSeat(String costPerSeat) {
        this.costPerSeat = costPerSeat;
    }
}

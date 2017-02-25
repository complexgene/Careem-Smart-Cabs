package com.example.shan.careemsmartcabs.model;

/**
 * Created by Shan on 2/25/2017.
 */

public class Vehicle {
    private String plateNumber;
    private int noOfSeatsAvailable;
    private String brandName;
    private String modelName;

    public String getPlateNumber() {
        return plateNumber;
    }
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
    public int getNoOfSeatsAvailable() {
        return noOfSeatsAvailable;
    }
    public void setNoOfSeatsAvailable(int noOfSeatsAvailable) {
        this.noOfSeatsAvailable = noOfSeatsAvailable;
    }
    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public String getModelName() {
        return modelName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}

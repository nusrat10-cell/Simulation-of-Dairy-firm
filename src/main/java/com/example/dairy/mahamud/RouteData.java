package com.example.dairy.mahamud;

public class RouteData {
    private String sampleId;
    private int quantity;
    private String farmerName;
    private String destination;

    public RouteData(String sampleId, int quantity, String farmerName, String destination) {
        this.sampleId = sampleId;
        this.quantity = quantity;
        this.farmerName = farmerName;
        this.destination = destination;
    }

    public String getSampleId() {
        return sampleId;
    }

    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}

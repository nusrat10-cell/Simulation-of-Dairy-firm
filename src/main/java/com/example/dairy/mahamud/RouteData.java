package com.example.dairy.mahamud;

public class RouteData {
    private String sampleId;
    private String farmerName;
    private double quantity;
    private String destination;

    public RouteData(String sampleId, String farmerName, double quantity, String destination) {
        this.sampleId = sampleId;
        this.farmerName = farmerName;
        this.quantity = quantity;
        this.destination = destination;
    }

    public String getSampleId() {
        return sampleId;
    }

    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "RouteData{" +
                "sampleId='" + sampleId + '\'' +
                ", farmerName='" + farmerName + '\'' +
                ", quantity=" + quantity +
                ", destination='" + destination + '\'' +
                '}';
    }
}

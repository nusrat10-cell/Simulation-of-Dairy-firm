package com.example.dairy.Nupur;

public class storageconditionClass {
    private double temperature;
    private double humidity;
    private String status;
    private String productName;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public storageconditionClass(double temperature, String productName, String status, double humidity) {
        this.temperature = temperature;
        this.productName = productName;
        this.status = status;
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "storageconditionClass{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", status='" + status + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
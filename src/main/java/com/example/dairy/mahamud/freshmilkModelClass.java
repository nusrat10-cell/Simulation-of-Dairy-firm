package com.example.dairy.mahamud;

public class freshmilkModelClass {
    private double temperature;
    private String status;

    public freshmilkModelClass(double temperature, String status) {
        this.temperature = temperature;
        this.status = status;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MilkData{" +
                "temperature=" + temperature +
                ", status='" + status + '\'' +
                '}';
    }
}

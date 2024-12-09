package com.example.Nupur;

public class storageconditionClass {
    public double temperature;
    public double humidity;
    public String status;

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

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public storageconditionClass(double temperature, String status, double humidity) {
        this.temperature = temperature;
        this.status = status;
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "storageconditionClass{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", status='" + status + '\'' +
                '}';
    }
}

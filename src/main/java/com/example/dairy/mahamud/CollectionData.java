package com.example.dairy.mahamud;

import java.time.LocalDate;

public class CollectionData {
    private String farmerName;
    private double quantity;
    private LocalDate date;

    public CollectionData(String farmerName, double quantity, LocalDate date) {
        this.farmerName = farmerName;
        this.quantity = quantity;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CollectionData{" +
                "farmerName='" + farmerName + '\'' +
                ", quantity=" + quantity +
                ", date=" + date +
                '}';
    }
}

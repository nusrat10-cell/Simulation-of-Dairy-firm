package com.example.dairy.mahamud;

import java.time.LocalDate;

public class ReceptionData {
    private String deliveryId;
    private String truckId;
    private double quantity;
    private LocalDate date;
    private String status;

    public ReceptionData(String deliveryId, String truckId, double quantity, LocalDate date, String status) {
        this.deliveryId = deliveryId;
        this.truckId = truckId;
        this.quantity = quantity;
        this.date = date;
        this.status = status;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReceptionData{" +
                "deliveryId='" + deliveryId + '\'' +
                ", truckId='" + truckId + '\'' +
                ", quantity=" + quantity +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }
}

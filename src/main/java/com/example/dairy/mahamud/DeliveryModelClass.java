package com.example.dairy.mahamud;

import java.time.LocalDate;

public class DeliveryModelClass {
    private String vehicleType;
    private String deliveryRoute;
    private int quantity;
    private LocalDate deliveryDate;

    public DeliveryModelClass(String vehicleType, String deliveryRoute, int quantity, LocalDate deliveryDate) {
        this.vehicleType = vehicleType;
        this.deliveryRoute = deliveryRoute;
        this.quantity = quantity;
        this.deliveryDate = deliveryDate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getDeliveryRoute() {
        return deliveryRoute;
    }

    public void setDeliveryRoute(String deliveryRoute) {
        this.deliveryRoute = deliveryRoute;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}

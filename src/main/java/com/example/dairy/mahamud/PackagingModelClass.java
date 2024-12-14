package com.example.dairy.mahamud;

import java.time.LocalDateTime;

public class PackagingModelClass {
    private String productType;
    private int quantity;
    private LocalDateTime timeRemaining;

    public PackagingModelClass(String productType, int quantity, LocalDateTime timeRemaining) {
        this.productType = productType;
        this.quantity = quantity;
        this.timeRemaining = timeRemaining;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(LocalDateTime timeRemaining) {
        this.timeRemaining = timeRemaining;
    }
}

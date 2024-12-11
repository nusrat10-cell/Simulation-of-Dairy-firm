package com.example.dairy.Nupur;

import java.time.LocalDate;

public class expiryDateModelClass {
    public String productName;
    public Integer currentStock;
    public LocalDate expiryDate;

    public expiryDateModelClass(String productName, Integer currentStock, LocalDate expiryDate) {
        this.productName = productName;
        this.currentStock = currentStock;
        this.expiryDate = expiryDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "expiryDateModelClass{" +
                "productName='" + productName + '\'' +
                ", currentStock=" + currentStock +
                ", expiryDate=" + expiryDate +
                '}';
    }
}

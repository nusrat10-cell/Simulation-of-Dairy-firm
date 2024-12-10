package com.example.dairy.Nupur;

import java.time.LocalDate;

public class inventoryModelClass {
    private String productName;
    private Integer stockLevel;
    private Integer minimumStock;
    private LocalDate expiryDate;

    public inventoryModelClass(String productName, LocalDate expiryDate, Integer minimumStock, Integer stockLevel) {
        this.productName = productName;
        this.expiryDate = expiryDate;
        this.minimumStock = minimumStock;
        this.stockLevel = stockLevel;
    }

    // Getter and Setter for productName
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    // Getter and Setter for stockLevel
    public Integer getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(Integer stockLevel) {
        this.stockLevel = stockLevel;
    }

    // Getter and Setter for minimumStock
    public Integer getMinimumStock() {
        return minimumStock;
    }

    public void setMinimumStock(Integer minimumStock) {
        this.minimumStock = minimumStock;
    }

    // Getter and Setter for expiryDate
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "inventoryModelClass{" +
                "productName='" + productName + '\'' +
                ", stockLevel=" + stockLevel +
                ", minimumStock=" + minimumStock +
                ", expiryDate=" + expiryDate +
                '}';
    }
}

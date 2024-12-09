package Nupur;

import java.time.LocalDate;

public class expiryDateModelClass {
    public String productName;
    public Integer currentStock;
    public LocalDate expiryDate;
    public Integer minimumStock;

    public Integer getMinimumStock() {
        return minimumStock;
    }

    public void setMinimumStock(Integer minimumStock) {
        this.minimumStock = minimumStock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public expiryDateModelClass(Integer minimumStock) {
        this.minimumStock = minimumStock;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    public expiryDateModelClass(String productName, LocalDate expiryDate, Integer currentStock) {
        this.productName = productName;
        this.expiryDate = expiryDate;
        this.currentStock = currentStock;
    }

    @Override
    public String toString() {
        return "expiryDateModelClass{" +
                "productName='" + productName + '\'' +
                ", currentStock=" + currentStock +
                ", expiryDate=" + expiryDate +
                ", minimumStock=" + minimumStock +
                '}';
    }
}

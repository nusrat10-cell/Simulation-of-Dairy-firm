package Nupur;

import java.time.LocalDate;

public class inventoryModelClass {
    public String productName;
    public Integer StockLevel;
    public Integer minimumStock;
    public LocalDate expiryDate;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getMinimumStock() {
        return minimumStock;
    }

    public void setMinimumStock(Integer minimumStock) {
        this.minimumStock = minimumStock;
    }

    public Integer getStockLevel() {
        return StockLevel;
    }

    public void setStockLevel(Integer stockLevel) {
        StockLevel = stockLevel;
    }

    @Override
    public String toString() {
        return "inventoryModelClass{" +
                "productName='" + productName + '\'' +
                ", StockLevel=" + StockLevel +
                ", minimumStock=" + minimumStock +
                ", expiryDate=" + expiryDate +
                '}';
    }

    public inventoryModelClass(String productName, LocalDate expiryDate, Integer minimumStock, Integer stockLevel) {
        this.productName = productName;
        this.expiryDate = expiryDate;
        this.minimumStock = minimumStock;
        StockLevel = stockLevel;

    }
}

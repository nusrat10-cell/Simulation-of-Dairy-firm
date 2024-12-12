package com.example.dairy.Nupur;

public class lowstockModelClass {
    private String productName;
    private Integer currentStock;
    private Integer minimumStock;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getMinimumStock() {
        return minimumStock;
    }

    public void setMinimumStock(Integer minimumStock) {
        this.minimumStock = minimumStock;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    public lowstockModelClass(String productName, Integer minimumStock, Integer currentStock) {
        this.productName = productName;
        this.minimumStock = minimumStock;
        this.currentStock = currentStock;
    }

    @Override
    public String toString() {
        return "lowstockModelClass{" +
                "productName='" + productName + '\'' +
                ", currentStock=" + currentStock +
                ", minimumStock=" + minimumStock +
                '}';
    }
}

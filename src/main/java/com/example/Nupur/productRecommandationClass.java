package com.example.Nupur;

public class productRecommandationClass {
    public String customerName;
    public String productType;
    public Integer purchaseQuantity;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(Integer purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public productRecommandationClass(String customerName, Integer purchaseQuantity, String productType) {
        this.customerName = customerName;
        this.purchaseQuantity = purchaseQuantity;
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "productRecommandationClass{" +
                "customerName='" + customerName + '\'' +
                ", productType='" + productType + '\'' +
                ", purchaseQuantity=" + purchaseQuantity +
                '}';
    }
}

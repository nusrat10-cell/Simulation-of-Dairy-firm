package com.example.dairy.Nupur;

public class productDispatchmodelClass{
    private String ProductName;
    private Integer quantity;
    private String destination;

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public productDispatchmodelClass(String productName, String destination, Integer quantity) {
        ProductName = productName;
        this.destination = destination;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "productDispatchmodelClass{" +
                "ProductName='" + ProductName + '\'' +
                ", quantity=" + quantity +
                ", destination='" + destination + '\'' +
                '}';
    }
}
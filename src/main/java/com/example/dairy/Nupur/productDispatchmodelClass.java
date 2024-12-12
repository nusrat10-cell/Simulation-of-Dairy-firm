package com.example.dairy.Nupur;

public class productDispatchmodelClass {
    //public Integer requestID;
    private Integer quantity;
    private String productName;
    private String destination;

    //public Integer getRequestID() {
        //return requestID;
    //}

    //public void setRequestID(Integer requestID) {
       // this.requestID = requestID;
    //}

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "productDispatchmodelClass{" +
                //"requestID=" + requestID +
                ", quantity=" + quantity +
                ", productName='" + productName + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }

    public productDispatchmodelClass( String destination, String productName, Integer quantity) {
        //this.requestID = requestID;
        this.destination = destination;
        this.productName = productName;
        this.quantity = quantity;

    }
}

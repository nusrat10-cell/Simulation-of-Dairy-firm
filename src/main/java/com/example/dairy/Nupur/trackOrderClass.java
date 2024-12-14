package com.example.dairy.Nupur;

import java.time.LocalDate;

public class trackOrderClass {
    private String productName;
    private Integer orderID;
    private Integer quantity;
    private LocalDate date;
    private String status;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    @Override
    public String toString() {
        return "trackOrderClass{" +
                "productName='" + productName + '\'' +
                ", orderID=" + orderID +
                ", quantity=" + quantity +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }

    public trackOrderClass(String productName, String status, LocalDate date, Integer quantity, Integer orderID) {
        this.productName = productName;
        this.status = status;
        this.date = date;
        this.quantity = quantity;
        this.orderID = orderID;
    }
}



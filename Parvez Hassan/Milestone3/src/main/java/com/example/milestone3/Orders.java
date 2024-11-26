package com.example.milestone3;


import java.time.LocalDate;

public class Orders {
    LocalDate orderDate;
    String orderName;
    int OrderID;
    int orderQuantity;
    String orderType;
    String orderCustomerName;

    public Orders(int orderQuantity, int OrderID, String orderName, LocalDate orderDate, String orderType, String orderCustomerName) {
        this.orderQuantity = orderQuantity;
        this.OrderID = OrderID;
        this.orderName = orderName;
        this.orderDate = orderDate;
        this.orderType = orderType;
        this.orderCustomerName=orderCustomerName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    public String getOrderCustomerName(){
        return orderCustomerName;
    }
    public void setOrderCustomerName(){
        this.orderCustomerName = orderCustomerName;
    }

    public String getorderType(){
        return orderType;
    }
    public void setOrderType(){
        this.orderType = orderType;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderDate=" + orderDate +
                ", orderName='" + orderName + '\'' +
                ", OrderID=" + OrderID +
                ", orderQuantity=" + orderQuantity +
                ", orderType=" + orderType+
                ", orderCustomerName=" + orderCustomerName+
                '}';
    }
}

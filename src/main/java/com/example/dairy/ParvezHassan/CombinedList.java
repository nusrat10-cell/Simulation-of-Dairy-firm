package com.example.dairy.ParvezHassan;

import java.io.Serializable;
import java.time.LocalDate;

public class CombinedList implements Serializable {
    // Attributes from Inventory
    private final String itemName;
    private final Double itemPrice;
    private final int itemLevel;

    // Attributes from Orders
    private final LocalDate orderDate;
    private final int orderID;
    private int orderQuantity;
    private String orderType;

    // Attributes from Customers
    private final String customerName;
    private final int customerID;
    private final String customerAddress;
    private final int customerNumber;

    public CombinedList(String itemName, Double itemPrice, int itemLevel, LocalDate orderDate, int orderID, int orderQuantity, String orderType, String customerName, int customerID, String customerAddress, int customerNumber) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemLevel = itemLevel;
        this.orderDate = orderDate;
        this.orderID = orderID;
        this.orderQuantity = orderQuantity;
        this.orderType = orderType;
        this.customerName = customerName;
        this.customerID = customerID;
        this.customerAddress = customerAddress;
        this.customerNumber = customerNumber;
    }

    // Getters for each attribute
    public String getItemName() {
        return itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public int getItemLevel() {
        return itemLevel;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public String getOrderType() {
        return orderType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    // Setter for orderType
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return
                "itemName='" + itemName + '\'' +
                        ", itemPrice=" + itemPrice +
                        ", itemLevel=" + itemLevel +
                        ", orderDate=" + orderDate +
                        ", orderID=" + orderID +
                        ", orderQuantity=" + orderQuantity +
                        ", orderType='" + orderType + '\'' +
                        ", customerName='" + customerName + '\'' +
                        ", customerID=" + customerID +
                        ", customerAddress='" + customerAddress + '\'' +
                        ", customerNumber=" + customerNumber +
                        '}';
    }
}

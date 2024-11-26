package com.example.milestone3;

public class Customers {
    int customerID;
    String customerName;
    int customerNumber;
    String customerAddress;

    public Customers(int customerID, String customerAddress, int customerNumber, String customerName) {
        this.customerID = customerID;
        this.customerAddress = customerAddress;
        this.customerNumber = customerNumber;
        this.customerName = customerName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", customerNumber=" + customerNumber +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }
}

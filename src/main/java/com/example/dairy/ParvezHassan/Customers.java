package com.example.milestone3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Customers {
    int customerID;
    String customerName;
    int customerNumber;
    String customerAddress;
    String paymentDetails;


    public Customers(int customerID, String customerAddress, int customerNumber, String customerName,String paymentDetails) {
        this.customerID = customerID;
        this.customerAddress = customerAddress;
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.paymentDetails= paymentDetails;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public  String getpaymentDetails(){return paymentDetails;}

    public void setPaymentDetails(String paymentDetails){this.paymentDetails=paymentDetails;}


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
                ", paymentDetails= " + paymentDetails +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }


}

package com.example.milestone3;
import java.time.LocalDate;

    public class CombinedList {
        // Attributes from Inventory
        private String itemName;
        private int itemPrice;
        private int itemLevel;

        // Attributes from Orders
        private LocalDate orderDate;
        private int orderID;
        private int orderQuantity;
        private String orderType;

        // Attributes from Customers
        private String customerName;
        private int customerID;
        private String customerAddress;
        private int customerNumber;

        public CombinedList(String itemName, int itemPrice, int itemLevel, LocalDate orderDate, int orderID, int orderQuantity, String orderType, String customerName, int customerID, String customerAddress, int customerNumber) {
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

        public int getItemPrice() {
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
    }



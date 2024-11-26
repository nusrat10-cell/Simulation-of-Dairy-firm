package com.example.milestone3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class DataStore {
    public static final ObservableList<Inventory> inventoryList = FXCollections.observableArrayList();
    public static final ObservableList<Customers> customerList = FXCollections.observableArrayList();
    public static final ObservableList<Orders> orderList = FXCollections.observableArrayList();
    public static final ObservableList<Transactions> allTranactions = FXCollections.observableArrayList();
    public static final ObservableList<CombinedList> combinedList = FXCollections.observableArrayList();

    public ObservableList<Inventory> getInventoryList() {
        return inventoryList;
    }

    static {
        populateInventory();
        populateCustomers();
        populateOrders();
        populateTransactionList();
        populateCombinedList();
    }
//getter
    public static ObservableList<Customers> getCustomerList() {
        return customerList;
    }

    public static ObservableList<Orders> getOrderList() {
        return orderList;
    }

    public ObservableList<Transactions> getAllTranactions() {
        return allTranactions;
    }

    public ObservableList<CombinedList> getCombinedList() {
        return combinedList;
    }


    public static void populateInventory() {
        inventoryList.add(new Inventory("Milk", 100, 44, 100, "Raw Material"));
        inventoryList.add(new Inventory("Cheese", 100, 44, 100, "Finished Goods"));
        inventoryList.add(new Inventory("Butter", 100, 44, 100, "Raw Material"));
        inventoryList.add(new Inventory("Paneer", 100, 44, 30, "Packaging Material"));
        inventoryList.add(new Inventory("Condensed Milk", 100, 44, 60, "Storage Supplies"));
        inventoryList.add(new Inventory("Whey", 100, 44, 44, "Equipments"));
    }

    private static void populateCustomers() {
        customerList.add(new Customers(1234, "IUB", 1928682961, "Rahim"));
        customerList.add(new Customers(1235, "IUB", 1928682962, "Karim"));
        customerList.add(new Customers(1236, "IUB", 1928682963, "Salim"));
        customerList.add(new Customers(1237, "IUB", 1928682964, "Naim"));
    }

    private static void populateOrders() {
        orderList.add(new Orders(12, 112, "Milk", LocalDate.of(2024, 12, 1), "Pending","Rahim"));
        orderList.add(new Orders(12, 113, "Cheese", LocalDate.of(2024, 12, 2), "Fulfilled", "Karim"));
        orderList.add(new Orders(12, 114, "Butter", LocalDate.of(2024, 12, 3), "Fulfilled" ,"Salim"));
        orderList.add(new Orders(12, 115, "Paneer", LocalDate.of(2024, 12, 4), "Pending", "Naim"));
        orderList.add(new Orders(12, 116, "Condensed Milk", LocalDate.of(2024, 12, 5), "Fulfilled","Naim"));
    }

    public static void populateTransactionList() {
        allTranactions.add(new Transactions("rahman", LocalDate.of(2023, 11, 23), 1990, "bkash", "credit", 1998));
        allTranactions.add(new Transactions("rahman", LocalDate.of(2023, 11, 23), 1990, "bkash", "credit", 1998));
        allTranactions.add(new Transactions("rahman", LocalDate.of(2023, 11, 23), 1990, "bkash", "credit", 1998));
        allTranactions.add(new Transactions("rahman", LocalDate.of(2023, 11, 23), 1990, "bkash", "credit", 1998));
        allTranactions.add(new Transactions("rahman", LocalDate.of(2023, 11, 23), 1990, "bkash", "credit", 1998));
    }

    private static void populateCombinedList() {
        for (Orders order : orderList) {

            Inventory inventory = inventoryList.stream().filter(item -> item.getName().equals(order.getOrderName())).findFirst().orElse(null);


            Customers customer = customerList.stream().filter(c -> c.getCustomerName().equals(order.getOrderCustomerName())).findFirst().orElse(null);


            if (inventory != null && customer != null) {
                CombinedList combinedData = new CombinedList(
                        inventory.getName(),
                        inventory.getPriceperUnit(),
                        inventory.getStockLevel(),
                        order.getOrderDate(),
                        order.getOrderID(),
                        order.getOrderQuantity(),
                        order.getorderType(),
                        customer.getCustomerName(),
                        customer.getCustomerID(),
                        customer.getCustomerAddress(),
                        customer.getCustomerNumber()
                );
                combinedList.add(combinedData);

            } else {

            }
        }

    }

}

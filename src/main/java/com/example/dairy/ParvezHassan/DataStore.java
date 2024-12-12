package com.example.dairy.ParvezHassan;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataStore {
    public static final ObservableList<Inventory> inventoryList = FXCollections.observableArrayList();
    public static final ObservableList<Customers> customerList = FXCollections.observableArrayList();
    public static final ObservableList<Orders> orderList = FXCollections.observableArrayList();
    public static final ObservableList<Transactions> allTransactions = FXCollections.observableArrayList();
    public static final ObservableList<CombinedList> combinedList = FXCollections.observableArrayList();

    public static void main(String[] args) {
        // Create files
        createFiles();

        // Populate lists
        populateInventory();
        populateCustomers();
        populateOrders();
        populateTransactionList();
        populateCombinedList();

        // Save data to files
        saveDataToFile(new ArrayList<>(inventoryList), "DataStore/InventoryList.bin");
        saveDataToFile(new ArrayList<>(customerList), "DataStore/CustomerList.bin");
        saveDataToFile(new ArrayList<>(orderList), "DataStore/OrderList.bin");
        saveDataToFile(new ArrayList<>(allTransactions), "DataStore/TransactionList.bin");
        saveDataToFile(new ArrayList<>(combinedList), "DataStore/CombinedList.bin");

        // Load data from files (for verification)
        ObservableList<Inventory> loadedInventoryList = FXCollections.observableArrayList(loadDataFromFile("InventoryList.bin"));
        loadedInventoryList.forEach(System.out::println);
    }

    private static void createFiles() {
        try {
            new File("DataStore/OrderList.bin").createNewFile();
            new File("DataStore/TransactionList.bin").createNewFile();
            new File("DataStore/InventoryList.bin").createNewFile();
            new File("DataStore/CustomerList.bin").createNewFile();
            new File("DataStore/CombinedList.bin").createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Failed to create files: " + e.getMessage());
        }
    }

    private static <T extends Serializable> void saveDataToFile(List<T> list, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(list);
            System.out.println("Data saved to: " + fileName);
        } catch (IOException e) {
            System.err.println("Failed to save data to " + fileName + ": " + e.getMessage());
        }
    }

    private static <T extends Serializable> List<T> loadDataFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Failed to load data from " + fileName + ": " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static ObservableList<Customers> getCustomerList() {
        return customerList;
    }

    public static ObservableList<Orders> getOrderList() {
        return orderList;
    }

    public ObservableList<Transactions> getAllTransactions() {
        return allTransactions;
    }

    public ObservableList<CombinedList> getCombinedList() {
        return combinedList;
    }

    public ObservableList<Inventory> getInventoryList() {return inventoryList;}

    public static void populateInventory() {
        inventoryList.add(new Inventory("Milk", 44, 100, "Raw Material"));
        inventoryList.add(new Inventory("Cheese", 44, 100, "Finished Goods"));
        inventoryList.add(new Inventory("Butter", 44, 100, "Raw Material"));
        inventoryList.add(new Inventory("Paneer", 44, 30, "Packaging Material"));
        inventoryList.add(new Inventory("Condensed Milk", 44, 60, "Storage Supplies"));
        inventoryList.add(new Inventory("Whey", 44, 44, "Equipments"));
    }

    private static void populateCustomers() {
        customerList.add(new Customers(1234, "IUB", 1928682961, "Rahim", "Cash"));
        customerList.add(new Customers(1235, "IUB", 1928682962, "Karim", "Card"));
        customerList.add(new Customers(1236, "IUB", 1928682963, "Salim", "Card"));
        customerList.add(new Customers(1237, "IUB", 1928682964, "Naim", "Card"));
    }

    private static void populateOrders() {
        orderList.add(new Orders(12, 112, "Milk", LocalDate.of(2024, 12, 1), "Pending", "Rahim"));
        orderList.add(new Orders(12, 113, "Cheese", LocalDate.of(2024, 12, 2), "Fulfilled", "Karim"));
        orderList.add(new Orders(12, 114, "Butter", LocalDate.of(2024, 12, 3), "Fulfilled", "Salim"));
        orderList.add(new Orders(12, 115, "Paneer", LocalDate.of(2024, 12, 4), "Pending", "Naim"));
        orderList.add(new Orders(12, 116, "Condensed Milk", LocalDate.of(2024, 12, 5), "Fulfilled", "Naim"));
    }

    public static void populateTransactionList() {
        allTransactions.add(new Transactions("rahman", LocalDate.of(2023, 11, 23), 1990, "bkash", "credit", 1998));
        allTransactions.add(new Transactions("rahman", LocalDate.of(2023, 11, 23), 1990, "bkash", "credit", 1999));
        allTransactions.add(new Transactions("rahman", LocalDate.of(2023, 11, 23), 1990, "bkash", "credit", 2000));
        allTransactions.add(new Transactions("rahman", LocalDate.of(2023, 11, 23), 1990, "bkash", "credit", 2001));
        allTransactions.add(new Transactions("rahman", LocalDate.of(2023, 11, 23), 1990, "bkash", "credit", 2002));
    }



    private static void populateCombinedList() {
        for (Orders order : orderList) {
            Inventory inventory = inventoryList.stream().filter(item -> item.getProduct_name().equals(order.getOrderName())).findFirst().orElse(null);
            Customers customer = customerList.stream().filter(c -> c.getCustomerName().equals(order.getOrderCustomerName())).findFirst().orElse(null);

            if (inventory != null && customer != null) {
                CombinedList combinedData = new CombinedList(
                        inventory.getProduct_name(),
                        inventory.getProduct_price(),
                        inventory.getProduct_stockLevel(),
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
            }
        }
    }
}

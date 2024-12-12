package com.example.dairy.ParvezHassan;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddOrder
{
    @javafx.fxml.FXML
    private TableColumn quantity_Col;
    @javafx.fxml.FXML
    private Label customerAdress_label;
    @javafx.fxml.FXML
    private TableColumn item_Col;
    @javafx.fxml.FXML
    private TableView newOrder_TV;
    @javafx.fxml.FXML
    private TableColumn payMryhod_Col;
    @javafx.fxml.FXML
    private AnchorPane addOrder_Pane;
    @javafx.fxml.FXML
    private Label customerNumber_label;
    @javafx.fxml.FXML
    private DatePicker order_Date_DP;
    @javafx.fxml.FXML
    private TableColumn date_Col;
    @javafx.fxml.FXML
    private TextField order_ID_TF;
    @javafx.fxml.FXML
    private TableColumn customerID_Col;
    @javafx.fxml.FXML
    private TextField customerID_TF;
    @javafx.fxml.FXML
    private TableColumn orderID_Col;
    @javafx.fxml.FXML
    private TextField order_Quantity_TF;
    @javafx.fxml.FXML
    private ComboBox pay_Method_CB;
    @javafx.fxml.FXML
    private Label sustomerType_label;
    @javafx.fxml.FXML
    private ComboBox pay_Status_CB;
    @javafx.fxml.FXML
    private ComboBox order_Name_CB;
    @javafx.fxml.FXML
    private TableColumn status_Col;
    @javafx.fxml.FXML
    private Label customerName_label;


    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Login Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void initialize() {
        pay_Status_CB.getItems().addAll("Pending", "Fulfilled");
        pay_Method_CB.getItems().addAll("Cash", "Card", "Bkash", "Nogod");
        // Create a list to store item names
        ObservableList<String> inventoryNames = FXCollections.observableArrayList();

        // Read data from InventoryList.bin
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DataStore/InventoryList.bin"))) {
            List<Inventory> inventoryList = (List<Inventory>) ois.readObject();

            for (Inventory inventory : inventoryList) {
                // Add item name to the list
                inventoryNames.add(inventory.getProduct_name());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Populate ComboBox with item names
        order_Name_CB.setItems(inventoryNames);
    }

    @javafx.fxml.FXML
    public void show_tab_Button(ActionEvent actionEvent) {
        // Fetch user inputs
        LocalDate orderDate = order_Date_DP.getValue();
        int orderID = Integer.parseInt(order_ID_TF.getText());
        String orderName = (String) order_Name_CB.getValue();
        int orderQuantity = Integer.parseInt(order_Quantity_TF.getText());
        String paymentStatus = (String) pay_Status_CB.getValue();
        String paymentMethod = (String) pay_Method_CB.getValue();
        int customerID = Integer.parseInt(customerID_TF.getText());
        String customerName = customerName_label.getText();
        String customerAddress = customerAdress_label.getText();
        int customerContact = Integer.parseInt(customerNumber_label.getText());
        String orderType = "Pending";

        // Create a new CombinedList entry
        CombinedList combinedData = new CombinedList(
                orderName,
                0, // Assuming item price is 0 for now
                0, // Assuming item level is 0 for now
                orderDate,
                orderID,
                orderQuantity,
                orderType,
                customerName,
                customerID,
                customerAddress,
                customerContact
        );

        ObservableList<CombinedList> combinedList2 = FXCollections.observableArrayList();
        combinedList2.add(combinedData);

        // Set cell value factories for TableView columns
        date_Col.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        orderID_Col.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        item_Col.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        quantity_Col.setCellValueFactory(new PropertyValueFactory<>("orderQuantity"));
        status_Col.setCellValueFactory(new PropertyValueFactory<>("orderType"));
        customerID_Col.setCellValueFactory(new PropertyValueFactory<>("customerID"));

        // Custom cell value factory for payment method column
        payMryhod_Col.setCellValueFactory(cellData -> new SimpleStringProperty(paymentMethod));

        // Bind the combined list to the table view
        newOrder_TV.setItems(combinedList2);
    }


    @javafx.fxml.FXML
    public void fetch_Customer_button(ActionEvent actionEvent) {
        int fetchCustomer;
        try {
            fetchCustomer = Integer.parseInt(customerID_TF.getText());
        } catch (NumberFormatException e) {
            showError("Please enter a valid customer ID");
            return;
        }

        boolean found = false;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DataStore/CustomerList.bin"))) {
            List<Customers> customerList = (List<Customers>) ois.readObject();

            for (Customers customer : customerList) {
                if (customer.getCustomerID() == fetchCustomer) {
                    customerName_label.setText(customer.getCustomerName());
                    sustomerType_label.setText(String.valueOf(customer.getCustomerID()));
                    customerNumber_label.setText(String.valueOf(customer.getCustomerNumber()));
                    customerAdress_label.setText(customer.getCustomerAddress());
                    found = true;
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (!found) {
            showError("Customer Not Found");
        }
        if (customerID_TF.getText().isEmpty()) {
            showError("Customer Text Field is empty");
        }

    }


    @javafx.fxml.FXML
    public void saveOrder_button(ActionEvent actionEvent) {
        DataStore dataStore = new DataStore();
        ObservableList<Orders> orderList = DataStore.getOrderList();

        // Fetch user inputs
        LocalDate orderDate = order_Date_DP.getValue();
        int orderID = Integer.parseInt(order_ID_TF.getText());
        String orderName = (String) order_Name_CB.getValue();
        int orderQuantity = Integer.parseInt(order_Quantity_TF.getText());
        String paymentStatus = (String) pay_Status_CB.getValue();
        String paymentMethod = (String) pay_Method_CB.getValue();
        int customerID = Integer.parseInt(customerID_TF.getText());
        String customerName = customerName_label.getText();
        String customerAddress = customerAdress_label.getText();
        int customerContact = Integer.parseInt(customerNumber_label.getText());
        String orderType = "Pending";

        // Create a new order
        Orders newOrder = new Orders(orderQuantity, orderID, orderName, orderDate, orderType, customerName);

        // Save new order to OrderList.bin
        orderList.add(newOrder);
        saveDataToFile(new ArrayList<>(orderList), "DataStore/OrderList.bin");

        // Read data from InventoryList.bin to find the matched item
        Inventory matchedItem = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DataStore/InventoryList.bin"))) {
            List<Inventory> inventoryList = (List<Inventory>) ois.readObject();
            matchedItem = inventoryList.stream().filter(item -> item.getProduct_name().equals(orderName)).findFirst().orElse(null);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (matchedItem != null) {
            CombinedList combinedData = new CombinedList(
                    matchedItem.getProduct_name(),
                    matchedItem.getProduct_price(),
                    matchedItem.getProduct_stockLevel(),
                    orderDate,
                    orderID,
                    orderQuantity,
                    paymentStatus,
                    customerName,
                    customerID,
                    customerAddress,
                    customerContact
            );

            // Read the existing CombinedList.bin file and add the new combined data
            List<CombinedList> combinedList;
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DataStore/CombinedList.bin"))) {
                combinedList = (List<CombinedList>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                combinedList = FXCollections.observableArrayList();
            }

            combinedList.add(combinedData);

            // Save the updated combined list to CombinedList.bin
            saveDataToFile(new ArrayList<>(combinedList), "DataStore/CombinedList.bin");

            System.out.println(combinedData);

        } else {
            showError("Inventory item not found");
        }
    }

    private <T extends Serializable> void saveDataToFile(List<T> list, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(list);
            System.out.println("Data saved to: " + fileName);
        } catch (IOException e) {
            System.err.println("Failed to save data to " + fileName + ": " + e.getMessage());
        }
    }



    @javafx.fxml.FXML
    public void clear_button(ActionEvent actionEvent) {
        newOrder_TV.getItems().clear();
        order_Date_DP.setValue(null);
        order_ID_TF.clear();
        order_Quantity_TF.clear();
        pay_Status_CB.setValue(null);
        pay_Method_CB.setValue(null);
        customerID_TF.clear();
    }

    @javafx.fxml.FXML
    public void back_button(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            // Handle FXML loading error
            e.printStackTrace();
        }
    }
    }

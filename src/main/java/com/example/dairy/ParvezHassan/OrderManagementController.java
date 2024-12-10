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

public class OrderManagementController {
    @javafx.fxml.FXML
    private AnchorPane orderView_Pane;
    @javafx.fxml.FXML
    private TableColumn quantity_Col;
    @javafx.fxml.FXML
    private Label customerAdress_label;
    @javafx.fxml.FXML
    private TableColumn<CombinedList, Integer> item_Col;
    @javafx.fxml.FXML
    private Label customerNumber_label;
    @javafx.fxml.FXML
    private TableColumn<Orders, LocalDate> date_Col;
    @javafx.fxml.FXML
    private TextField order_ID_TF;
    @javafx.fxml.FXML
    private TextField customerID_TF;
    @javafx.fxml.FXML
    private TextField order_Quantity_TF;
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
    @javafx.fxml.FXML
    private ComboBox<String> orderType_CB;
    @javafx.fxml.FXML
    private TableView <CombinedList> newOrder_TV;
    @javafx.fxml.FXML
    private TableColumn payMryhod_Col;
    @javafx.fxml.FXML
    private AnchorPane addOrder_Pane;
    @javafx.fxml.FXML
    private DatePicker order_Date_DP;
    @javafx.fxml.FXML
    private TableColumn customerID_Col;
    @javafx.fxml.FXML
    private TableColumn orderID_Col;
    @javafx.fxml.FXML
    private TableView<CombinedList> allOrder_TV;
    @javafx.fxml.FXML
    private ComboBox pay_Method_CB;
    @javafx.fxml.FXML
    private AnchorPane orderProcessingPane;
    @javafx.fxml.FXML
    private TableView<CombinedList> pendingOrderTableView;

//    DataStore dataStore = new DataStore();
//    ObservableList<Inventory> stockItems = dataStore.getInventoryList();
//    ObservableList<Transactions> alltransactions = dataStore.getAllTranactions();
//    ObservableList<CombinedList> CombinedList = dataStore.getCombinedList();


    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Login Error");
        alert.setContentText(message);
        alert.showAndWait();
    }


    @javafx.fxml.FXML
    public void initialize() {
        orderType_CB.getItems().addAll("All Orders", "Pending Orders", "Fulfilled Orders");

        orderView_Pane.setVisible(false);
        addOrder_Pane.setVisible(false);


        // Create a list to store item names
        ObservableList<String> inventoryNames = FXCollections.observableArrayList();

        // Read data from InventoryList.txt
        try (BufferedReader br = new BufferedReader(new FileReader("InventoryList.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Remove the class name and braces from the string
                line = line.replace("Inventory{", "").replace("}", "");

                // Split the string by commas
                String[] parts = line.split(", ");

                // Extract and trim the item name
                String itemName = parts[0].split("=")[1].trim().replace("'", "");

                // Add item name to the list
                inventoryNames.add(itemName);
            }
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        // Populate ComboBox with item names
        order_Name_CB.setItems(inventoryNames);




//        LocalDate orderDate = order_Date_DP.getValue();
//        int orderID = Integer.parseInt(order_ID_TF.getText());
//        String odername  =(String) order_Name_CB.getValue();
//        int orderQuantity = Integer.parseInt(order_Quantity_TF.getText());
//        String paymentStatus = (String) pay_Status_CB.getValue();
//        String paymentMethod = (String) pay_Method_CB.getValue();
//        int customerID = Integer.parseInt(customerID_TF.getText());
//        String customerName = customerName_label.getText();
//        String customerAddress = customerAdress_label.getText();
//        int customerContact = Integer.parseInt(customerNumber_label.getText());
//        String orderType = "Pending";

//        date_Col.setCellValueFactory(new PropertyValueFactory<>("Date"));
//        orderID_Col.setCellValueFactory(new PropertyValueFactory<>("Order ID"));
//        item_Col.setCellValueFactory(new PropertyValueFactory<>("Item"));
//        quantity_Col.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
//        payMryhod_Col.setCellValueFactory(new PropertyValueFactory<>("Status"));
//        status_Col.setCellValueFactory(new PropertyValueFactory<>("Method"));
//        customerID_Col.setCellValueFactory(new PropertyValueFactory<>("Customer ID"));





//        TableColumn<CombinedList, String> customernameColumn = new TableColumn<>("Customer Name");
//        customernameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
//
//        TableColumn<CombinedList, String> itemnameColumn = new TableColumn<>("Item Name");
//        itemnameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
//
//        TableColumn<CombinedList, Integer> orderIDColumn = new TableColumn<>("Order ID");
//        orderIDColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
//
//        TableColumn<CombinedList, Integer> orderQuantityColumn = new TableColumn<>("Quantity");
//        orderQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("orderQuantity"));
//
//        TableColumn<CombinedList, Integer> orderTypeColumn = new TableColumn<>("Status");
//        orderTypeColumn.setCellValueFactory(new PropertyValueFactory<>("orderType"));
    }

    @javafx.fxml.FXML
    public void addOrder_button(ActionEvent actionEvent) {
        addOrder_Pane.setVisible(true);
        orderView_Pane.setVisible(false);
        orderProcessingPane.setVisible(false);

        DataStore dataStore = new DataStore();
        ObservableList<Inventory> inventoryLists = dataStore.getInventoryList();

        ObservableList<String> nameList = FXCollections.observableArrayList();


        for (Inventory names : inventoryLists) {
            nameList.add(names.getProduct_name());
        }
        System.out.println("names item " + nameList);
        order_Name_CB.getItems().addAll(nameList);
        pay_Status_CB.getItems().addAll("Pending", "Fulfilled");

        pay_Method_CB.getItems().addAll("Cash", "Card", "Bkash", "Nogod");

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

        try (BufferedReader br = new BufferedReader(new FileReader("CustomerList.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Remove the class name and braces from the string
                line = line.replace("Customers{", "").replace("}", "");

                // Split the string by commas
                String[] parts = line.split(", ");

                // Extract and trim the values
                int customerID = Integer.parseInt(parts[0].split("=")[1].trim());
                String customerName = parts[1].split("=")[1].trim().replace("'", "");
                int customerNumber = Integer.parseInt(parts[2].split("=")[1].trim());
                String paymentDetails = parts[3].split("=")[1].trim().replace("'", "").replace("= ", "");
                String customerAddress = parts[4].split("=")[1].trim().replace("'", "");

                if (customerID == fetchCustomer) {
                    customerName_label.setText(customerName);
                    sustomerType_label.setText(String.valueOf(customerID));
                    customerNumber_label.setText(String.valueOf(customerNumber));
                    customerAdress_label.setText(customerAddress);
                    found = true;
                    break;
                }
            }
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }

        if (!found) {
            showError("Customer Not Found");
        }
        if (customerID_TF.getText().isEmpty()) {
            showError("Customer Text Field is empty");
        }
    }



//


    @javafx.fxml.FXML
    public void show_Button(ActionEvent actionEvent) {
        String selectedOption = orderType_CB.getValue();
        if (selectedOption == null) {
            showError("Please select an option");
        }
        switch (selectedOption) {
            case ("All Orders"):
                showAllOrders();
                break;
            case ("Pending Orders"):
                showPendingOrders();
                break;
            case ("Fulfilled Orders"):
                showFulfilledOrders();
                break;
        }


    }

    @javafx.fxml.FXML
    public void orderOverview_button(ActionEvent actionEvent) {
        orderView_Pane.setVisible(true);
        addOrder_Pane.setVisible(false);
        orderProcessingPane.setVisible(false);

        allOrder_TV.getColumns().clear(); // Clear existing columns

        DataStore dataStore = new DataStore();
        ObservableList<Inventory> stockItems = dataStore.getInventoryList();
        ObservableList<Transactions> alltransactions = dataStore.getAllTransactions();
        ObservableList<CombinedList> CombinedList = dataStore.getCombinedList();


        TableColumn<CombinedList, String> customernameColumn = new TableColumn<>("Customer Name");
        customernameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));

        TableColumn<CombinedList, String> itemnameColumn = new TableColumn<>("Item Name");
        itemnameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));

        TableColumn<CombinedList, Integer> orderIDColumn = new TableColumn<>("Order ID");
        orderIDColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));

        TableColumn<CombinedList, Integer> orderQuantityColumn = new TableColumn<>("Quantity");
        orderQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("orderQuantity"));

        TableColumn<CombinedList, Integer> orderTypeColumn = new TableColumn<>("Status");
        orderTypeColumn.setCellValueFactory(new PropertyValueFactory<>("orderType"));

        allOrder_TV.getColumns().addAll(customernameColumn, itemnameColumn, orderIDColumn, orderQuantityColumn, orderTypeColumn);


    }

    @Deprecated
    public void save_Button(ActionEvent actionEvent) {
        LocalDate date = order_Date_DP.getValue();
        int orderID = Integer.parseInt(order_ID_TF.getText());
        createNewOrder();



    }


    //   Methods
    public void showAllOrders() {
        // Clear existing items in the TableView
        allOrder_TV.getItems().clear();

        // Read data from file and populate the ObservableList
        ObservableList<CombinedList> combinedOrders = FXCollections.observableArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader("CombinedList.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Remove the class name and braces from the string
                line = line.replace("CombinedList{", "").replace("}", "");

                // Split the string by commas
                String[] parts = line.split(", ");

                // Extract and trim the values
                String productName = parts[0].split("=")[1].trim().replace("'", "");
                int productPrice = Integer.parseInt(parts[1].split("=")[1].trim());
                int productStockLevel = Integer.parseInt(parts[2].split("=")[1].trim());
                LocalDate orderDate = LocalDate.parse(parts[3].split("=")[1].trim());
                int orderID = Integer.parseInt(parts[4].split("=")[1].trim());
                int orderQuantity = Integer.parseInt(parts[5].split("=")[1].trim());
                String orderType = parts[6].split("=")[1].trim().replace("'", "");
                String customerName = parts[7].split("=")[1].trim().replace("'", "");
                int customerID = Integer.parseInt(parts[8].split("=")[1].trim());
                String customerAddress = parts[9].split("=")[1].trim().replace("'", "");
                int customerNumber = Integer.parseInt(parts[10].split("=")[1].trim());

                // Create a new CombinedList object and add it to the list
                CombinedList combinedOrder = new CombinedList(
                        productName, productPrice, productStockLevel, orderDate, orderID, orderQuantity,
                        orderType, customerName, customerID, customerAddress, customerNumber
                );
                combinedOrders.add(combinedOrder);
            }
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }

        // Bind the TableView to the ObservableList
        allOrder_TV.setItems(combinedOrders);
    }



    public void showPendingOrders() {
        // Clear existing items in the TableView
        allOrder_TV.getItems().clear();

        // Read data from file and populate the ObservableList
        ObservableList<CombinedList> pendingOrders = FXCollections.observableArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader("CombinedList.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Remove the class name and braces from the string
                line = line.replace("CombinedList{", "").replace("}", "");

                // Split the string by commas
                String[] parts = line.split(", ");

                // Extract and trim the values
                String productName = parts[0].split("=")[1].trim().replace("'", "");
                int productPrice = Integer.parseInt(parts[1].split("=")[1].trim());
                int productStockLevel = Integer.parseInt(parts[2].split("=")[1].trim());
                LocalDate orderDate = LocalDate.parse(parts[3].split("=")[1].trim());
                int orderID = Integer.parseInt(parts[4].split("=")[1].trim());
                int orderQuantity = Integer.parseInt(parts[5].split("=")[1].trim());
                String orderType = parts[6].split("=")[1].trim().replace("'", "");
                String customerName = parts[7].split("=")[1].trim().replace("'", "");
                int customerID = Integer.parseInt(parts[8].split("=")[1].trim());
                String customerAddress = parts[9].split("=")[1].trim().replace("'", "");
                int customerNumber = Integer.parseInt(parts[10].split("=")[1].trim());

                // Only add orders with "Pending" status to the list
                if ("Pending".equals(orderType)) {
                    CombinedList combinedOrder = new CombinedList(
                            productName, productPrice, productStockLevel, orderDate, orderID, orderQuantity,
                            orderType, customerName, customerID, customerAddress, customerNumber
                    );
                    pendingOrders.add(combinedOrder);
                }
            }
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }

        // Bind the TableView to the ObservableList
        allOrder_TV.setItems(pendingOrders);
    }


    public void showFulfilledOrders() {
        // Clear existing items in the TableView
        allOrder_TV.getItems().clear();

        // Read data from file and populate the ObservableList
        ObservableList<CombinedList> fulfilledOrders = FXCollections.observableArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader("CombinedList.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Remove the class name and braces from the string
                line = line.replace("CombinedList{", "").replace("}", "");

                // Split the string by commas
                String[] parts = line.split(", ");

                // Extract and trim the values
                String productName = parts[0].split("=")[1].trim().replace("'", "");
                int productPrice = Integer.parseInt(parts[1].split("=")[1].trim());
                int productStockLevel = Integer.parseInt(parts[2].split("=")[1].trim());
                LocalDate orderDate = LocalDate.parse(parts[3].split("=")[1].trim());
                int orderID = Integer.parseInt(parts[4].split("=")[1].trim());
                int orderQuantity = Integer.parseInt(parts[5].split("=")[1].trim());
                String orderType = parts[6].split("=")[1].trim().replace("'", "");
                String customerName = parts[7].split("=")[1].trim().replace("'", "");
                int customerID = Integer.parseInt(parts[8].split("=")[1].trim());
                String customerAddress = parts[9].split("=")[1].trim().replace("'", "");
                int customerNumber = Integer.parseInt(parts[10].split("=")[1].trim());

                // Only add orders with "Fulfilled" status to the list
                if ("Fulfilled".equals(orderType)) {
                    CombinedList combinedOrder = new CombinedList(
                            productName, productPrice, productStockLevel, orderDate, orderID, orderQuantity,
                            orderType, customerName, customerID, customerAddress, customerNumber
                    );
                    fulfilledOrders.add(combinedOrder);
                }
            }
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }

        // Bind the TableView to the ObservableList
        allOrder_TV.setItems(fulfilledOrders);
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
    public void saveOrder_button(ActionEvent actionEvent) {
        createNewOrder();
    }

    public void createNewOrder() {
        DataStore dataStore = new DataStore();
        ObservableList<Orders> orderList = DataStore.getOrderList();

        // Fetch user inputs
        LocalDate orderDate = order_Date_DP.getValue();
        int orderID = Integer.parseInt(order_ID_TF.getText());
        String odername = (String) order_Name_CB.getValue();
        int orderQuantity = Integer.parseInt(order_Quantity_TF.getText());
        String paymentStatus = (String) pay_Status_CB.getValue();
        String paymentMethod = (String) pay_Method_CB.getValue();
        int customerID = Integer.parseInt(customerID_TF.getText());
        String customerName = customerName_label.getText();
        String customerAddress = customerAdress_label.getText();
        int customerContact = Integer.parseInt(customerNumber_label.getText());
        String orderType = "Pending";

        // Create a new order
        Orders newOrder = new Orders(orderQuantity, orderID, odername, orderDate, orderType, customerName);

        // Append the new order to Orders.txt file
        String orderString = "Orders{orderDate=" + orderDate +
                ", orderName='" + odername + "'" +
                ", OrderID=" + orderID +
                ", orderQuantity=" + orderQuantity +
                ", orderType=" + orderType +
                ", orderCustomerName=" + customerName + "}";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("OrderList.txt", true))) {
            writer.write(orderString);
            writer.newLine(); // Add a new line
            System.out.println("Order added to file: " + orderString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create a new entry in CombinedList
        DataStore dataStore2 = new DataStore();
        ObservableList<CombinedList> combinedList = dataStore.getCombinedList();
        Inventory matchedItem = dataStore.getInventoryList().stream().filter(item -> item.getProduct_name().equals(odername)).findFirst().orElse(null);

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

            combinedList.add(combinedData);
            System.out.println(combinedData);

        } else {
            showError("Inventory item not found");
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
        newOrder_TV.getItems().clear();
        order_Date_DP.setValue(null);
        order_ID_TF.clear();
        order_Quantity_TF.clear();
        pay_Status_CB.setValue(null);
        pay_Method_CB.setValue(null);
        customerID_TF.clear();
        allOrder_TV.getItems().clear();
        orderType_CB.setValue(null);
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

    @javafx.fxml.FXML
    public void markAsFulfilledButton(ActionEvent actionEvent) {
        ObservableList<CombinedList> selectedOrders = pendingOrderTableView.getItems();
        ObservableList<CombinedList> updatedList = FXCollections.observableArrayList();

        // Read existing data from CombinedList.txt and update the order type if necessary
        try (BufferedReader br = new BufferedReader(new FileReader("CombinedList.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Remove the class name and braces from the string
                line = line.replace("CombinedList{", "").replace("}", "");

                // Split the string by commas
                String[] parts = line.split(", ");

                // Extract and trim the values
                String productName = parts[0].split("=")[1].trim().replace("'", "");
                int productPrice = Integer.parseInt(parts[1].split("=")[1].trim());
                int productStockLevel = Integer.parseInt(parts[2].split("=")[1].trim());
                LocalDate orderDate = LocalDate.parse(parts[3].split("=")[1].trim());
                int orderID = Integer.parseInt(parts[4].split("=")[1].trim());
                int orderQuantity = Integer.parseInt(parts[5].split("=")[1].trim());
                String orderType = parts[6].split("=")[1].trim().replace("'", "");
                String customerName = parts[7].split("=")[1].trim().replace("'", "");
                int customerID = Integer.parseInt(parts[8].split("=")[1].trim());
                String customerAddress = parts[9].split("=")[1].trim().replace("'", "");
                int customerNumber = Integer.parseInt(parts[10].split("=")[1].trim());

                // Update orderType to "Fulfilled" if the order is in the selectedOrders list
                boolean isFulfilled = false;
                for (CombinedList order : selectedOrders) {
                    if (order.getOrderID() == orderID) {
                        orderType = "Fulfilled";
                        isFulfilled = true;
                        break;
                    }
                }

                // Create a new CombinedList object with the updated order type
                CombinedList combinedOrder = new CombinedList(
                        productName, productPrice, productStockLevel, orderDate, orderID, orderQuantity,
                        orderType, customerName, customerID, customerAddress, customerNumber
                );
                updatedList.add(combinedOrder);

                // Print a confirmation message for the fulfilled order
                if (isFulfilled) {
                    System.out.println("Order ID " + orderID + " marked as fulfilled and sent to the warehouse.");
                }
            }
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }

        // Write the updated list back to CombinedList.txt
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("CombinedList.txt"))) {
            for (CombinedList order : updatedList) {
                String orderString = "itemName='" + order.getItemName() + "', itemPrice=" + order.getItemPrice() +
                        ", itemLevel=" + order.getItemLevel() + ", orderDate=" + order.getOrderDate() +
                        ", orderID=" + order.getOrderID() + ", orderQuantity=" + order.getOrderQuantity() +
                        ", orderType='" + order.getOrderType() + "', customerName='" + order.getCustomerName() +
                        "', customerID=" + order.getCustomerID() + ", customerAddress='" + order.getCustomerAddress() +
                        "', customerNumber=" + order.getCustomerNumber();
                bw.write(orderString);
                bw.newLine(); // Add a new line
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Refresh the TableView to show the updated order statuses
        showPendingOrders();
    }


    @javafx.fxml.FXML
    public void saveAndSendToWarehouseButton(ActionEvent actionEvent) {
        ObservableList<CombinedList> selectedOrders = pendingOrderTableView.getItems();

        // Create a new file for warehouse data
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("WarehouseOrders.txt"))) {
            for (CombinedList order : selectedOrders) {
                int totalPrice = order.getOrderQuantity() * order.getItemPrice();
                String orderString = "CustomerID=" + order.getCustomerID() +
                        ", CustomerName='" + order.getCustomerName() + "'" +
                        ", CustomerAddress='" + order.getCustomerAddress() + "'" +
                        ", CustomerNumber=" + order.getCustomerNumber() +
                        ", ItemName='" + order.getItemName() + "'" +
                        ", OrderQuantity=" + order.getOrderQuantity() +
                        ", TotalPrice=" + totalPrice;

                writer.write(orderString);
                writer.newLine(); // Add a new line
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Automatically mark orders as fulfilled after saving
//        markAsFulfilledButton(actionEvent);
    }


    @javafx.fxml.FXML
    public void orderProcessingButton(ActionEvent actionEvent) {
        addOrder_Pane.setVisible(false);
        orderView_Pane.setVisible(false);
        orderProcessingPane.setVisible(true);

        // Clear existing items in the TableView
        pendingOrderTableView.getItems().clear();

        // Add columns to the TableView
        TableColumn<CombinedList, String> productNameColumn = new TableColumn<>("Product Name");
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));

        TableColumn<CombinedList, Integer> productPriceColumn = new TableColumn<>("Price");
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));

        TableColumn<CombinedList, Integer> stockLevelColumn = new TableColumn<>("Stock Level");
        stockLevelColumn.setCellValueFactory(new PropertyValueFactory<>("itemLevel"));

        TableColumn<CombinedList, LocalDate> orderDateColumn = new TableColumn<>("Order Date");
        orderDateColumn.setCellValueFactory(new PropertyValueFactory<>("orderDate"));

        TableColumn<CombinedList, Integer> orderIDColumn = new TableColumn<>("Order ID");
        orderIDColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));

        TableColumn<CombinedList, Integer> orderQuantityColumn = new TableColumn<>("Order Quantity");
        orderQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("orderQuantity"));

        TableColumn<CombinedList, String> orderTypeColumn = new TableColumn<>("Order Type");
        orderTypeColumn.setCellValueFactory(new PropertyValueFactory<>("orderType"));

        TableColumn<CombinedList, String> customerNameColumn = new TableColumn<>("Customer Name");
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));

        TableColumn<CombinedList, Integer> customerIDColumn = new TableColumn<>("Customer ID");
        customerIDColumn.setCellValueFactory(new PropertyValueFactory<>("customerID"));

        TableColumn<CombinedList, String> customerAddressColumn = new TableColumn<>("Customer Address");
        customerAddressColumn.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));

        TableColumn<CombinedList, Integer> customerNumberColumn = new TableColumn<>("Customer Number");
        customerNumberColumn.setCellValueFactory(new PropertyValueFactory<>("customerNumber"));

        pendingOrderTableView.getColumns().setAll(
                productNameColumn, productPriceColumn, stockLevelColumn, orderDateColumn, orderIDColumn,
                orderQuantityColumn, orderTypeColumn, customerNameColumn, customerIDColumn,
                customerAddressColumn, customerNumberColumn
        );

        // Read data from file and populate the ObservableList
        ObservableList<CombinedList> pendingOrders = FXCollections.observableArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader("CombinedList.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Remove the class name and braces from the string
                line = line.replace("CombinedList{", "").replace("}", "");

                // Split the string by commas
                String[] parts = line.split(", ");

                // Extract and trim the values
                String productName = parts[0].split("=")[1].trim().replace("'", "");
                int productPrice = Integer.parseInt(parts[1].split("=")[1].trim());
                int productStockLevel = Integer.parseInt(parts[2].split("=")[1].trim());
                LocalDate orderDate = LocalDate.parse(parts[3].split("=")[1].trim());
                int orderID = Integer.parseInt(parts[4].split("=")[1].trim());
                int orderQuantity = Integer.parseInt(parts[5].split("=")[1].trim());
                String orderType = parts[6].split("=")[1].trim().replace("'", "");
                String customerName = parts[7].split("=")[1].trim().replace("'", "");
                int customerID = Integer.parseInt(parts[8].split("=")[1].trim());
                String customerAddress = parts[9].split("=")[1].trim().replace("'", "");
                int customerNumber = Integer.parseInt(parts[10].split("=")[1].trim());

                // Only add orders with "Pending" status to the list
                if ("Pending".equals(orderType)) {
                    CombinedList combinedOrder = new CombinedList(
                            productName, productPrice, productStockLevel, orderDate, orderID, orderQuantity,
                            orderType, customerName, customerID, customerAddress, customerNumber
                    );
                    pendingOrders.add(combinedOrder);
                }
            }
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }

        // Bind the TableView to the ObservableList
        pendingOrderTableView.setItems(pendingOrders);

    }


}

package com.example.milestone3;

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

import java.io.IOException;
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

        DataStore dataStore = new DataStore();
        ObservableList<Inventory> inventoryLists = dataStore.getInventoryList();

        ObservableList<String> nameList = FXCollections.observableArrayList();


        for (Inventory names : inventoryLists) {
            nameList.add(names.getName());
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
            showError("Please enter a calid customer ID");
            return;
        }

        DataStore dataStore = new DataStore();
        ObservableList<Customers> customerList = dataStore.getCustomerList();

        boolean found = false;

        for (Customers ID : customerList) {
            if ((ID.getCustomerID() == fetchCustomer)) {
                customerName_label.setText(ID.customerName);
                sustomerType_label.setText(String.valueOf(ID.customerID));
                customerNumber_label.setText(String.valueOf(ID.customerNumber));
                customerAdress_label.setText(ID.customerAddress);
                found = true;
                break;
            }

        }
        if (!found) {
            showError("Customer Not Found");
        }
        if (customerID_TF.getText().isEmpty()) {
            showError("Customer TextFiled is empty");
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

        allOrder_TV.getColumns().clear(); // Clear existing columns

        DataStore dataStore = new DataStore();
        ObservableList<Inventory> stockItems = dataStore.getInventoryList();
        ObservableList<Transactions> alltransactions = dataStore.getAllTranactions();
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

    ;


    //   Methods
    public void showAllOrders() {
        DataStore dataStore = new DataStore();
        ObservableList<CombinedList> CombinedList = dataStore.getCombinedList();


        allOrder_TV.setItems(FXCollections.observableArrayList(CombinedList));

    }

    public void showPendingOrders() {
        DataStore dataStore = new DataStore();
        ObservableList<CombinedList> combinedList = dataStore.getCombinedList();

        ObservableList<CombinedList> pendingOrders = FXCollections.observableArrayList();
        for (CombinedList item : combinedList) {
            if ("Pending".equals(item.getOrderType())) {
                pendingOrders.add(item);
            }
        }
        allOrder_TV.setItems(FXCollections.observableArrayList(pendingOrders));

    }

    public void showFulfilledOrders() {
        DataStore dataStore = new DataStore();
        ObservableList<CombinedList> combinedList = dataStore.getCombinedList();

        ObservableList<CombinedList> fulfilledOrders = FXCollections.observableArrayList();
        for (CombinedList item : combinedList) {
            if ("Fulfilled".equals(item.getOrderType())) {
                fulfilledOrders.add(item);
            }
        }
        allOrder_TV.setItems(FXCollections.observableArrayList(fulfilledOrders));

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
        ObservableList<Orders> orderList = dataStore.getOrderList();

        // Fetch user inputs
        LocalDate orderDate = order_Date_DP.getValue();
        int orderID = Integer.parseInt(order_ID_TF.getText());
        String odername  =(String) order_Name_CB.getValue();
        int orderQuantity = Integer.parseInt(order_Quantity_TF.getText());
        String paymentStatus = (String) pay_Status_CB.getValue();
        String paymentMethod = (String) pay_Method_CB.getValue();
        int customerID = Integer.parseInt(customerID_TF.getText());
        String customerName = customerName_label.getText();
        String customerAddress = customerAdress_label.getText();
        int customerContact = Integer.parseInt(customerNumber_label.getText());
        String orderType = "Pending";

        // Create a new order
        Orders newOrder = new Orders( orderQuantity, orderID,odername,orderDate,orderType,customerName);
        orderList.add(newOrder);

        // Create a new entry in CombinedList
        DataStore dataStore2 = new DataStore();
        ObservableList<CombinedList> combinedList = dataStore.getCombinedList();
        Inventory matchedItem = dataStore.getInventoryList().stream().filter(item -> item.getName().equals(odername)).findFirst().orElse(null);

        if (matchedItem != null) {
            CombinedList combinedData = new CombinedList(
                    matchedItem.getName(),
                    matchedItem.getPriceperUnit(),
                    matchedItem.getStockLevel(),
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
}}
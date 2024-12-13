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

public class OrderManagementController {
    @javafx.fxml.FXML
    private AnchorPane orderView_Pane;
    @javafx.fxml.FXML
    private ComboBox<String> orderType_CB;
    @javafx.fxml.FXML
    private TableView<CombinedList> allOrder_TV;
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
        orderProcessingPane.setVisible(false);

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
        orderProcessingPane.setVisible(false);

        allOrder_TV.getColumns().clear(); // Clear existing columns

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

//        // Read data from binary file and populate the ObservableList
//        ObservableList<CombinedList> combinedOrders = FXCollections.observableArrayList();
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DataStore/CombinedList.bin"))) {
//            List<CombinedList> combinedList = (List<CombinedList>) ois.readObject();
//            combinedOrders.addAll(combinedList);
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        // Bind the TableView to the ObservableList
//        allOrder_TV.setItems(combinedOrders);

    }


    //   Methods
    public void showAllOrders() {
        // Clear existing items in the TableView
        allOrder_TV.getItems().clear();

        // Read data from binary file and populate the ObservableList
        ObservableList<CombinedList> combinedOrders = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DataStore/CombinedList.bin"))) {
            List<CombinedList> combinedList = (List<CombinedList>) ois.readObject();

            for (CombinedList combinedOrder : combinedList) {
                // Add the order to the list
                combinedOrders.add(combinedOrder);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Bind the TableView to the ObservableList
        allOrder_TV.setItems(combinedOrders);

    }


    public void showPendingOrders() {
        // Clear existing items in the TableView
        allOrder_TV.getItems().clear();

        // Read data from binary file and populate the ObservableList
        ObservableList<CombinedList> pendingOrders = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DataStore/CombinedList.bin"))) {
            List<CombinedList> combinedList = (List<CombinedList>) ois.readObject();

            for (CombinedList combinedOrder : combinedList) {
                // Only add orders with "Pending" status to the list
                if ("Pending".equals(combinedOrder.getOrderType())) {
                    pendingOrders.add(combinedOrder);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Bind the TableView to the ObservableList
        allOrder_TV.setItems(pendingOrders);

    }


    public void showFulfilledOrders() {
        // Clear existing items in the TableView
        allOrder_TV.getItems().clear();

        // Read data from binary file and populate the ObservableList
        ObservableList<CombinedList> fulfilledOrders = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DataStore/CombinedList.bin"))) {
            List<CombinedList> combinedList = (List<CombinedList>) ois.readObject();

            for (CombinedList combinedOrder : combinedList) {
                // Only add orders with "Fulfilled" status to the list
                if ("Fulfilled".equals(combinedOrder.getOrderType())) {
                    fulfilledOrders.add(combinedOrder);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Bind the TableView to the ObservableList
        allOrder_TV.setItems(fulfilledOrders);

    }


    @javafx.fxml.FXML
    public void back_button(ActionEvent actionEvent) {
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
        ObservableList<CombinedList> updatedCombinedList = FXCollections.observableArrayList();
        ObservableList<Orders> updatedOrderList = FXCollections.observableArrayList();

        // Read and update CombinedList.bin
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DataStore/CombinedList.bin"))) {
            List<CombinedList> combinedList = (List<CombinedList>) ois.readObject();
            for (CombinedList order : combinedList) {
                if (selectedOrders.stream().anyMatch(selectedOrder -> selectedOrder.getOrderID() == order.getOrderID())) {
                    order.setOrderType("Fulfilled");
                    System.out.println("Order ID " + order.getOrderID() + " marked as fulfilled and sent to the warehouse.");
                }
                updatedCombinedList.add(order);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Write the updated CombinedList.bin
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DataStore/CombinedList.bin"))) {
            oos.writeObject(new ArrayList<>(updatedCombinedList));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read and update OrderList.bin
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DataStore/OrderList.bin"))) {
            List<Orders> orderList = (List<Orders>) ois.readObject();
            for (Orders order : orderList) {
                if (selectedOrders.stream().anyMatch(selectedOrder -> selectedOrder.getOrderID() == order.getOrderID())) {
                    order.setOrderType("Fulfilled");
                }
                updatedOrderList.add(order);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Write the updated OrderList.bin
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DataStore/OrderList.bin"))) {
            oos.writeObject(new ArrayList<>(updatedOrderList));
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
                Double totalPrice = order.getOrderQuantity() * order.getItemPrice();
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

        // Read data from binary file and populate the ObservableList
        ObservableList<CombinedList> pendingOrders = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DataStore/CombinedList.bin"))) {
            List<CombinedList> combinedList = (List<CombinedList>) ois.readObject();

            for (CombinedList combinedOrder : combinedList) {
                // Only add orders with "Pending" status to the list
                if ("Pending".equals(combinedOrder.getOrderType())) {
                    pendingOrders.add(combinedOrder);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Bind the TableView to the ObservableList
        pendingOrderTableView.setItems(pendingOrders);

    }

}


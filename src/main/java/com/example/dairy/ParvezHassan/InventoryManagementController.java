package com.example.dairy.ParvezHassan;

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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class InventoryManagementController {
    @javafx.fxml.FXML
    private TableView<OrderToSupplier> inventory_TableView;
    @javafx.fxml.FXML
    private TableView<Transactions> trans_TableView;
    @javafx.fxml.FXML
    private ComboBox<String> fil_type_ComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> inventorySel_Combobox;
    @javafx.fxml.FXML
    private TextField fil_search_TextFiled;
    @javafx.fxml.FXML
    private Label status_label;

    DataStore dataStore = new DataStore();
    ObservableList<Inventory> stockItems = dataStore.getInventoryList();
    @javafx.fxml.FXML
    private AnchorPane viewInventoryPane;
    @javafx.fxml.FXML
    private AnchorPane addinventoryPane;


    //    for adding
    @javafx.fxml.FXML
    private TextField input_quantity_TF;
    @javafx.fxml.FXML
    private TextField orderID_textField;
    @javafx.fxml.FXML
    private TableColumn<OrderToSupplier, LocalDate> deliveredDate_Col;
    @javafx.fxml.FXML
    private TableColumn<OrderToSupplier, Integer> quantityOrdered_Col;
    @javafx.fxml.FXML
    private TableColumn<OrderToSupplier, String> itemName_Col;
    @javafx.fxml.FXML
    private TableColumn<OrderToSupplier, LocalDate> orderDate_Col;
    @javafx.fxml.FXML
    private TableColumn<OrderToSupplier, Integer> orderID_Col;
    @javafx.fxml.FXML
    private TableView<OrderToSupplier> addedItem_tableView;
    @javafx.fxml.FXML
    private DatePicker deliveredDate_picker;
    @javafx.fxml.FXML
    private TableColumn<OrderToSupplier, Integer> quantityDelivered2_Col;

    private List<OrderToSupplier> placedOrders = new ArrayList<>();
    private List<OrderToSupplier> inventoryData = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {
        inventorySel_Combobox.getItems().addAll("Current Stock", "Low Stock Items", "Transactions");
        fil_type_ComboBox.getItems().addAll("Raw Material", "Finished Goods", "Packaging Material", "Storage Supplies", "Equipments");
        addinventoryPane.setVisible(false);
        viewInventoryPane.setVisible(false);


        orderID_Col.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        itemName_Col.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        orderDate_Col.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        quantityOrdered_Col.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        deliveredDate_Col.setCellValueFactory(new PropertyValueFactory<>("deliveryDate"));
        quantityDelivered2_Col.setCellValueFactory(new PropertyValueFactory<>("deliveredQuantity"));




        loadInventoryData();
        // Filter data where delivered quantities are 0 and delivered date is null
        List<OrderToSupplier> filteredOrders = placedOrders.stream()
                .filter(order -> order.getDeliveredQuantity() == 0 && order.getDeliveryDate() == null)
                .collect(Collectors.toList());

        addedItem_tableView.getItems().setAll(filteredOrders);


    }

    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Login Error");
        alert.setContentText(message);
        alert.showAndWait();
    }


    private void showCurrentStockLevels() {
        inventory_TableView.setVisible(true);
        trans_TableView.setVisible(false);
        inventory_TableView.getColumns().clear();

        TableColumn<OrderToSupplier, String> nameColumn = new TableColumn<>("Item Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        TableColumn<OrderToSupplier, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("deliveredQuantity"));

        inventory_TableView.getColumns().addAll(nameColumn, quantityColumn);

        ObservableList<OrderToSupplier> inventoryItems = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DataStore/InventoryList.bin"))) {
            List<OrderToSupplier> inventoryList = (List<OrderToSupplier>) ois.readObject();
            inventoryItems.addAll(inventoryList);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        inventory_TableView.setItems(inventoryItems);
    }


    private void showLowStockItems() {

        inventory_TableView.setVisible(true);
        trans_TableView.setVisible(false);

        inventory_TableView.getColumns().clear();

        TableColumn<OrderToSupplier, String> nameColumn = new TableColumn<>("Item Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        TableColumn<OrderToSupplier, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("deliveredQuantity"));


        inventory_TableView.getColumns().addAll(nameColumn, quantityColumn);
        ObservableList<OrderToSupplier> lowStockItems = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DataStore/InventoryList.bin"))) {
            List<OrderToSupplier> inventoryList = (List<OrderToSupplier>) ois.readObject();
            for (OrderToSupplier item : inventoryList){
                if (item.getDeliveredQuantity()< 50){
                    lowStockItems.add(item);
                }
            }
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        inventory_TableView.setItems(lowStockItems);
    }


    public void showTransactions() {
        inventory_TableView.setVisible(false);
        trans_TableView.setVisible(true);
        inventory_TableView.getColumns().clear();
        trans_TableView.getColumns().clear();

        TableColumn<Transactions, LocalDate> dateColumn = new TableColumn<>("Date");
        TableColumn<Transactions, String> nameColumn = new TableColumn<>("Recipient Name");
        TableColumn<Transactions, Integer> idColumn = new TableColumn<>("Transaction ID");
        TableColumn<Transactions, String> typeColumn = new TableColumn<>("Transaction Type");
        TableColumn<Transactions, String> methodColumn = new TableColumn<>("Transaction Method");
        TableColumn<Transactions, Integer> amountColumn = new TableColumn<>("Amount");

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("recipientName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("trans_date"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        methodColumn.setCellValueFactory(new PropertyValueFactory<>("trans_method"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("trans_type"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("trans_ID"));

        trans_TableView.getColumns().addAll(nameColumn, dateColumn, idColumn, typeColumn, methodColumn, amountColumn);

        ObservableList<Transactions> allTransactions = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DataStore/TransactionList.bin"))) {
            List<Transactions> transactionList = (List<Transactions>) ois.readObject();
            allTransactions.addAll(transactionList);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        trans_TableView.setItems(allTransactions);
    }



    @javafx.fxml.FXML
    public void view_Button(ActionEvent actionEvent) {
        String selectedOption = inventorySel_Combobox.getValue();
        if (selectedOption == null) {
            showError("Please select an option");
        }
        switch (selectedOption) {
            case ("Current Stock"):
                showCurrentStockLevels();
                break;
            case ("Low Stock Items"):
                showLowStockItems();
                break;
            case ("Transactions"):
                showTransactions();
                break;
        }

    }

    public void generateCurrentStockLevels() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Report");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(new Stage());

        if (file != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (OrderToSupplier item : inventory_TableView.getItems()) {
                    writer.write("Name: " + item.getItemName() + "\n");
                    writer.write("Category: " + item.getSupplier() + "\n");
                    writer.write("Units Available: " + item.getDeliveredQuantity() + "\n\n");
                }
                status_label.setText("Report saved successfully: " + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
                status_label.setText("Error saving the report.");
            }
        }
    }

    public void generateLowStock() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Report");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(new Stage());

        if (file != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (OrderToSupplier item : inventory_TableView.getItems()) {
                    writer.write("Name: " + item.getItemName() + "\n");
                    writer.write("Category: " + item.getSupplier() + "\n");
                    writer.write("Units Available: " + item.getDeliveryDate() + "\n\n");
                }
                status_label.setText("Report saved successfully: " + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
                status_label.setText("Error saving the report.");
            }
        }
    }

    public void generatetransactions() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Report");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(new Stage());

        if (file != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (Transactions trans : trans_TableView.getItems()) {
                    writer.write("Recipient's Name: " + trans.getRecipientName() + "\n");
                    writer.write("Transaction Type: " + trans.getTrans_type() + "\n");
                    writer.write("Transaction Method: " + trans.getTrans_method() + "\n");
                    writer.write("Transaction ID: " + trans.getTrans_ID() + "\n");
                    writer.write("Transaction Date: " + trans.getTrans_date() + "\n");
                }
                status_label.setText("Report saved successfully: " + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
                status_label.setText("Error saving the report.");
            }
        }
    }


    @javafx.fxml.FXML
    public void generate_report_Button(ActionEvent actionEvent) {
        String genType = inventorySel_Combobox.getValue();
        if (genType == null) {
            showError("Fuck You");
            return;
        }
        switch (genType) {
            case "Current Stock":
                generateCurrentStockLevels();
                break;
            case "Low Stock Items":
                generateLowStock();
                break;
            case "Transactions":
                generatetransactions();
                break;
            default:
                showError("Idiot");
        }
        inventorySel_Combobox.getSelectionModel().clearSelection();
    }


    @javafx.fxml.FXML
    public void filter_button(ActionEvent actionEvent) {
        inventory_TableView.setVisible(true);
        trans_TableView.setVisible(false);

        ObservableList<OrderToSupplier> filteredList = FXCollections.observableArrayList();

        String searchTerm = fil_search_TextFiled.getText().toLowerCase();
        String filteredType = fil_type_ComboBox.getSelectionModel().getSelectedItem();

        // Read data from binary file
        ObservableList<OrderToSupplier> inventoryItems = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DataStore/InventoryList.bin"))) {
            List<OrderToSupplier> inventoryList = (List<OrderToSupplier>) ois.readObject();
            inventoryItems.addAll(inventoryList);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (!searchTerm.isEmpty()) {
            // Search by name
            for (OrderToSupplier inventory : inventoryItems) {
                if (inventory.getItemName().toLowerCase().contains(searchTerm)) {
                    filteredList.add(inventory);
                }
            }
        }  else {
            filteredList = inventoryItems;
        }

        inventory_TableView.setItems(filteredList);
        fil_search_TextFiled.clear();
        fil_type_ComboBox.getSelectionModel().clearSelection();


    }

    @javafx.fxml.FXML
    public void back_button(ActionEvent actionEvent) {
        fil_search_TextFiled.clear();
        fil_type_ComboBox.getSelectionModel().clearSelection();
        inventorySel_Combobox.getSelectionModel().clearSelection();
        trans_TableView.getColumns().clear();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void viewInventory_Button(ActionEvent actionEvent) {
        addinventoryPane.setVisible(false);
        viewInventoryPane.setVisible(true);
    }

    @javafx.fxml.FXML
    public void addInventory_Button(ActionEvent actionEvent) {
        addinventoryPane.setVisible(true);
        viewInventoryPane.setVisible(false);
    }


    private void loadInventoryData() {
        File file = new File("DataStore/PlacedOrderToSupplier.bin");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                placedOrders = (List<OrderToSupplier>) ois.readObject();
                addedItem_tableView.getItems().setAll(placedOrders);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }



    }
    private void saveInventoryData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DataStore/InventoryList.bin"))) {
            oos.writeObject(new ArrayList<>(inventoryData));
            System.out.println("Inventory data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void savePlacedOrders() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DataStore/PlacedOrderToSupplier.bin"))) {
            oos.writeObject(placedOrders);
            System.out.println("Placed orders updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @javafx.fxml.FXML
    public void back_button2(ActionEvent actionEvent) {
        input_quantity_TF.clear();
        addedItem_tableView.getItems().clear();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
//UPDATING TO PLACEDORDERTOSUPPLER.BIN
    @javafx.fxml.FXML
    public void addItems_Button(ActionEvent actionEvent) {
        int orderID = Integer.parseInt(orderID_textField.getText());
        LocalDate deliveryDate = deliveredDate_picker.getValue();
        int quantityRecieved = Integer.parseInt(input_quantity_TF.getText());

        for (OrderToSupplier order : placedOrders){
            if (order.getOrderId()== orderID){
                order.setDeliveredQuantity(quantityRecieved);
                order.setDeliveryDate(deliveryDate);

                inventoryData.add(order);
                break;
            }
        }
        addedItem_tableView.refresh();
        saveInventoryData();
        savePlacedOrders();

        System.out.println("Order updated in InventoryList.bin");
        System.out.println("Delivery Date & Quantity updated in PlacedOrderToInventory.bin");
    }
}


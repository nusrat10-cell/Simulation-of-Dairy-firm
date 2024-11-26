package com.example.milestone3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;


public class InventoryManagementController {
    @javafx.fxml.FXML
    private TableView<Inventory> inventory_TableView;
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
    ObservableList<Transactions> alltransactions = dataStore.getAllTranactions();

    @javafx.fxml.FXML
    public void initialize() {
        inventorySel_Combobox.getItems().addAll("Current Stock", "Low Stock Items", "Transactions");
        fil_type_ComboBox.getItems().addAll("Raw Material", "Finished Goods", "Packaging Material", "Storage Supplies", "Equipments");
        inventory_TableView.setVisible(true);

    }

    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Login Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Populate data or import from excel1234
//    ObservableList<Inventory> stockItems = FXCollections.observableArrayList(
//            new Inventory("Milk", 100, 44, 100, "Raw Material"),
//            new Inventory("Cheese", 100, 44, 100, "Finished Goods"),
//            new Inventory("Butter", 100, 44, 100, "Raw Material"),
//            new Inventory("Paneer", 100, 44, 30, "Packaging Material"),
//            new Inventory("Condensed Milk", 100, 44, 60, "Storage Supplies"),
//            new Inventory("Whey", 100, 44, 44, "Equipments")
//    );
//    //    populate transaction list or import
//    ObservableList<Transactions> alltransactions = FXCollections.observableArrayList(
//            new Transactions("rahman", LocalDate.of(2023, 11, 23), 1990, "bkash", "credit", 1998),
//            new Transactions("rahman", LocalDate.of(2023, 11, 23), 1990, "bkash", "credit", 1998),
//            new Transactions("rahman", LocalDate.of(2023, 11, 23), 1990, "bkash", "credit", 1998),
//            new Transactions("rahman", LocalDate.of(2023, 11, 23), 1990, "bkash", "credit", 1998)
//    );

    // stock levels
    private void showCurrentStockLevels() {
        inventory_TableView.setVisible(true);
        trans_TableView.setVisible(false);
        inventory_TableView.getColumns().clear(); // Clear existing columns


        TableColumn<Inventory, String> nameColumn = new TableColumn<>("Item Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Inventory, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<Inventory, Integer> quantityColumn = new TableColumn<>("Units available");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("stockLevel"));

        inventory_TableView.getColumns().addAll(nameColumn, categoryColumn, quantityColumn);


        inventory_TableView.setItems(FXCollections.observableArrayList(stockItems));
    }

//     low stock items

    private void showLowStockItems() {
        inventory_TableView.setVisible(true);
        trans_TableView.setVisible(false);
        inventory_TableView.getColumns().clear(); // Clear existing columns

        // Create columns
        TableColumn<Inventory, String> nameColumn = new TableColumn<>("Item Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Inventory, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<Inventory, Integer> quantityColumn = new TableColumn<>("Units available");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("stockLevel"));

        inventory_TableView.getColumns().addAll(nameColumn, categoryColumn, quantityColumn);

        ObservableList<Inventory> filteredStockItems = FXCollections.observableArrayList();
        for (Inventory item : stockItems) {
            if (item.getStockLevel() < 50) {
                filteredStockItems.add(item);

            }
        }
        inventory_TableView.setItems(filteredStockItems);
    }

    public void showTransactions() {
        // Clear existing columns
        inventory_TableView.setVisible(false);
        trans_TableView.setVisible(true);
        inventory_TableView.getColumns().clear();
        trans_TableView.getColumns().clear();

// Create columns
        TableColumn<Transactions, String> nameColumn = new TableColumn<>("Recipient Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("recipientName"));

        TableColumn<Transactions, Integer> idColumn = new TableColumn<>("Transaction ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("trans_ID"));

        TableColumn<Transactions, String> typeColumn = new TableColumn<>("Transaction Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("trans_type"));

        TableColumn<Transactions, String> methodColumn = new TableColumn<>("Transaction Method");
        methodColumn.setCellValueFactory(new PropertyValueFactory<>("trans_method"));

        TableColumn<Transactions, Integer> amountColumn = new TableColumn<>("Amount");
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

// Optional: Uncomment and correct the date column if needed
// TableColumn<Transactions, Integer> dateColumn = new TableColumn<>("Date");
// dateColumn.setCellValueFactory(new PropertyValueFactory<>("trans_date"));

// Add columns to the TableView
        trans_TableView.getColumns().addAll(nameColumn, idColumn, typeColumn, methodColumn, amountColumn);
// Optional: Add the date column if needed
// trans_TableView.getColumns().add(dateColumn);
//        trans_TableView.setItems(alltransactions);
        trans_TableView.setItems(FXCollections.observableArrayList(alltransactions));



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

    public void generateCurrentStockLevels (){
        // Use FileChooser to select the save location
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Report");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(new Stage());

        if (file != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                // Write the report content
                for (Inventory item : inventory_TableView.getItems()) {
                    writer.write("Name: " + item.getName() + "\n");
                    writer.write("Category: " + item.getType() + "\n");
                    writer.write("Units Available: " + item.getStockLevel() + "\n\n");
                }
                status_label.setText("Report saved successfully: " + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
                status_label.setText("Error saving the report.");
            }
        }
    }

    public void generateLowStock (){
        // Use FileChooser to select the save location
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Report");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(new Stage());

        if (file != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                // Write the report content
                for (Inventory item : inventory_TableView.getItems()) {
                    writer.write("Name: " + item.getName() + "\n");
                    writer.write("Category: " + item.getType() + "\n");
                    writer.write("Units Available: " + item.getStockLevel() + "\n\n");
                }
                status_label.setText("Report saved successfully: " + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
                status_label.setText("Error saving the report.");
            }
        }
    }

    public void generatetransactions (){
        // Use FileChooser to select the save location
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Report");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(new Stage());

        if (file != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                // Write the report content
                for (Transactions trans : trans_TableView.getItems()) {
                    writer.write("Recipient's Name: " + trans.getRecipientName()+ "\n");
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


    //    @javafx.fxml.FXML
    @javafx.fxml.FXML
    public void generate_report_Button(ActionEvent actionEvent) {
        String genType =inventorySel_Combobox.getValue();
        if (genType == null){
            showError("Fuck You");
            return;
        }
        switch (genType){
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



//("Current Stock", "Low Stock Items", "Transactions")

    @javafx.fxml.FXML
    public void filter_button(ActionEvent actionEvent) {
        inventory_TableView.setVisible(true);
        trans_TableView.setVisible(false);

        ObservableList<Inventory> filteredList = FXCollections.observableArrayList();

        String searchTerm = fil_search_TextFiled.getText().toLowerCase();
        String filteredType = fil_type_ComboBox.getSelectionModel().getSelectedItem();


        if (!searchTerm.isEmpty()) {
            // Search by name
            for (Inventory inventory : stockItems) {
                if (inventory.getName().toLowerCase().contains(searchTerm)) {
                    filteredList.add(inventory);
                }
            }
        } else if (filteredType != null && !filteredType.isEmpty()) {

            for (Inventory inventory : stockItems) {
                if (inventory.getType().equals(filteredType)) {
                    filteredList.add(inventory);
                }
            }
        } else {
            // No filter applied, show all items
            filteredList = stockItems;
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
            // Handle FXML loading error
            e.printStackTrace();
        }
    }
}

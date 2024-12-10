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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
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
    ObservableList<Transactions> alltransactions = dataStore.getAllTransactions();

    private static final String FILE_PATH = "C:/ProjectDatabase/TransactionData.txt"; // Same path as used for saving the file


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


    // stock levels
    private void showCurrentStockLevels() {
        inventory_TableView.setVisible(true);
        trans_TableView.setVisible(false);
        inventory_TableView.getColumns().clear(); // Clear existing columns


        TableColumn<Inventory, String> nameColumn = new TableColumn<>("Item Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("product_name"));

        TableColumn<Inventory, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("product_type"));

        TableColumn<Inventory, Integer> quantityColumn = new TableColumn<>("Units available");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("product_stockLevel"));

        inventory_TableView.getColumns().addAll(nameColumn, categoryColumn, quantityColumn);


//        inventory_TableView.setItems(FXCollections.observableArrayList(stockItems));
        ObservableList<Inventory> inventoryItems = FXCollections.observableArrayList();
        try {
            BufferedReader br = new BufferedReader(new FileReader("InventoryList.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                // Remove the class name and braces from the string
                line = line.replace("Inventory{", "").replace("}", "");

                // Split the string by commas
                String[] parts = line.split(", ");

                // Extract and trim the values
                String productName = parts[0].split("=")[1].trim().replace("'", "");
                int productPrice = Integer.parseInt(parts[1].split("=")[1].trim());
                int stockLevel = Integer.parseInt(parts[2].split("=")[1].trim());
                String productType = parts[3].split("=")[1].trim().replace("'", "");

                Inventory inventory = new Inventory(productName, productPrice, stockLevel, productType);
                inventoryItems.add(inventory);
            }
            br.close();
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }

        // Bind the TableView to the ObservableList
        inventory_TableView.setItems(inventoryItems);

    }

//     low stock items

    private void showLowStockItems() {
        // Make inventory table visible and transaction table invisible
        inventory_TableView.setVisible(true);
        trans_TableView.setVisible(false);

        // Clear existing columns
        inventory_TableView.getColumns().clear();

        // Define columns
        TableColumn<Inventory, String> nameColumn = new TableColumn<>("Item Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("product_name"));

        TableColumn<Inventory, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("product_type"));

        TableColumn<Inventory, Integer> quantityColumn = new TableColumn<>("Units available");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("product_stockLevel"));

        TableColumn<Inventory, Integer> priceColumn = new TableColumn<>("Price per Unit");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("product_price"));

        // Add columns to the TableView
        inventory_TableView.getColumns().addAll(nameColumn, categoryColumn, quantityColumn, priceColumn);

        // Read data from file and populate the ObservableList
        ObservableList<Inventory> inventoryItems = FXCollections.observableArrayList();
        try {
            BufferedReader br = new BufferedReader(new FileReader("InventoryList.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                // Remove the class name and braces from the string
                line = line.replace("Inventory{", "").replace("}", "");

                // Split the string by commas
                String[] parts = line.split(", ");

                // Extract and trim the values
                String productName = parts[0].split("=")[1].trim().replace("'", "");
                int productPrice = Integer.parseInt(parts[1].split("=")[1].trim());
                int stockLevel = Integer.parseInt(parts[2].split("=")[1].trim());
                String productType = parts[3].split("=")[1].trim().replace("'", "");

                // Only add items with stock level less than 50
                if (stockLevel < 50) {
                    Inventory inventory = new Inventory(productName, productPrice, stockLevel, productType);
                    inventoryItems.add(inventory);
                }
            }
            br.close();
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }

        // Bind the TableView to the ObservableList
        inventory_TableView.setItems(inventoryItems);
    }

    public void showTransactions() {
        // Clear existing columns
        inventory_TableView.setVisible(false);
        trans_TableView.setVisible(true);
        inventory_TableView.getColumns().clear();
        trans_TableView.getColumns().clear();

        // Define columns
        TableColumn<Transactions, LocalDate> dateColumn = new TableColumn<>("Date");
        TableColumn<Transactions, String> nameColumn = new TableColumn<>("Recipient Name");
        TableColumn<Transactions, Integer> idColumn = new TableColumn<>("Transaction ID");
        TableColumn<Transactions, String> typeColumn = new TableColumn<>("Transaction Type");
        TableColumn<Transactions, String> methodColumn = new TableColumn<>("Transaction Method");
        TableColumn<Transactions, Integer> amountColumn = new TableColumn<>("Amount");

        // Set cell value factories with exact property names
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("recipientName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("trans_date"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        methodColumn.setCellValueFactory(new PropertyValueFactory<>("trans_method"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("trans_type"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("trans_ID"));

        // Add columns to the TableView
        trans_TableView.getColumns().addAll(nameColumn, dateColumn, idColumn, typeColumn, methodColumn, amountColumn);

        // Read data from file and populate the ObservableList
        ObservableList<Transactions> allTransactions = FXCollections.observableArrayList();
        try {
            BufferedReader br = new BufferedReader(new FileReader("TransactionList.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                // Remove the class name and braces from the string
                line = line.replace("Transactions{", "").replace("}", "");

                // Split the string by commas
                String[] parts = line.split(", ");

                // Extract and trim the values
                String recipientName = parts[0].split("=")[1].trim().replace("'", "");
                LocalDate transDate = LocalDate.parse(parts[5].split("=")[1].trim());
                int amount = Integer.parseInt(parts[4].split("=")[1].trim());
                String transMethod = parts[3].split("=")[1].trim().replace("'", "");
                String transType = parts[2].split("=")[1].trim().replace("'", "");
                int transID = Integer.parseInt(parts[1].split("=")[1].trim());

                Transactions transaction = new Transactions(recipientName, transDate, amount, transMethod, transType, transID);
                allTransactions.add(transaction);
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Bind the TableView to the ObservableList
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
        // Use FileChooser to select the save location
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Report");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(new Stage());

        if (file != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                // Write the report content
                for (Inventory item : inventory_TableView.getItems()) {
                    writer.write("Name: " + item.getProduct_name() + "\n");
                    writer.write("Category: " + item.getProduct_type() + "\n");
                    writer.write("Units Available: " + item.getProduct_stockLevel() + "\n\n");
                }
                status_label.setText("Report saved successfully: " + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
                status_label.setText("Error saving the report.");
            }
        }
    }

    public void generateLowStock() {
        // Use FileChooser to select the save location
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Report");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(new Stage());

        if (file != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                // Write the report content
                for (Inventory item : inventory_TableView.getItems()) {
                    writer.write("Name: " + item.getProduct_name() + "\n");
                    writer.write("Category: " + item.getProduct_type() + "\n");
                    writer.write("Units Available: " + item.getProduct_stockLevel() + "\n\n");
                }
                status_label.setText("Report saved successfully: " + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
                status_label.setText("Error saving the report.");
            }
        }
    }

    public void generatetransactions() {
        // Use FileChooser to select the save location
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Report");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(new Stage());

        if (file != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                // Write the report content
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


    //    @javafx.fxml.FXML
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
                if (inventory.getProduct_name().toLowerCase().contains(searchTerm)) {
                    filteredList.add(inventory);
                }
            }
        } else if (filteredType != null && !filteredType.isEmpty()) {

            for (Inventory inventory : stockItems) {
                if (inventory.getProduct_type().equals(filteredType)) {
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


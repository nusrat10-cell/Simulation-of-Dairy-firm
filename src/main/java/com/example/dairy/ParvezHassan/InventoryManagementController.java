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
    @javafx.fxml.FXML
    private AnchorPane viewInventoryPane;
    @javafx.fxml.FXML
    private TableColumn<Inventory,Integer> quantity_Col;
    @javafx.fxml.FXML
    private AnchorPane addinventoryPane;
    @javafx.fxml.FXML
    private TableView<Inventory> addedItem_tableView;
    @javafx.fxml.FXML
    private TableColumn<Inventory, String> name_Col;
    @javafx.fxml.FXML
    private TableColumn<Inventory, Double> price_Col;
    @javafx.fxml.FXML
    private TextField input_quantity_TF;
    @javafx.fxml.FXML
    private TableColumn<Inventory,String> type_Col;

    private final ObservableList<Inventory> inventoryData = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private ComboBox item_type_ComboBox;
    @javafx.fxml.FXML
    private TextField input_itemName;


    @javafx.fxml.FXML
    public void initialize() {
        inventorySel_Combobox.getItems().addAll("Current Stock", "Low Stock Items", "Transactions");
        fil_type_ComboBox.getItems().addAll("Raw Material", "Finished Goods", "Packaging Material", "Storage Supplies", "Equipments");
        addinventoryPane.setVisible(false);
        viewInventoryPane.setVisible(false);
        item_type_ComboBox.getItems().addAll("Raw Material", "Finished Goods", "Packaging Material", "Storage Supplies", "Equipments");

        name_Col.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        price_Col.setCellValueFactory(new PropertyValueFactory<>("product_price"));
        quantity_Col.setCellValueFactory(new PropertyValueFactory<>("product_stockLevel"));
        type_Col.setCellValueFactory(new PropertyValueFactory<>("product_type"));


        addedItem_tableView.setItems(inventoryData);
        loadInventoryData();

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

        TableColumn<Inventory, String> nameColumn = new TableColumn<>("Item Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        TableColumn<Inventory, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("product_type"));
        TableColumn<Inventory, Integer> quantityColumn = new TableColumn<>("Units available");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("product_stockLevel"));
        inventory_TableView.getColumns().addAll(nameColumn, categoryColumn, quantityColumn);

        ObservableList<Inventory> inventoryItems = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DataStore/InventoryList.bin"))) {
            List<Inventory> inventoryList = (List<Inventory>) ois.readObject();
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

        TableColumn<Inventory, String> nameColumn = new TableColumn<>("Item Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        TableColumn<Inventory, String> categoryColumn = new TableColumn<>("Category");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("product_type"));
        TableColumn<Inventory, Integer> quantityColumn = new TableColumn<>("Units available");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("product_stockLevel"));
        TableColumn<Inventory, Integer> priceColumn = new TableColumn<>("Price per Unit");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("product_price"));

        inventory_TableView.getColumns().addAll(nameColumn, categoryColumn, quantityColumn, priceColumn);
        ObservableList<Inventory> inventoryItems = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DataStore/InventoryList.bin"))) {
            List<Inventory> inventoryList = (List<Inventory>) ois.readObject();
            for (Inventory inventory : inventoryList) {
                if (inventory.getProduct_stockLevel() < 50) {
                    inventoryItems.add(inventory);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        inventory_TableView.setItems(inventoryItems);
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
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Report");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(new Stage());

        if (file != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
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

        ObservableList<Inventory> filteredList = FXCollections.observableArrayList();

        String searchTerm = fil_search_TextFiled.getText().toLowerCase();
        String filteredType = fil_type_ComboBox.getSelectionModel().getSelectedItem();

        // Read data from binary file
        ObservableList<Inventory> inventoryItems = FXCollections.observableArrayList();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DataStore/InventoryList.bin"))) {
            List<Inventory> inventoryList = (List<Inventory>) ois.readObject();
            inventoryItems.addAll(inventoryList);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (!searchTerm.isEmpty()) {
            // Search by name
            for (Inventory inventory : inventoryItems) {
                if (inventory.getProduct_name().toLowerCase().contains(searchTerm)) {
                    filteredList.add(inventory);
                }
            }
        } else if (filteredType != null && !filteredType.isEmpty()) {
            for (Inventory inventory : inventoryItems) {
                if (inventory.getProduct_type().equals(filteredType)) {
                    filteredList.add(inventory);
                }
            }
        } else {
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

    @javafx.fxml.FXML
    public void addButton(ActionEvent actionEvent) {
        String name = input_itemName.getText().trim().toLowerCase();
        int quantity;
        String type = (String) item_type_ComboBox.getSelectionModel().getSelectedItem();

        try {
            quantity = Integer.parseInt(input_quantity_TF.getText());
        } catch (NumberFormatException e) {
            System.err.println("Please enter valid numbers for quantity and price.");
            return;
        }
// Check if the item already exists in the inventory
        Optional<Inventory> existingItem = inventoryData.stream()
                .filter(item -> item.getProduct_name().trim().toLowerCase().equals(name))
                .findFirst();

        if (existingItem.isPresent()) {
            Inventory item = existingItem.get();
            item.setProduct_stockLevel(item.getProduct_stockLevel() + quantity);
            addedItem_tableView.refresh();
        } else {
            Inventory newItem = new Inventory(name, 0.0, quantity, type);
            inventoryData.add(newItem);
        }

        saveInventoryData();
    }

    private void loadInventoryData() {
        File file = new File("DataStore/InventoryList.bin");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                List<Inventory> inventoryList = (List<Inventory>) ois.readObject();
                inventoryData.addAll(inventoryList);
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


    @javafx.fxml.FXML
    public void back_button2(ActionEvent actionEvent) {
        input_itemName.clear();
        item_type_ComboBox.getSelectionModel().clearSelection();
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
}


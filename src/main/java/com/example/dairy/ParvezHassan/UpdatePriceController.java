package com.example.dairy.ParvezHassan;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class UpdatePriceController {
    @FXML
    private TextField newPriceTF;
    @FXML
    private TableColumn<InventoryWithNewPrice, String> newPriceCol;
    @FXML
    private TableColumn<InventoryWithNewPrice, String> nameCol;
    @FXML
    private TableColumn<InventoryWithNewPrice, Integer> quantityCol;
    @FXML
    private ComboBox<String> selectComboBox;
    @FXML
    private TableColumn<InventoryWithNewPrice, Double> oldPriceCol;
    @FXML
    private TableView<InventoryWithNewPrice> priceTableView;

    private final ObservableList<InventoryWithNewPrice> inventoryData = FXCollections.observableArrayList();
    @FXML
    private Label label_label;

    @FXML
    public void initialize() {
        loadInventoryData();
        selectComboBox.setItems(FXCollections.observableArrayList(
                inventoryData.stream().map(InventoryWithNewPrice::getProduct_name).distinct().sorted().toList()
        ));

        nameCol.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        oldPriceCol.setCellValueFactory(new PropertyValueFactory<>("product_price"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("product_stockLevel"));
        newPriceCol.setCellValueFactory(new PropertyValueFactory<>("newPrice"));
    }

    @FXML
    public void load_Button(ActionEvent actionEvent) {
        FXCollections.sort(inventoryData, Comparator.comparing(InventoryWithNewPrice::getProduct_name));
        priceTableView.setItems(inventoryData);
        priceTableView.refresh();
    }

    @FXML
    public void backButton(ActionEvent actionEvent) {
        newPriceTF.clear();
        priceTableView.getItems().clear();
        selectComboBox.getSelectionModel().clearSelection();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void updateButton(ActionEvent actionEvent) {
        String selectedItem = selectComboBox.getSelectionModel().getSelectedItem();
        double newPrice;

        try {
            newPrice = Double.parseDouble(newPriceTF.getText());
        } catch (NumberFormatException e) {
            System.err.println("Please enter a valid number for the new price.");
            return;
        }

        Optional<InventoryWithNewPrice> itemToUpdate = inventoryData.stream()
                .filter(item -> item.getProduct_name().equals(selectedItem))
                .findFirst();

        itemToUpdate.ifPresent(item -> {
            item.setNewPrice(String.valueOf(newPrice));
            priceTableView.refresh();
        });
    }

    @FXML
    public void setPrice_button(ActionEvent actionEvent) {
        for (InventoryWithNewPrice item : inventoryData) {
            if (!item.getNewPrice().equals("-")) {
                item.setProduct_price(Double.parseDouble(item.getNewPrice())); // Update the actual price
            }
        }

        saveInventoryData();
        label_label.setText("Updated Price");
    }

    private void loadInventoryData() {
        File file = new File("DataStore/InventoryList.bin");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                List<Inventory> inventoryList = (List<Inventory>) ois.readObject();
                for (Inventory item : inventoryList) {
                    inventoryData.add(new InventoryWithNewPrice(item.getProduct_name(), item.getProduct_price(), item.getProduct_stockLevel(), item.getProduct_type(), "-"));
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveInventoryData() {
        List<Inventory> originalData = new ArrayList<>();
        for (InventoryWithNewPrice item : inventoryData) {
            originalData.add(new Inventory(item.getProduct_name(), item.getProduct_price(), item.getProduct_stockLevel(), item.getProduct_type()));
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DataStore/InventoryList.bin"))) {
            oos.writeObject(originalData);
            System.out.println("Inventory data saved successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class InventoryWithNewPrice extends Inventory {
        private String newPrice;

        public InventoryWithNewPrice(String name, double price, int stockLevel, String type, String newPrice) {
            super(name, price, stockLevel, type);
            this.newPrice = newPrice;
        }

        public String getNewPrice() {
            return newPrice;
        }

        public void setNewPrice(String newPrice) {
            this.newPrice = newPrice;
        }
    }
}

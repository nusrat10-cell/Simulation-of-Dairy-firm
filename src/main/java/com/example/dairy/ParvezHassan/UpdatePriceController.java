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
    private TableColumn<OrderToSupplier, String> nameCol;
    @FXML
    private TableColumn<OrderToSupplier, Integer> quantityCol;
    @FXML
    private TableColumn<OrderToSupplier, Double> oldPriceCol;
    @FXML
    private TableView<OrderToSupplier> priceTableView;
    @FXML
    private ComboBox<String> selectComboBox;
    @FXML
    private Label label_label;

    private final ObservableList<OrderToSupplier> inventoryData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        loadInventoryData();
        selectComboBox.setItems(FXCollections.observableArrayList(
                inventoryData.stream().map(OrderToSupplier::getItemName).distinct().sorted().toList()
        ));

        nameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        oldPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("deliveredQuantity"));
    }

    @FXML
    public void load_Button(ActionEvent actionEvent) {
        FXCollections.sort(inventoryData, Comparator.comparing(OrderToSupplier::getItemName));
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
    public void setPrice_button(ActionEvent actionEvent) {
        String selectedItem = selectComboBox.getSelectionModel().getSelectedItem();
        double newPrice;

        try {
            newPrice = Double.parseDouble(newPriceTF.getText());
        } catch (NumberFormatException e) {
            System.err.println("Please enter a valid number for the new price.");
            label_label.setText("Invalid price entry.");
            return;
        }

        boolean itemFound = false;
        for (OrderToSupplier item : inventoryData) {
            if (item.getItemName().equals(selectedItem)) {
                item.setPrice(newPrice);
                itemFound = true;
                break;
            }
        }

        if (itemFound) {
            saveInventoryData();
            label_label.setText("Price updated successfully.");
            priceTableView.refresh();
        } else {
            label_label.setText("Item not found.");
        }

        // Clear the input fields
        newPriceTF.clear();
        selectComboBox.getSelectionModel().clearSelection();
    }

    private void loadInventoryData() {
        File file = new File("DataStore/InventoryList.bin");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                List<OrderToSupplier> inventoryList = (List<OrderToSupplier>) ois.readObject();
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
}

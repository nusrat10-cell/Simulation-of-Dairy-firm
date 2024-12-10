package com.example.dairy.Nupur;

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

import java.io.IOException;
import java.time.LocalDate;

public class ManageInventoryLevel {

    @FXML
    private TableView<inventoryModelClass> inventoryTV;
    @FXML
    private TableColumn<inventoryModelClass, Integer> stockLevelTC;
    @FXML
    private TableColumn<inventoryModelClass, String> productNameTC;
    @FXML
    private ComboBox<String> selectProductCB;
    @FXML
    private TableColumn<inventoryModelClass, Integer> minimumStockTC;
    @FXML
    private TableColumn<inventoryModelClass, LocalDate> expiryDateTC;
    @FXML
    private Label label;
    @FXML
    private Button restockButton;

    private ObservableList<inventoryModelClass> productList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        productNameTC.setCellValueFactory(new PropertyValueFactory<>("productName"));
        stockLevelTC.setCellValueFactory(new PropertyValueFactory<>("stockLevel"));
        minimumStockTC.setCellValueFactory(new PropertyValueFactory<>("minimumStock"));
        expiryDateTC.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));

        productList.addAll(
                new inventoryModelClass("Milk", LocalDate.of(2024, 12, 31), 20, 50),
                new inventoryModelClass("Cheese", LocalDate.of(2024, 10, 15), 30, 8),
                new inventoryModelClass("Butter", LocalDate.of(2024, 11, 20), 25, 45),
                new inventoryModelClass("Yogurt", LocalDate.of(2024, 12, 10), 35, 70),
                new inventoryModelClass("Cream", LocalDate.of(2024, 12, 20), 15, 17),
                new inventoryModelClass("Ghee", LocalDate.of(2024, 12, 25), 25, 20),
                new inventoryModelClass("IceCream", LocalDate.of(2024, 12, 18), 30, 17),
                new inventoryModelClass("Paneer", LocalDate.of(2024, 12, 9), 20, 75)

        );

        inventoryTV.setItems(productList);
        selectProductCB.setItems(FXCollections.observableArrayList("Milk", "Cheese", "Butter", "Yogurt","Cream","IceCream","Paneer","Ghee"));


    }


    @FXML
    public void restockButton(ActionEvent actionEvent) {
        String selectedProductName = selectProductCB.getValue();

        if (selectedProductName == null) {
            showAlert("Error", "Please select a product to restock.", Alert.AlertType.ERROR);
            return;
        }

        for (inventoryModelClass product : productList) {
            if (product.getProductName().equals(selectedProductName)) {
                // Check if the current stock level is less than or equal to the minimum stock level
                if (product.getStockLevel() <= product.getMinimumStock()) {
                    // If the condition is true, restock the product and increase stock level by 10)
                    int newStockLevel = product.getStockLevel() + 10;
                    product.setStockLevel(newStockLevel);

                    // Refresh the TableView to reflect the updated stock level
                    inventoryTV.refresh();

                    // Update the label to show success message
                    label.setText(selectedProductName + " restocked. New stock level: " + newStockLevel);
                } else {
                    // If the condition is false, show a message
                    label.setText(selectedProductName + " already has sufficient stock.");
                }
                return; // Exit the loop once the product is found
            }
        }

        // If the product is not found in the list (edge case)
        showAlert("Error", "Product not found in the inventory.", Alert.AlertType.ERROR);
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
        {
        }
    }
    @FXML
    public void backButton(ActionEvent actionEvent) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("Inventory Manager Dashboard.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            // Handle FXML loading error
            e.printStackTrace();
        }
    }
}

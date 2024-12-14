package com.example.dairy.Nupur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class UpdateStock {

    @FXML
    private DatePicker deliveryDateDP;
    @FXML
    private TextField batchNumberTF;
    @FXML
    private Label errorMessageLabel;
    @FXML
    private TextField productNameTF;
    @FXML
    private DatePicker expiryDateDP;
    @FXML
    private TextField receivedQuantityTF;
    @FXML
    private ComboBox<String> storageLocationCB;

    @FXML
    public void initialize() {
        storageLocationCB.getItems().addAll("Warehouse A", "Warehouse B", "Refrigeration Unit 1", "Freezer 2");
    }

    @FXML
    public void submitButton(ActionEvent actionEvent) {
        String productName = productNameTF.getText();
        String batchNumber = batchNumberTF.getText();
        String receivedQuantity = receivedQuantityTF.getText();
        LocalDate deliveryDate = deliveryDateDP.getValue();
        LocalDate expiryDate = expiryDateDP.getValue();
        String storageLocation = storageLocationCB.getValue();


        if (productName.isEmpty() || batchNumber.isEmpty() || receivedQuantity.isEmpty() || deliveryDate == null || expiryDate == null || storageLocation == null) {
            errorMessageLabel.setText("Please fill out all fields correctly.");
            return;
        }

        if (!isNumeric(receivedQuantity)) {
            errorMessageLabel.setText("Please enter a valid number for quantity.");
            return;
        }

        int quantity = Integer.parseInt(receivedQuantity);


        System.out.println("Stock updated: " + productName + ", Batch: " + batchNumber + ", Quantity: " + quantity + ", Delivery Date: " + deliveryDate + ", Expiry Date: " + expiryDate + ", Storage: " + storageLocation);

        showAlert(Alert.AlertType.INFORMATION, "Stock Updated", "Stock has been updated successfully.");
        clearForm();
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

    private void clearForm() {
        productNameTF.clear();
        batchNumberTF.clear();
        receivedQuantityTF.clear();
        deliveryDateDP.setValue(null);
        expiryDateDP.setValue(null);
        storageLocationCB.setValue(null);
        errorMessageLabel.setText("");
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}

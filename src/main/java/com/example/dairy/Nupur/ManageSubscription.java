package com.example.dairy.Nupur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageSubscription {

    @FXML
    private TextField contactInfoTF;
    @FXML
    private ComboBox<String> selectProductCB;
    @FXML
    private ComboBox<String> subscriptionFrequencyCB;
    @FXML
    private TextField customerNameTF;

    @FXML
    public void initialize() {
        selectProductCB.getItems().addAll("Milk", "Butter", "Cheese", "Yogurt", "Cream", "Ghee", "Paneer", "IceCream");
        subscriptionFrequencyCB.getItems().addAll("Daily", "Weekly", "Monthly");

        //selectProductCB.setValue("Milk");
        //subscriptionFrequencyCB.setValue("Daily");
    }

    @FXML
    public void backButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("customer representative dashboard.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            // Handle FXML loading error
            e.printStackTrace();
    }
    }

    @FXML
    public void confirmButton(ActionEvent actionEvent) {
        String customerName = customerNameTF.getText();
        String contactInfo = contactInfoTF.getText();
        String selectedProduct = selectProductCB.getValue();
        String subscriptionFrequency = subscriptionFrequencyCB.getValue();

        if (customerName.isEmpty() || contactInfo.isEmpty() || selectedProduct == null || subscriptionFrequency == null) {
            showAlert(Alert.AlertType.WARNING, "Input Error", "Please fill out all fields correctly.");
            return;
        }


        showAlert(Alert.AlertType.INFORMATION, "Subscription Confirmed", "Subscription for " + customerName + " has been confirmed.");
        clearForm();
    }

    private void clearForm() {
        customerNameTF.clear();
        contactInfoTF.clear();
        selectProductCB.setValue("Milk");
        subscriptionFrequencyCB.setValue("Daily");
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

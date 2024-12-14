package com.example.dairy.Nupur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerComplaints {

    @FXML
    private TextField customernameTF;
    @FXML
    private TextField customeridTF;
    @FXML
    private ComboBox<String> statusCB;
    @FXML
    private TextArea complaintsTA;
    @FXML
    private Label errormsg;

    @FXML
    public void initialize() {
        // Populate the ComboBox with complaint statuses
        statusCB.getItems().addAll("Pending", "In Progress", "Resolved");
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
    public void logComplaintButton(ActionEvent actionEvent) {
        String customerId = customeridTF.getText();
        String customerName = customernameTF.getText();
        String complaint = complaintsTA.getText();
        String status = statusCB.getValue();

        // Validate inputs
        if (customerId.isEmpty() || customerName.isEmpty() || complaint.isEmpty() || status == null) {
            showAlert(Alert.AlertType.WARNING, "Input Error", "Please fill out all fields correctly.");
            return;
        }

        // Validate customer ID (must be an integer)
        if (!isInteger(customerId)) {
            errormsg.setText("Customer ID must be an integer.");
            return;
        }

        // Logic to log the complaint
        // This is a placeholder and should be implemented as needed
        System.out.println("Complaint Logged: " + complaint);

        showAlert(Alert.AlertType.INFORMATION, "Complaint Logged", "The complaint has been logged successfully.");
        clearForm();
    }

    private void clearForm() {
        customeridTF.clear();
        customernameTF.clear();
        complaintsTA.clear();
        statusCB.setValue(null);
        errormsg.setText("");
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

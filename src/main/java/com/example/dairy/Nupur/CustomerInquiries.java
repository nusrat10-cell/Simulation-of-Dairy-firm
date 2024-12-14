package com.example.dairy.Nupur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerInquiries {

    @FXML
    private TextArea responseTA;
    @FXML
    private TextArea inquiryTA;
    @FXML
    private TextField customernameTF;
    @FXML
    private TextField customeridTF;
    @FXML
    private Label statuslabel;

    @FXML
    public void initialize() {
    }

    @FXML
    public void sendResponseButton(ActionEvent actionEvent) {
        String customerId = customeridTF.getText();
        String customerName = customernameTF.getText();
        String inquiry = inquiryTA.getText();
        String response = responseTA.getText();

        if (!isInteger(customerId)) {
            statuslabel.setText("Customer ID must be an integer.");
            return;
        }


        if (customerId.isEmpty() || customerName.isEmpty() || inquiry.isEmpty() || response.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Input Error", "Please fill out all fields correctly.");
            return;
        }


        System.out.println("Response Sent: " + response);

        showAlert(Alert.AlertType.INFORMATION, "Response Sent", "Your response has been sent successfully.");
        clearForm();
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

    private void clearForm() {
        customeridTF.clear();
        customernameTF.clear();
        inquiryTA.clear();
        responseTA.clear();
        statuslabel.setText("");
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private boolean isInteger(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

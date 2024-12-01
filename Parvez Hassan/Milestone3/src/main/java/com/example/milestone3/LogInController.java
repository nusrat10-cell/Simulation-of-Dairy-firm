package com.example.milestone3;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventObject;

public class LogInController {
    @javafx.fxml.FXML
    private TextField userID_textField;
    @javafx.fxml.FXML
    private ComboBox<String> designation_ComboBox;
    @javafx.fxml.FXML
    private PasswordField pass_textField;

    @javafx.fxml.FXML
    public void initialize() {
        designation_ComboBox.getItems().addAll("Milk Collector", "Milk Processor", "Inventory Manager", "Customer Service Representative", "Supply Chain & Logistics", "Financial Manager", "Sales & Marketing Manager", "Customer");
    }
    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Login Error");
        alert.setContentText(message);
        alert.showAndWait();
    }


    @javafx.fxml.FXML
    public void logIn_button(ActionEvent actionEvent) {
        try {
            String password = pass_textField.getText();
            int userID = Integer.parseInt(userID_textField.getText());
            String designation = designation_ComboBox.getSelectionModel().getSelectedItem();
            boolean verified = false;
//        VERIFICATION
            if (userID == 1234 && password.equals("1234") && designation.equals("Supply Chain & Logistics")){
                // Load Page 2
                Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
                verified =true;
            } if ((userID== 1234 && password.equals("12345") && designation.equals("Financial Manager"))) {
                // Load Page 2
                Parent root = FXMLLoader.load(getClass().getResource("Dashboard2.fxml"));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
                verified =true;

            }if (!verified) {
                // Show error message
                showError("Invalid credentials. Please try again.");
            }
        } catch (NumberFormatException e) {
            // Handle invalid integer input
            showError("User ID must be a number.");
        } catch (IOException e) {
            // Handle FXML loading error
            e.printStackTrace();
            showError("Unable to load the next page.");
        }
    }


}


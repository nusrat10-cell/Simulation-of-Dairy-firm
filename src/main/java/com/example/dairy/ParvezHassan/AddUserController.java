package com.example.dairy.ParvezHassan;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;
import java.util.Arrays;

public class AddUserController {
    @javafx.fxml.FXML
    private PasswordField confirmPass_PF;
    @javafx.fxml.FXML
    private TextField inputName_TF;
    @javafx.fxml.FXML
    private TextField inputEmail_TF;
    @javafx.fxml.FXML
    private PasswordField setPass_PF;
    @javafx.fxml.FXML
    private TextField inputNumber_TF;
    @javafx.fxml.FXML
    private ComboBox<String> inputDesignation_CB;
    @javafx.fxml.FXML
    private TextField inputID_TF;

    @javafx.fxml.FXML
    public void initialize() {
        inputDesignation_CB.getItems().addAll(
                "Milk Collector", "Milk Processor", "Inventory Manager",
                "Customer Service Representative", "Supply Chain & Logistics",
                "Financial Manager", "Sales & Marketing Manager", "Customer"
        );
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        String name = inputName_TF.getText();
        String idText = inputID_TF.getText();
        String email = inputEmail_TF.getText();
        String number = inputNumber_TF.getText();
        String setPassword = setPass_PF.getText();
        String confirmPassword = confirmPass_PF.getText();
        String designation = inputDesignation_CB.getValue();

        // validation
        if (name.isEmpty() || idText.isEmpty() || email.isEmpty() || number.isEmpty() || setPassword.isEmpty() || confirmPassword.isEmpty() || designation == null) {
            showError("All fields must be filled out.");
            return;
        }
        int ID;
        try {
            ID = Integer.parseInt(idText);
        } catch (NumberFormatException e) {
            showError("ID must be a valid number.");
            return;
        }

        if (!setPassword.equals(confirmPassword)) {
            showError("Passwords do not match.");
            return;
        }

        User.addUser(Arrays.asList(
                new User(ID,name,email,number,designation,confirmPassword)
        ));

        showConfirmation("User has been added successfully!");
        clearFields();
    }

    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showConfirmation(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Success");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        inputName_TF.clear();
        inputID_TF.clear();
        inputEmail_TF.clear();
        inputNumber_TF.clear();
        setPass_PF.clear();
        confirmPass_PF.clear();
        inputDesignation_CB.getSelectionModel().clearSelection();
    }
}

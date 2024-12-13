package com.example.dairy.Nupur;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NewProduct
{
    @javafx.fxml.FXML
    private TextField productNameTF;
    @javafx.fxml.FXML
    private TextArea productDescriptionTA;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        String NewProductName = productNameTF.getText();
        String ProductDescription = productDescriptionTA.getText();


        if (NewProductName.isEmpty() || ProductDescription.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Input Error", "Please fill out all fields correctly.");
            return;
        }

        System.out.println("New Product Added: " + NewProductName + " - " + ProductDescription);

        showAlert(Alert.AlertType.INFORMATION, "New Product Added", "Your New Product has been submitted successfully.");
        clearForm();
    }


    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("promote new products.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
    private void clearForm() {
        productNameTF.clear();
        productDescriptionTA.clear();
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
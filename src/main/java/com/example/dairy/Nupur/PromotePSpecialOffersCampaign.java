package com.example.dairy.Nupur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PromotePSpecialOffersCampaign {

    @FXML
    private TextField offerTF;
    @FXML
    private TextArea validOfferTA;

    @FXML
    public void initialize() {
    }

    @FXML
    public void submitOfferButton(ActionEvent actionEvent) {
        String offerTitle = offerTF.getText();
        String offerDetails = validOfferTA.getText();


        if (offerTitle.isEmpty() || offerDetails.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Input Error", "Please fill out all fields correctly.");
            return;
        }

        System.out.println("Offer Submitted: " + offerTitle + " - " + offerDetails);

        showAlert(Alert.AlertType.INFORMATION, "Offer Submitted", "Your special offer has been submitted successfully.");
        clearForm();
    }

    @FXML
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
        offerTF.clear();
        validOfferTA.clear();
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

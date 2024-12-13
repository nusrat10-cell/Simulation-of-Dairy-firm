package com.example.dairy.Nupur;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TrackOrder {

    @FXML
    private TextField orderIdTF;
    @FXML
    private ListView<String> orderListview;
    @FXML
    private Label statuslabel;

    private ObservableList<String> orderList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        orderListview.setItems(orderList);
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
    public void searchOrderButton(ActionEvent actionEvent) {
        String orderId = orderIdTF.getText();
        if (orderId.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Input Error", "Please enter an order ID.");
            return;
        }


        orderList.clear();
        orderList.addAll(
                "Order ID: 12345, Product: Milk, Status: Delivered",
                "Order ID: 22745, Product: Butter, Status: Pending",
                "Order ID: 24527, Product: Cheese, Status: Shipped"
        );

        statuslabel.setText("Details for Order ID: " + orderId);
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

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

public class ProcessProductReturn {

    @FXML
    private TableView<productReturnModelClass> productReturnTV;
    @FXML
    private TableColumn<productReturnModelClass, String> productNameTC;
    @FXML
    private TableColumn<productReturnModelClass, String> returnReasonTC;
    @FXML
    private TableColumn<productReturnModelClass, LocalDate> returndateTC;
    @FXML
    private TableColumn<productReturnModelClass, String> statusTC;
    @FXML
    private TableColumn<productReturnModelClass, Integer> quantityTC;
    @FXML
    private RadioButton rejectRB;
    @FXML
    private RadioButton approveRB;

    private ObservableList<productReturnModelClass> returnList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Initialize the TableView columns
        productNameTC.setCellValueFactory(new PropertyValueFactory<>("productName"));
        returnReasonTC.setCellValueFactory(new PropertyValueFactory<>("returnReason"));
        returndateTC.setCellValueFactory(new PropertyValueFactory<>("returndate"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));
        quantityTC.setCellValueFactory(new PropertyValueFactory<>("quantity"));


        returnList.addAll(
                new productReturnModelClass("Milk", "Pending", LocalDate.now(), 50, "Expired"),
                new productReturnModelClass("Cheese", "Pending", LocalDate.now(), 32, "Damaged"),
                new productReturnModelClass("Butter", "Pending", LocalDate.now(), 20, "Wrong item"),
                new productReturnModelClass("Yogurt", "Pending", LocalDate.now(), 55, "Expired"),
                new productReturnModelClass("Ghee", "Pending", LocalDate.now(), 70, "Expired"),
                new productReturnModelClass("Ice Cream", "Pending", LocalDate.now(), 80, "Damaged"),
                new productReturnModelClass("Paneer", "Pending", LocalDate.now(), 46, "Do not need"),
                new productReturnModelClass("Cream", "Pending", LocalDate.now(), 67, "Wrong Item")
                );

        productReturnTV.setItems(returnList);
    }

    @FXML
    public void submitButton(ActionEvent actionEvent) {
        productReturnModelClass selectedReturn = productReturnTV.getSelectionModel().getSelectedItem();
        if (selectedReturn == null) {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a return to process.");
            return;
        }

        if (!approveRB.isSelected() && !rejectRB.isSelected()) {
            showAlert(Alert.AlertType.WARNING, "No Action Selected", "Please select an action (approve or reject).");
            return;
        }

        if (approveRB.isSelected()) {
            selectedReturn.setStatus("Approved");
            updateInventory(selectedReturn, true);
        } else if (rejectRB.isSelected()) {
            selectedReturn.setStatus("Rejected");
            updateInventory(selectedReturn, false);
        }

        productReturnTV.refresh();
        showAlert(Alert.AlertType.INFORMATION, "Update Inventory", "Inventory has been updated successfully.");
    }

    private void updateInventory(productReturnModelClass productReturn, boolean approve) {
        if (approve) {
            System.out.println("Inventory updated with returned product: " + productReturn.getProductName());
        } else {
            System.out.println("Return rejected for product: " + productReturn.getProductName());
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
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
}

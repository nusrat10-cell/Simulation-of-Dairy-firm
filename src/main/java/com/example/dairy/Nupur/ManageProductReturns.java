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

public class ManageProductReturns {

    @FXML
    private TableView<productReturnModelClass> productReturnTV;
    @FXML
    private TableColumn<productReturnModelClass, String> productNameTC;
    @FXML
    private ComboBox<String> selectProductCB;
    @FXML
    private TableColumn<productReturnModelClass, String> returnReasonTC;
    @FXML
    private Label label;
    @FXML
    private TextArea returnreasonTA;
    @FXML
    private DatePicker returndateDP;
    @FXML
    private TableColumn<productReturnModelClass, LocalDate> returndateTC;
    @FXML
    private TableColumn<productReturnModelClass, String> statusTC;
    @FXML
    private TableColumn<productReturnModelClass, Integer> quantityTC;
    @FXML
    private TextField quantityTF;
    @FXML
    private Label label1;
    @FXML
    private Button processReturnButton;

    private ObservableList<productReturnModelClass> returnList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        productNameTC.setCellValueFactory(new PropertyValueFactory<>("productName"));
        returnReasonTC.setCellValueFactory(new PropertyValueFactory<>("returnReason"));
        returndateTC.setCellValueFactory(new PropertyValueFactory<>("returndate"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));
        quantityTC.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        selectProductCB.getItems().addAll("Milk", "Butter", "Cheese", "Yogurt", "Cream", "Ghee", "Paneer", "IceCream");

        productReturnTV.setItems(returnList);
    }

    @FXML
    public void processReturnButton(ActionEvent actionEvent) {
        String productName = selectProductCB.getValue();
        String returnReason = returnreasonTA.getText();
        int quantity;
        try {
            quantity = Integer.parseInt(quantityTF.getText());
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.WARNING, "Input Error", "Please enter a valid number for quantity.");
            return;
        }
        LocalDate returnDate = returndateDP.getValue();
        if (productName == null || productName.isEmpty() || returnReason.isEmpty() || returnDate == null || quantity <= 0) {
            showAlert(Alert.AlertType.WARNING, "Input Error", "Please fill out all fields correctly.");
            return;
        }

        productReturnModelClass newReturn = new productReturnModelClass(productName, "Pending", returnDate, quantity, returnReason);
        returnList.add(newReturn);

        clearReturnForm();
        showAlert(Alert.AlertType.INFORMATION, "Return Processed", "Product return has been processed successfully.");
    }

    private void clearReturnForm() {
        selectProductCB.setValue(null);
        returnreasonTA.clear();
        quantityTF.clear();
        returndateDP.setValue(null);
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    public void cancelButton(ActionEvent actionEvent) {
        clearReturnForm();
        showAlert(Alert.AlertType.INFORMATION, "Action Canceled", "Product return process has been canceled.");
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
}

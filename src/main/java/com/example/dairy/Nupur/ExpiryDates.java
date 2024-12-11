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
import java.time.temporal.ChronoUnit;
public class ExpiryDates {
    @javafx.fxml.FXML
    private TableColumn<expiryDateModelClass, String> productNameTC;
    @javafx.fxml.FXML
    private ComboBox<String> selectProductCB;
    @javafx.fxml.FXML
    private TableView<expiryDateModelClass> expiryDateTV;
    @javafx.fxml.FXML
    private TableColumn<expiryDateModelClass, Integer> currentStockTC;
    @javafx.fxml.FXML
    private TableColumn<expiryDateModelClass, LocalDate> expiryDateTC;
    @javafx.fxml.FXML
    private Label label;
    @javafx.fxml.FXML
    private ComboBox<String> chooseActionCB;
    private ObservableList<expiryDateModelClass> productList = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    public void initialize() {
        productNameTC.setCellValueFactory(new PropertyValueFactory<>("productName"));
        currentStockTC.setCellValueFactory(new PropertyValueFactory<>("currentStock"));
        expiryDateTC.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));
        productList.addAll(
                new expiryDateModelClass("Milk", 100, LocalDate.now().plusDays(5)),
                new expiryDateModelClass("Butter", 50, LocalDate.now().plusDays(10)),
                new expiryDateModelClass("Yogurt", 30, LocalDate.now().plusDays(3)),
                new expiryDateModelClass("Cheese", 60, LocalDate.now().plusDays(15)),
                new expiryDateModelClass("Cream", 40, LocalDate.now().plusDays(6)),
                new expiryDateModelClass("Ghee", 70, LocalDate.now().plusDays(17)),
                new expiryDateModelClass("Paneer", 65, LocalDate.now().plusDays(12)),
                new expiryDateModelClass("IceCream", 80, LocalDate.now().plusDays(20))
        );
        expiryDateTV.setItems(productList);
        selectProductCB.getItems().addAll("Milk", "Butter", "Cheese", "Yogurt", "Cream", "Ghee", "Paneer", "IceCream");
        chooseActionCB.getItems().addAll("Discount", "Discard");
    }
    @FXML
    public void confirmActionButton(ActionEvent actionEvent) {
        String selectedProductName = selectProductCB.getValue();
        String selectedAction = chooseActionCB.getValue();
        if (selectedProductName == null || selectedAction == null) {
            showAlert("Error", "Please select a product and an action.", Alert.AlertType.ERROR);
            return;
        }
        for (expiryDateModelClass product : productList) {
            if (product.getProductName().equals(selectedProductName)) {
                long daysToExpiry = ChronoUnit.DAYS.between(LocalDate.now(), product.getExpiryDate());
                if (daysToExpiry <= 7) { // If the product is nearing expiry
                    if (selectedAction.equals("Discount")) {
                        applyDiscount(product); // Pass the product object
                        label.setText("Discount applied to " + product.getProductName() + ". New stock: " + product.getCurrentStock());
                    } else if (selectedAction.equals("Discard")) {
                        applyDiscard(product); // Pass the product object
                        label.setText(product.getProductName() + " discarded. Stock is now zero.");
                    }
                    break;
                } else {
                    showAlert("Info", "The selected product is not nearing expiry.", Alert.AlertType.INFORMATION);
                    break;
                }
            }
        }
    }
    private void applyDiscount(expiryDateModelClass product) {
        int currentStock = product.getCurrentStock();
        int discountedStock = (int) (currentStock * 0.9); // Reduce stock by 10%
        product.setCurrentStock(discountedStock);
    }
    private void applyDiscard(expiryDateModelClass product) {
        product.setCurrentStock(0); // Set stock to zero
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
    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
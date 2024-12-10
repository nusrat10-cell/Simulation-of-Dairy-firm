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

public class ManageDispatchRequest {

    @FXML
    private DatePicker dispatchDateDP;
    @FXML
    private TableColumn<productDispatchmodelClass, String> productNameTC;
    @FXML
    private TableView<productDispatchmodelClass> dispatchTV;
    @FXML
    private TableColumn<productDispatchmodelClass, String> destinationTC;
    @FXML
    private TableColumn<productDispatchmodelClass, Integer> quantityTC;
    @FXML
    private ComboBox<String> logisticProviderCB;
    @FXML
    private TableColumn<productDispatchmodelClass, Integer> requestidTC;

    //private ObservableList<productDispatchmodelClass> productList;
    @FXML
    private ComboBox<String> selectproductsCB;
    @FXML
    private TextField destinationTF;
    @FXML
    private ComboBox<String> selectproductCB;

    @FXML
    private TextField quantityTF;

    private ObservableList<productDispatchmodelClass> productList = FXCollections.observableArrayList();


    @FXML
    public void initialize() {

        productNameTC.setCellValueFactory(new PropertyValueFactory<>("productName"));
        quantityTC.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        destinationTC.setCellValueFactory(new PropertyValueFactory<>("destination"));

        selectproductCB.getItems().addAll("Milk", "Butter", "Cheese", "Yogurt", "Cream", "Ghee", "Paneer", "IceCream");
        logisticProviderCB.getItems().addAll("Dairy Deliveries", "Fresh Freight", "Rapid Dispatch");
        selectproductsCB.getItems().addAll("Milk", "Butter", "Cheese", "Yogurt", "Cream", "Ghee", "Paneer", "IceCream");

        dispatchTV.setItems(productList);
    }

    @FXML
    public void processButton(ActionEvent actionEvent) {
        String productName = selectproductCB.getValue();
        int quantity = Integer.parseInt(quantityTF.getText());
        String destination = destinationTF.getText();

        if (productName == null || destination.isEmpty() || quantity <= 0) {
            // showAlert(Alert.AlertType.WARNING, "Input Error", "Please fill out all fields correctly.");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Input Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill out all fields correctly.");
            alert.showAndWait();
            return;
        }

        productDispatchmodelClass newProduct = new productDispatchmodelClass(productName, destination, quantity);
        productList.add(newProduct);

        //clearProductInputs();
        // Clear input fields

        selectproductCB.setValue(null);
        destinationTF.clear();
        quantityTF.clear();
    }


    @FXML
    public void dispatchButton(ActionEvent actionEvent) {
        String logisticProvider = logisticProviderCB.getValue();
        String dispatchDate = dispatchDateDP.getValue() != null ? dispatchDateDP.getValue().toString() : null;

        if (logisticProvider == null || dispatchDate == null) {
            //showAlert(Alert.AlertType.WARNING, "Input Error", "Please select a logistic provider and dispatch date.");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Input Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a logistic provider and dispatch date.");
            alert.showAndWait();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Dispatch");
        alert.setHeaderText(null);
        alert.setContentText("Product dispatched with " + logisticProvider + " on " + dispatchDate + ".");
        alert.showAndWait(); }

        //showAlert(Alert.AlertType.INFORMATION, "Dispatch", "Product dispatched with " + logisticProvider + " on " + dispatchDate + ".");



    @javafx.fxml.FXML
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
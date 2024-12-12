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

public class ProperStorage {

    @FXML
    private TableColumn<storageconditionClass, Double> temperatureTC;
    @FXML
    private ComboBox<String> selectProductCB;
    @FXML
    private ComboBox<String> takeActionCB;
    @FXML
    private TableView<storageconditionClass> properStorageTV;
    @FXML
    private TableColumn<storageconditionClass, String> statusTC;
    @FXML
    private Label label;
    @FXML
    private TableColumn<storageconditionClass, Double> humidityTC;
    @FXML
    private TableColumn<storageconditionClass, String> productnameTC;

    private ObservableList<storageconditionClass> storageList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        productnameTC.setCellValueFactory(new PropertyValueFactory<>("productName"));
        temperatureTC.setCellValueFactory(new PropertyValueFactory<>("temperature"));
        humidityTC.setCellValueFactory(new PropertyValueFactory<>("humidity"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));



        storageList.addAll(
                new storageconditionClass(4.5, "Milk", "Normal", 50),
                new storageconditionClass(7.0, "Butter", "Warning", 45),
                new storageconditionClass(3.2, "Cheese", "Normal", 55),
                new storageconditionClass(2.8, "Yogurt", "Critical", 70),
                new storageconditionClass(5.0, "Cream", "Normal", 52),
                new storageconditionClass(4.3, "Paneer", "Normal", 60),
                new storageconditionClass(6.5, "Ghee", "Warning", 65),
                new storageconditionClass(1.5, "Ice Cream", "Critical", 35)
        );

        properStorageTV.setItems(storageList);


        selectProductCB.getItems().addAll("Milk", "Butter", "Cheese", "Yogurt", "Cream", "Paneer", "Ghee", "Ice Cream");
        takeActionCB.getItems().addAll("Adjust Temperature", "Check Cooling System", "Notify Maintenance Team");

        selectProductCB.setOnAction(this::checkStorageConditions);
    }

    @FXML
    public void checkStorageConditions(ActionEvent event) {
        String selectedProduct = selectProductCB.getValue();
        if (selectedProduct != null) {
            storageconditionClass selectedCondition = storageList.stream()
                    .filter(condition -> condition.getProductName().equals(selectedProduct))
                    .findFirst()
                    .orElse(null);

            if (selectedCondition != null) {
                boolean temperatureWarning = selectedCondition.getTemperature() < 2 || selectedCondition.getTemperature() > 6;
                boolean humidityWarning = selectedCondition.getHumidity() < 40 || selectedCondition.getHumidity() > 60;

                if (temperatureWarning) {
                    label.setText("Storage Unit: Temperature exceeds the optimal range!");
                } else if (humidityWarning) {
                    label.setText("Storage Unit: Humidity exceeds the optimal range!");
                } else {
                    label.setText("Storage conditions are within the optimal range.");
                }
            }
        }
    }

    @FXML
    public void logActionButton(ActionEvent actionEvent) {
        String selectedAction = takeActionCB.getValue();
        if (selectedAction != null) {
            label.setText("Action logged: " + selectedAction);
            // Implement the logic to log the selected action
            // This is a placeholder and should be replaced with actual logic
            System.out.println("Action logged: " + selectedAction);
        } else {
            label.setText("Please select an action to log.");
        }
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

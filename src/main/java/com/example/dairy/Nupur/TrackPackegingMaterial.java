package com.example.dairy.Nupur;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class TrackPackegingMaterial {

    @javafx.fxml.FXML
    private TextField usedQuantityTF;
    @javafx.fxml.FXML
    private TableColumn<packagingmaterialModelClass, Integer> quantityUsedTC;
    @javafx.fxml.FXML
    private ComboBox<String> materialTypeCB;
    @javafx.fxml.FXML
    private TableColumn<packagingmaterialModelClass, String> materialNameTC;
    @javafx.fxml.FXML
    private TableView<packagingmaterialModelClass> packagingMaterialTV;
    @javafx.fxml.FXML
    private TableColumn<packagingmaterialModelClass, Integer> remainningQuantityTC;
    @javafx.fxml.FXML
    private TextField stockQuantityTF;

    private ObservableList<packagingmaterialModelClass> materialData= FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private Label validationLabel;

    @javafx.fxml.FXML
    public void initialize() {
        materialNameTC.setCellValueFactory(new PropertyValueFactory<>("productName"));
        quantityUsedTC.setCellValueFactory(new PropertyValueFactory<>("quantityUsed"));
        remainningQuantityTC.setCellValueFactory(new PropertyValueFactory<>("remainingStock"));

        //materialData = FXCollections.observableArrayList();
        packagingMaterialTV.setItems(materialData);

        materialTypeCB.getItems().addAll( "plastic bottles" , "Cartoons", "Plastic wrapper");
    }

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        String selectedMaterial = materialTypeCB.getValue();
        String stockQuantityText = stockQuantityTF.getText();
        String usedQuantityText = usedQuantityTF.getText();

        validationLabel.setText("");

        if (selectedMaterial == null || stockQuantityText.isEmpty() || usedQuantityText.isEmpty()) {
            validationLabel.setText("Please fill all fields!");
            return;
        }

        if (!stockQuantityText.matches("\\d+") || !usedQuantityText.matches("\\d+")) {
            System.out.println("Please enter valid positive numbers for quantities.");
            return;
        }

        int stockQuantity = Integer.parseInt(stockQuantityText);
        int usedQuantity = Integer.parseInt(usedQuantityText);


        if (usedQuantity > stockQuantity) {
            System.out.println("Used quantity cannot exceed stock quantity.");
            return;
        }

        int remainingQuantity = stockQuantity - usedQuantity;


        materialData.add(new packagingmaterialModelClass(selectedMaterial, remainingQuantity, usedQuantity));
        packagingMaterialTV.setItems(materialData);


        stockQuantityTF.clear();
        usedQuantityTF.clear();
        materialTypeCB.setValue(null);
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Inventory Manager Dashboard.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            // Handle FXML loading error
            e.printStackTrace();
        }}

}

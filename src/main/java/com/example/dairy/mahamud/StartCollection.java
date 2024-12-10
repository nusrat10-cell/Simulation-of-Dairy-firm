package com.example.dairy.mahamud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.awt.event.ActionEvent;
import java.io.IOException;
import java.time.LocalDate;

public class StartCollection {
    @FXML
    private DatePicker datefx;
    @FXML
    private TextField farmernamefx;
    @FXML
    private TextField quantityfx;

    private ObservableList<CollectionData> collectionData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
    }

    @FXML
    public void confirmcollectionbuttonfx(ActionEvent actionEvent) {
        String farmerName = farmernamefx.getText();
        String quantityStr = quantityfx.getText();
        LocalDate date = datefx.getValue();

        if (farmerName.isEmpty() || quantityStr.isEmpty() || date == null) {

            System.out.println("Please fill in all fields.");
            return;
        }

        try  {
            double quantity = Double.parseDouble(quantityStr);

            CollectionData data = new CollectionData(farmerName, quantity, date);
            collectionData.add(data);

            for (CollectionData entry : collectionData) {
                System.out.println(entry);
            }


            farmernamefx.clear();
            quantityfx.clear();
            datefx.setValue(null);

        } catch (NumberFormatException e) {

            System.out.println("Please enter a valid quantity.");
        }
    }

    @FXML
    public void backbuttonfx(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Milk Collector.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {

            e.printStackTrace();
        }
        // Handle back button action
        System.out.println("Back button clicked.");
    }
}

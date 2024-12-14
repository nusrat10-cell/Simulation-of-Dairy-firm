package com.example.dairy.mahamud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class StartCollectionController {
    @FXML
    private DatePicker datefx;
    @FXML
    private TextField farmernamefx;
    @FXML
    private TextField quantityfx;

    @FXML
    private TableView<CollectionData> tablefx;
    @FXML
    private TableColumn<CollectionData, String> collumnamefx;
    @FXML
    private TableColumn<CollectionData, LocalDate> datecollumfx;
    @FXML
    private TableColumn<CollectionData, Double> quanticollumtyfx;

    private ObservableList<CollectionData> collectionDataList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        collumnamefx.setCellValueFactory(new PropertyValueFactory<>("farmerName"));
        datecollumfx.setCellValueFactory(new PropertyValueFactory<>("date"));
        quanticollumtyfx.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tablefx.setItems(collectionDataList);
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

        try {
            double quantity = Double.parseDouble(quantityStr);

            CollectionData data = new CollectionData(farmerName, quantity, date);
            collectionDataList.add(data);
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
            // Handle FXML loading error
            e.printStackTrace();
        }
    }}

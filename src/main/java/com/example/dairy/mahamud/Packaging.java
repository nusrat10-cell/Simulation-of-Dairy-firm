package com.example.dairy.mahamud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Packaging {

    @FXML
    private ComboBox<String> pProductTypecomboxfx;
    @FXML
    private TextField pquantityfx;
    @FXML
    private DatePicker datefx;

    @FXML
    private TableColumn<PackagingModelClass, String> ptypecollumfx;
    @FXML
    private TableColumn<PackagingModelClass, Integer> pquantitycollumfx;
    @FXML
    private TableColumn<PackagingModelClass, LocalDateTime> ptimecollumfx;
    @FXML
    private TableView<PackagingModelClass> packagingTable;

    private ObservableList<PackagingModelClass> packagingModelClassList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Initialize ComboBox with product types
        pProductTypecomboxfx.getItems().setAll("Whole Milk", "Skimmed Milk", "Butter", "Cream");

        // Initialize Table Columns
        ptypecollumfx.setCellValueFactory(new PropertyValueFactory<>("productType"));
        pquantitycollumfx.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        ptimecollumfx.setCellValueFactory(new PropertyValueFactory<>("timeRemaining"));

        // Set table data
        packagingTable.setItems(packagingModelClassList);
    }

    @FXML
    public void finishPackagingbuttonfx(ActionEvent actionEvent) {
        String productType = pProductTypecomboxfx.getValue();
        String quantityStr = pquantityfx.getText();
        LocalDate date = datefx.getValue();

        if (productType == null || quantityStr.isEmpty() || date == null) {
            System.out.println("Please fill in all fields.");
            return;
        }

        try {
            int quantity = Integer.parseInt(quantityStr);
            LocalDateTime timeRemaining = LocalDateTime.of(date, LocalTime.now());

            PackagingModelClass data = new PackagingModelClass(productType, quantity, timeRemaining);
            packagingModelClassList.add(data);

            // Clear the fields after submission
            pProductTypecomboxfx.setValue(null);
            pquantityfx.clear();
            datefx.setValue(null);

            packagingTable.refresh();

        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numeric values for quantity.");
        }
    }

    @FXML
    public void pbackbuttonfx(ActionEvent actionEvent) {
        // Handle back button action
        System.out.println("Back button clicked.");
    }
}

package com.example.dairy.mahamud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class PaymentManagement {
    @FXML
    private TableColumn<PaymentData, LocalDate> pmdatecollumfx;
    @FXML
    private DatePicker pmdatefx;
    @FXML
    private TableColumn<PaymentData, String> pmnamecollumfx;
    @FXML
    private TableView<PaymentData> pmtablefx;
    @FXML
    private TableColumn<PaymentData, Double> pmamountcollumfx;
    @FXML
    private TextField pmamounttextfieldfx;
    @FXML
    private TextField pmnametextfieldfx;

    private ObservableList<PaymentData> paymentDataList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Initialize Table Columns
        pmnamecollumfx.setCellValueFactory(new PropertyValueFactory<>("name"));
        pmamountcollumfx.setCellValueFactory(new PropertyValueFactory<>("amount"));
        pmdatecollumfx.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Set table data
        pmtablefx.setItems(paymentDataList);
    }

    @FXML
    public void pmsavepaymentbuttonfx(ActionEvent actionEvent) {
        String name = pmnametextfieldfx.getText();
        String amountStr = pmamounttextfieldfx.getText();
        LocalDate date = pmdatefx.getValue();

        if (name.isEmpty() || amountStr.isEmpty() || date == null) {
            System.out.println("Please fill in all fields.");
            return;
        }

        try {
            double amount = Double.parseDouble(amountStr);

            PaymentData data = new PaymentData(name, amount, date);
            paymentDataList.add(data);

            // Clear the fields after submission
            pmnametextfieldfx.clear();
            pmamounttextfieldfx.clear();
            pmdatefx.setValue(null);

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid amount.");
        }
    }

    @FXML
    public void pmbckbutton(ActionEvent actionEvent) {
        // Handle back button action
        System.out.println("Back button clicked.");
    }

    @FXML
    public void pmclearpaymentbuttonfx(ActionEvent actionEvent) {
        paymentDataList.clear();
        System.out.println("Table cleared.");
    }
}

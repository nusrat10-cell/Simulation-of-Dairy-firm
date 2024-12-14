package com.example.dairy.mahamud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
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
        pProductTypecomboxfx.getItems().setAll("Whole Milk", "Skimmed Milk", "Butter", "Cream");
        ptypecollumfx.setCellValueFactory(new PropertyValueFactory<>("productType"));
        pquantitycollumfx.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        ptimecollumfx.setCellValueFactory(new PropertyValueFactory<>("timeRemaining"));
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
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Milk Processor.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

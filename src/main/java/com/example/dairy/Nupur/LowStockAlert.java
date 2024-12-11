package com.example.dairy.Nupur;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class LowStockAlert
{
    @javafx.fxml.FXML
    private TableView lowStockAlertTV;
    @javafx.fxml.FXML
    private TableColumn<expiryDateModelClass,String> productNameTC;
    @javafx.fxml.FXML
    private ComboBox<String> selectProductCB;
    @javafx.fxml.FXML
    private ComboBox<String> chooseOptionCB;
    @javafx.fxml.FXML
    private TableColumn<expiryDateModelClass,Integer> currentStockTC;
    @javafx.fxml.FXML
    private TableColumn<expiryDateModelClass,Integer> minimumStockTC;
    @javafx.fxml.FXML
    private Label label;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void takeActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void confirmButton(ActionEvent actionEvent) {
    }
}
package com.example.dairy.Nupur;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class ManageInventoryLevel
{
    @javafx.fxml.FXML
    private TableView inventoryTV;
    @javafx.fxml.FXML
    private TableColumn<inventoryModelClass,Integer> stockLevelTC;
    @javafx.fxml.FXML
    private TableColumn<inventoryModelClass,String> productNameTC;
    @javafx.fxml.FXML
    private ComboBox<String> selectProductCB;
    @javafx.fxml.FXML
    private TableColumn<inventoryModelClass,Integer> minimumStockTC;
    @javafx.fxml.FXML
    private TableColumn<inventoryModelClass, LocalDate> expiryDateTC;
    @javafx.fxml.FXML
    private Label label;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void restockButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
    }
}
package com.example.Nupur;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ProperStorage
{
    @javafx.fxml.FXML
    private TableColumn<storageconditionClass, Double> temperatureTC;
    @javafx.fxml.FXML
    private ComboBox<String> selectProductCB;
    @javafx.fxml.FXML
    private ComboBox<String> takeActionCB;
    @javafx.fxml.FXML
    private TableView properStorageTV;
    @javafx.fxml.FXML
    private TableColumn<storageconditionClass,String> statusTC;
    @javafx.fxml.FXML
    private Label label;
    @javafx.fxml.FXML
    private TableColumn<storageconditionClass,Double> humidityTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void logActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
    }
}
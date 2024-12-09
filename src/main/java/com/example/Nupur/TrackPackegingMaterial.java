package com.example.Nupur;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TrackPackegingMaterial
{
    @javafx.fxml.FXML
    private TextField usedQuantityTF;
    @javafx.fxml.FXML
    private TableColumn<packagingmaterialModelClass,Integer> quantityUsedTC;
    @javafx.fxml.FXML
    private ComboBox<String> materialTypeCB;
    @javafx.fxml.FXML
    private TableColumn<packagingmaterialModelClass,String> materialNameTC;
    @javafx.fxml.FXML
    private TableView packagingMaterialTV;
    @javafx.fxml.FXML
    private TableColumn<packagingmaterialModelClass,Integer> remainningQuantityTC;
    @javafx.fxml.FXML
    private TextField stockQuantityTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
    }
}
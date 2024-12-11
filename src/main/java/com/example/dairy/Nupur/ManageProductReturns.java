package com.example.dairy.Nupur;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ManageProductReturns
{
    @javafx.fxml.FXML
    private TableView productReturnTV;
    @javafx.fxml.FXML
    private TableColumn<productReturnModelClass,String> productNameTC;
    @javafx.fxml.FXML
    private ComboBox<String> selectProductCB;
    @javafx.fxml.FXML
    private TableColumn<productReturnModelClass,String> returnReasonTC;
    @javafx.fxml.FXML
    private TableColumn<productReturnModelClass,Integer> productIdTC;
    @javafx.fxml.FXML
    private Label label;
    @javafx.fxml.FXML
    private ComboBox<String> chooseActionTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void confirmActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
    }
}
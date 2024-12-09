package com.example.Nupur;

import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ProcessProductReturn
{
    @javafx.fxml.FXML
    private TableView productReturnTV;
    @javafx.fxml.FXML
    private TableColumn<productReturnModelClass,String> productNameTC;
    @javafx.fxml.FXML
    private RadioButton rejectRB;
    @javafx.fxml.FXML
    private TableColumn<productReturnModelClass,Integer> returnidTC;
    @javafx.fxml.FXML
    private TableColumn<productReturnModelClass,String> returnReasonTC;
    @javafx.fxml.FXML
    private RadioButton approveRB;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void updateInventoryButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
    }
}
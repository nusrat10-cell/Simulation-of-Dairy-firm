package com.example.dairy.mahamud;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class MilkCollector
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void mcFreshmilkbuttonfx(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void mcstartcollectionbuttonfx(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Start_Collection.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void mcRouteOptimizationbuttonfx(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void mcReportIssuesnbuttonfx(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void mcMilkQuantitybuttonfx(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void mcMilkQualityTestbuttonfx(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void mcSupplierManagementbuttonfx(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void mcPaymentManagementbuttonfx(ActionEvent actionEvent) {
    }
}
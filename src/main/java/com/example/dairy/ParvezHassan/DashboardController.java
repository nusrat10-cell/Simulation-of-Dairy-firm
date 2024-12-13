package com.example.dairy.ParvezHassan;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController
{


    @javafx.fxml.FXML
    public void inventory_Button(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("InventoryManagement.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            // Handle FXML loading error
            e.printStackTrace();
        }
    }


        @javafx.fxml.FXML
        public void deliveryTrack_Button (ActionEvent actionEvent){
        }

        @javafx.fxml.FXML
        public void coldChain_Button (ActionEvent actionEvent){
        }

        @Deprecated
        public void costAnalysis_Button (ActionEvent actionEvent){
        }

        @javafx.fxml.FXML
        public void logOut_Button (ActionEvent actionEvent){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                // Handle FXML loading error
                e.printStackTrace();
        }}



        @javafx.fxml.FXML
        public void order_Button (ActionEvent actionEvent){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("OrderManagement.fxml"));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                // Handle FXML loading error
                e.printStackTrace();
            }
        }


        @javafx.fxml.FXML
        public void route_Button (ActionEvent actionEvent){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("AddOrder.fxml"));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                // Handle FXML loading error
                e.printStackTrace();
            }
        }

        @javafx.fxml.FXML
        public void initialize () {
        }

    @javafx.fxml.FXML
    public void updatePrice_Button(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("UpdatePrice.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            // Handle FXML loading error
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void orderToSupplier_Button(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("PlacedOrder.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            // Handle FXML loading error
            e.printStackTrace();
        }
    }
}
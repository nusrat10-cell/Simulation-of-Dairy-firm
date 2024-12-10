package com.example.dairy.Samiul.User7;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class IncomeManagement
{
    SalesAndMarketingManager user;
    @javafx.fxml.FXML
    private Label totalSalesLabel;
    @javafx.fxml.FXML
    private Label campaignCostLabel;
    @javafx.fxml.FXML
    private Label profitLabel;

    public void setter (SalesAndMarketingManager manager){
        this.user = manager;
    }
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com.example.dairy/Samiul/User7/sales and marketing manager dashboard.fxml"));
        root = fxmlLoader.load() ;

        SalesDashboard adc = fxmlLoader.getController() ;
        adc.setter(this.user);

        Scene scene = new Scene(root) ;
        Stage stage = (Stage)(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }
}
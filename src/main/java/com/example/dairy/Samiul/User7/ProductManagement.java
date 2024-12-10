package com.example.dairy.Samiul.User7;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ProductManagement
{
    SalesAndMarketingManager user;
    @javafx.fxml.FXML
    private Label showPriceLabel;
    @javafx.fxml.FXML
    private ComboBox productSelectCombobox;
    @javafx.fxml.FXML
    private TextField updateUpcomingStockTF;
    @javafx.fxml.FXML
    private Label upcomingStockLabel;
    @javafx.fxml.FXML
    private TextField updateRemainingStockTF;
    @javafx.fxml.FXML
    private TextField updatePriceTF;
    @javafx.fxml.FXML
    private Label remainingStockLabel;

    public void setter (SalesAndMarketingManager manager){
        this.user = manager;
    }
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void updateRemainingStockButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updatePriceButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateUpcomingStockButton(ActionEvent actionEvent) {
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
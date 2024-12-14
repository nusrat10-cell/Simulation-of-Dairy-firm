package com.example.dairy.Samiul.User7;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.Objects;

public class ProductManagement
{
    SalesAndMarketingManager user;
    @javafx.fxml.FXML
    private Label showPriceLabel;
    @javafx.fxml.FXML
    private ComboBox<String> productSelectCombobox;
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

    ObservableList<ProductClass> products = FXCollections.observableArrayList();

    public void setter (SalesAndMarketingManager manager){
        this.user = manager;
    }
    @javafx.fxml.FXML
    public void initialize() {
        productSelectCombobox.getItems().addAll("Milk", "Cheese", "Yogurt", "Butter", "Cream");
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/dairy/Samiul/User7/salesAndMarketingManagerDashboard.fxml"));
        root = fxmlLoader.load() ;

        SalesDashboard adc = fxmlLoader.getController() ;
        adc.setter(this.user);

        Scene scene = new Scene(root) ;
        Stage stage = (Stage)(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void selectProductOnAction(ActionEvent actionEvent) {
        for(ProductClass p: products) {
            if (Objects.equals(p.getName(), productSelectCombobox.getValue())) {
                showPriceLabel.setText(Integer.toString(p.getPrice()));
                remainingStockLabel.setText(Integer.toString(p.getRemainingStock()));
                upcomingStockLabel.setText(Integer.toString(p.getUpcomingStock()));
                break;
            }

        }


    }
}
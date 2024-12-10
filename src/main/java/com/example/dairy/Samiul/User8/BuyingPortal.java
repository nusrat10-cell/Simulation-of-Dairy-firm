package com.example.dairy.Samiul.User8;

import com.example.dairy.Samiul.User7.SalesDashboard;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class BuyingPortal
{
    Customer user;
    @javafx.fxml.FXML
    private DatePicker deliveryDatePicker;
    @javafx.fxml.FXML
    private ComboBox selectProductCombobox;
    @javafx.fxml.FXML
    private TextField quantityTF;
    @javafx.fxml.FXML
    private Label priceLabel;
    @javafx.fxml.FXML
    private Label nameLabel;

    public void setter (Customer customer){
        this.user = customer;
    }
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void orderNowButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com.example.dairy/Samiul/User8/customer dashboard.fxml"));
        root = fxmlLoader.load() ;

        CustomerDashboard adc = fxmlLoader.getController() ;
        adc.setter(this.user);

        Scene scene = new Scene(root) ;
        Stage stage = (Stage)(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }
}
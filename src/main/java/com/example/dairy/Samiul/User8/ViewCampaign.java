package com.example.dairy.Samiul.User8;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewCampaign
{
    Customer user;
    @javafx.fxml.FXML
    private TableColumn statusTableview;
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private TableColumn dateTableview;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private TableColumn nameTableview;
    @javafx.fxml.FXML
    private TableView viewCampaignTable;
    @javafx.fxml.FXML
    private TableColumn venueTableview;

    public void setter (Customer customer){
        this.user = customer;
    }
    @javafx.fxml.FXML
    public void initialize() {
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

    @javafx.fxml.FXML
    public void filterButton(ActionEvent actionEvent) {
    }
}
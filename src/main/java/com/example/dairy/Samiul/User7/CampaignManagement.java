package com.example.dairy.Samiul.User7;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CampaignManagement
{
    SalesAndMarketingManager user;
    @javafx.fxml.FXML
    private TableColumn idTableview;
    @javafx.fxml.FXML
    private TableColumn statusTableview;
    @javafx.fxml.FXML
    private TextField venueLocationTF;
    @javafx.fxml.FXML
    private TextField campaignNameTF;
    @javafx.fxml.FXML
    private TextField budgetAllocatedTF;
    @javafx.fxml.FXML
    private TableColumn dateTableview;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private DatePicker ednDatePicker;
    @javafx.fxml.FXML
    private TableColumn nameTableview;
    @javafx.fxml.FXML
    private TableColumn budgetTableview;
    @javafx.fxml.FXML
    private TableColumn venueTableview;
    @javafx.fxml.FXML
    private TableView campaignTable;

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

    @javafx.fxml.FXML
    public void createCampaignButton(ActionEvent actionEvent) {
    }
}
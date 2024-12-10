package com.example.dairy.Samiul.User7;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderList
{
    SalesAndMarketingManager user;
    @javafx.fxml.FXML
    private TableColumn customerNameTableview;
    @javafx.fxml.FXML
    private TableColumn customerIdTableview;
    @javafx.fxml.FXML
    private TableColumn numberTableview;
    @javafx.fxml.FXML
    private TableColumn productNameTableview;
    @javafx.fxml.FXML
    private TableColumn dateTableview;
    @javafx.fxml.FXML
    private TableColumn quantityTableview;
    @javafx.fxml.FXML
    private TableView orderListTable;

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
package com.example.dairy.Samiul.User7;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SalesDashboard
{
    SalesAndMarketingManager user;
    public void setter (SalesAndMarketingManager manager){
        this.user = manager;
    }
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void inhouseOrder(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com.example.dairy/Samiul/User7/InhouseOrder.fxml"));
        root = fxmlLoader.load() ;

        InhouseOrder adc = fxmlLoader.getController() ;
        adc.setter(this.user);

        Scene scene = new Scene(root) ;
        Stage stage = (Stage)(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void salesReport(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com.example.dairy/Samiul/User7/AnalyzeSalesPerformance.fxml"));
        root = fxmlLoader.load() ;

        AnalyzeSalesPerformance adc = fxmlLoader.getController() ;
        adc.setter(this.user);

        Scene scene = new Scene(root) ;
        Stage stage = (Stage)(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void createNewCampaign(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com.example.dairy/Samiul/User7/Campaign management.fxml"));
        root = fxmlLoader.load() ;

        CampaignManagement adc = fxmlLoader.getController() ;
        adc.setter(this.user);

        Scene scene = new Scene(root) ;
        Stage stage = (Stage)(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void productInventory(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com.example.dairy/Samiul/User7/ProductManagement.fxml"));
        root = fxmlLoader.load() ;

        ProductManagement adc = fxmlLoader.getController() ;
        adc.setter(this.user);

        Scene scene = new Scene(root) ;
        Stage stage = (Stage)(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void orderList(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com.example.dairy/Samiul/User7/Order list.fxml"));
        root = fxmlLoader.load() ;

        OrderList adc = fxmlLoader.getController() ;
        adc.setter(this.user);

        Scene scene = new Scene(root) ;
        Stage stage = (Stage)(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void reportProblemSales(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com.example.dairy/Samiul/User7/ReportProblem.fxml"));
        root = fxmlLoader.load() ;

        ReportProblem adc = fxmlLoader.getController() ;
        adc.setter(this.user);

        Scene scene = new Scene(root) ;
        Stage stage = (Stage)(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void incomeManagement(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com.example.dairy/Samiul/User7/IncomeManagement.fxml"));
        root = fxmlLoader.load() ;

        IncomeManagement adc = fxmlLoader.getController() ;
        adc.setter(this.user);

        Scene scene = new Scene(root) ;
        Stage stage = (Stage)(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void pendingOrders(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com.example.dairy/Samiul/User7/OrderApprovalPortal.fxml"));
        root = fxmlLoader.load() ;

        OrderApprovalPortal adc = fxmlLoader.getController() ;
        adc.setter(this.user);

        Scene scene = new Scene(root) ;
        Stage stage = (Stage)(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }
}
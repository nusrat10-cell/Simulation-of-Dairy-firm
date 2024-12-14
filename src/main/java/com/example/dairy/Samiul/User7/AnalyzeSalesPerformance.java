package com.example.dairy.Samiul.User7;

import com.example.dairy.Samiul.User8.OrderClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class AnalyzeSalesPerformance
{
    SalesAndMarketingManager user;
    @javafx.fxml.FXML
    private TableView salesPerformanceTable;
    @javafx.fxml.FXML
    private TableColumn<OrderClass, String> customerNameTableview;
    @javafx.fxml.FXML
    private TableColumn<OrderClass, String> customerQualityTableview;
    @javafx.fxml.FXML
    private TableColumn<OrderClass, Integer> numberOfOrdersTableview;
    @javafx.fxml.FXML
    private TableColumn<OrderClass, Integer> totalOrderValueTableview;

    public void setter (SalesAndMarketingManager manager){
        this.user = manager;
    }
    @javafx.fxml.FXML
    public void initialize() {

        customerNameTableview.setCellValueFactory(new PropertyValueFactory<>("name"));
        numberOfOrdersTableview.setCellValueFactory(new PropertyValueFactory<>("id"));

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


}
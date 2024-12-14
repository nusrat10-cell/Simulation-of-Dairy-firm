package com.example.dairy.Samiul.User7;

import com.example.dairy.Samiul.User8.OrderClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class DistributorList
{
    SalesAndMarketingManager user;

    @javafx.fxml.FXML
    private TableColumn<DistributorClass, Integer> numberTableview;
    @javafx.fxml.FXML
    private TableColumn<DistributorClass, String> zoneTableview;
    @javafx.fxml.FXML
    private TableColumn<DistributorClass, String> NameTableview;
    @javafx.fxml.FXML
    private TableColumn<DistributorClass, String> emailTableview;
    @javafx.fxml.FXML
    private TableView<DistributorClass> distributorTable;

    ObservableList<DistributorClass> distributor = FXCollections.observableArrayList();


    public void addDistributor(String name, String email, int number, String zone) {
        DistributorClass newDistributor = new DistributorClass(name, number, email, zone);
        distributor.add(newDistributor);
        distributorTable.setItems(distributor);
    }

    public void setter (SalesAndMarketingManager manager){
        this.user = manager;

        show();
    }
    @javafx.fxml.FXML
    public void initialize() {

        numberTableview.setCellValueFactory(new PropertyValueFactory<>("number"));
        zoneTableview.setCellValueFactory(new PropertyValueFactory<>("Zone"));
        NameTableview.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailTableview.setCellValueFactory(new PropertyValueFactory<>("email"));

        addDistributor("Samiul", "sam@gmail.com", 756543543, "Bashundhara");
        addDistributor("Rayhan", "fdsfds@gmail.com", 543543654, "Uttara");
        addDistributor("John", "fdsgg@gmail.com", 534543645, "Baridhara");
        addDistributor("Parvez", "terye@gmail.com", 875436654, "Gulshan");
        addDistributor("Mahmud", "bgfn@gmail.com", 545436654, "Tejgaon");



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

    public void show() {
        distributorTable.setItems(distributor);
    }



}
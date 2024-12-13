package com.example.dairy.Samiul.User7;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class InhouseOrder
{
    SalesAndMarketingManager user;
    @javafx.fxml.FXML
    private TableColumn<InhouseOrderClass, Integer> idTableview;
    @javafx.fxml.FXML
    private DatePicker deliveryDatePicker;
    @javafx.fxml.FXML
    private TableColumn<InhouseOrderClass, LocalDate> deliveryDateTableview;
    @javafx.fxml.FXML
    private TableColumn<InhouseOrderClass, String> nameTableview;
    @javafx.fxml.FXML
    private TableColumn<InhouseOrderClass, Integer> quantityTableview;
    @javafx.fxml.FXML
    private ComboBox<String> selectProductCombobox;
    @javafx.fxml.FXML
    private TextField quantityTF;
    @javafx.fxml.FXML
    private TableView<InhouseOrderClass> inhouseOrderTable;

    public void setter (SalesAndMarketingManager manager){
        this.user = manager;
    }

    ObservableList<InhouseOrderClass> inhouseOrderClasses = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        selectProductCombobox.getItems().addAll("Milk", "Cheese", "Yogurt", "Butter", "Cream");
        nameTableview.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityTableview.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        idTableview.setCellValueFactory(new PropertyValueFactory<>("id"));
        deliveryDateTableview.setCellValueFactory(new PropertyValueFactory<>("date"));


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
    public void placeOrderButton(ActionEvent actionEvent) {
        String name= selectProductCombobox.getValue();
        int quantity = Integer.parseInt(quantityTF.getText());
        LocalDate deliveryDate = deliveryDatePicker.getValue();


        InhouseOrderClass order = new InhouseOrderClass( name, quantity, deliveryDate);
        inhouseOrderClasses.add(order);
        show();


    }



    public void show() {

        inhouseOrderTable.setItems(inhouseOrderClasses);

    }
}
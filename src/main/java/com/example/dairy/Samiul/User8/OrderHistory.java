package com.example.dairy.Samiul.User8;

import com.example.dairy.Samiul.User7.CampaignClass;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OrderHistory
{
    Customer user;
    @javafx.fxml.FXML
    private TableColumn<OrderClass, String> productNameTableview;
    @javafx.fxml.FXML
    private TableColumn<OrderClass, Integer> quantityTableview;
    @javafx.fxml.FXML
    private TableColumn<OrderClass, Integer> priceTableview;
    @javafx.fxml.FXML
    private TableColumn<OrderClass, Integer> orderIdTableview;
    @javafx.fxml.FXML
    private TableView<OrderClass> orderHistoryTable;

    public void setter (Customer customer){
        this.user = customer;
        show();
    }

    ObservableList<OrderClass> orders = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    public void initialize() {

        orderIdTableview.setCellValueFactory(new PropertyValueFactory<>("id"));
        productNameTableview.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityTableview.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceTableview.setCellValueFactory(new PropertyValueFactory<>("price"));




    }

    public ObservableList<OrderClass> orderFileRead() {
        ObservableList<OrderClass> order = FXCollections.observableArrayList() ;

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("OrderData.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            OrderClass st ;
            try {
                while(true){
                    st = (OrderClass) ois.readObject();
                    System.out.println((st));
                    order.add(st) ;
                }
            }//end of nested try
            catch(Exception e){
                // handling code
            }//nested catch
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }

        return order ;
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/dairy/Samiul/User8/customerDashboard.fxml"));
        root = fxmlLoader.load() ;

        CustomerDashboard adc = fxmlLoader.getController() ;
        adc.setter(this.user);

        Scene scene = new Scene(root) ;
        Stage stage = (Stage)(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }

    public void show() {

        orders= orderFileRead();
        orderHistoryTable.setItems(orders);
    }

    @javafx.fxml.FXML
    public void showHistoryButton(ActionEvent actionEvent) {
        show();
    }
}
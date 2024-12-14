package com.example.dairy.ParvezHassan;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlacedOrderController
{
    @javafx.fxml.FXML
    private TableColumn<OrderToSupplier, LocalDate> date_Col;
    @javafx.fxml.FXML
    private TableColumn<OrderToSupplier, String> itemName_Col;
    @javafx.fxml.FXML
    private TableColumn<OrderToSupplier, Supplier> supplier_Col;
    @javafx.fxml.FXML
    private TableColumn<OrderToSupplier, Integer> quantity_Col;
    @javafx.fxml.FXML
    private TableColumn<OrderToSupplier, Integer> orderID_Col;
    @javafx.fxml.FXML
    private TableView<OrderToSupplier> ordersTableView;
    @javafx.fxml.FXML
    private TextField orderID_textField;
    @javafx.fxml.FXML
    private DatePicker orderDate_picker;
    @javafx.fxml.FXML
    private TextField quantity_textField;
    @javafx.fxml.FXML
    private TextField itemName_textField;
    @javafx.fxml.FXML
    private ComboBox<String> supplierComboBox;

    private List<OrderToSupplier> orders = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
//        ComboBox populate
        File file = new File("DataStore/Supplier.bin");
        if (file.exists()){
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
                List<Supplier> suppliers = (List<Supplier>)  ois.readObject();
                for (Supplier supplier : suppliers){
                    supplierComboBox.getItems().addAll(supplier.getName());
                }

            } catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }

//        Table
        orderID_Col.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        itemName_Col.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        date_Col.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        quantity_Col.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        supplier_Col.setCellValueFactory(new PropertyValueFactory<>("supplier"));
    }

    @javafx.fxml.FXML
    public void placeOrder_Button(ActionEvent actionEvent) {
      orders.clear();
      orders.addAll(ordersTableView.getItems());

      savePlacedOrder();

        System.out.println("Successfully Placed Order" + orders);
    }

    @javafx.fxml.FXML
    public void addandshow_Button(ActionEvent actionEvent) {
        int orderId = Integer.parseInt(orderID_textField.getText());
        String itemName = itemName_textField.getText();
        int quantity = Integer.parseInt(quantity_textField.getText());
        String supplier = supplierComboBox.getSelectionModel().getSelectedItem();
        LocalDate orderDate = orderDate_picker.getValue();

        OrderToSupplier newOrder = new OrderToSupplier(orderId, itemName, quantity, supplier, orderDate);
        ordersTableView.getItems().add(newOrder);

        orderID_textField.clear();
        itemName_textField.clear();
        quantity_textField.clear();
        supplierComboBox.getSelectionModel().clearSelection();
        orderDate_picker.setValue(null);
    }


    private void savePlacedOrder (){
        List<OrderToSupplier> existingOrders = new ArrayList<>();

        File file = new File("DataStore/PlacedOrderToSupplier.bin");
        if (file.exists()){
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
                existingOrders = (List<OrderToSupplier>) ois.readObject();
            } catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        existingOrders.addAll(orders);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(existingOrders);
            System.out.println("Placed Order Successfully");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
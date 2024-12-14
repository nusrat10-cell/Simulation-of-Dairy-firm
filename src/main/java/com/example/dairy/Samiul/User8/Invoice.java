package com.example.dairy.Samiul.User8;

import com.example.dairy.Samiul.User7.CampaignClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.*;

public class Invoice
{
    Customer user;
    @javafx.fxml.FXML
    private ComboBox<Integer> selectOrderIdCombobox;

    public void setter (Customer customer){
        this.user = customer;
    }

    ObservableList<OrderClass> orders = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    public void initialize() {

        orders = invoiceFileRead();
        for (OrderClass order : orders) {

            selectOrderIdCombobox.getItems().add(order.getId());

        }


    }


    @javafx.fxml.FXML
    public void createInvoiceButton(ActionEvent actionEvent) {

        Integer selectedOrderId = selectOrderIdCombobox.getValue();
        OrderClass selectedOrder = null;
        for (OrderClass order : orders) {
            if (order.getId() == selectedOrderId) {
                selectedOrder = order;
                break;
            }
        }


        File invoiceFile = new File("Invoice_" + selectedOrderId + ".txt");

        try (FileWriter writer = new FileWriter(invoiceFile)) {

            writer.write("Invoice\n");
            writer.write("=========================\n");
            writer.write("Order ID: " + selectedOrder.getId() + "\n");
            writer.write("Customer Name: " + selectedOrder.getName() + "\n");
            writer.write("Quantity: " + selectedOrder.getQuantity() + "\n");
            writer.write("Delivery Date: " + selectedOrder.getDeliveryDate() + "\n");
            writer.write("Total Price: $" + selectedOrder.getPrice() + "\n");
            writer.write("=========================\n");


        } catch (IOException e) {}
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


    public ObservableList<OrderClass> invoiceFileRead() {
        ObservableList<OrderClass> invoice = FXCollections.observableArrayList() ;

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
                    invoice.add(st) ;
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

        return invoice ;
    }
}
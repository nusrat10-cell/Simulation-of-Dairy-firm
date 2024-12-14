package com.example.dairy.mahamud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class DeliveryManagement {

    @FXML
    private ComboBox<String> dmvehicletypecomboboxfx;
    @FXML
    private TextField dmquantitytextfieldfx;
    @FXML
    private DatePicker dmdelivarydatefx;
    @FXML
    private ComboBox<String> dmroutecomboboxfx;

    @FXML
    private TableView<DeliveryModelClass> tablefx;
    @FXML
    private TableColumn<DeliveryModelClass, String> vehiclecollumfx;
    @FXML
    private TableColumn<DeliveryModelClass, String> routecollumfx;
    @FXML
    private TableColumn<DeliveryModelClass, Integer> quantitycollumfx;
    @FXML
    private TableColumn<DeliveryModelClass, LocalDate> datecollumfx;

    private ObservableList<DeliveryModelClass> deliveryModelClassList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        dmroutecomboboxfx.getItems().setAll("Dhaka to Gazipur", "Jatrabari to Uttara", "Dhaka to Madaripur", "Uttara to Dhanmondi");
        dmvehicletypecomboboxfx.getItems().setAll("Truck (Big)", "Truck (Small)", "Van (Big)", "Van (Small)");
        vehiclecollumfx.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        routecollumfx.setCellValueFactory(new PropertyValueFactory<>("deliveryRoute"));
        quantitycollumfx.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        datecollumfx.setCellValueFactory(new PropertyValueFactory<>("deliveryDate"));
        tablefx.setItems(deliveryModelClassList);
    }
    @FXML
    public void dmconfirmbuttonfx(ActionEvent actionEvent) {
        String vehicleType = dmvehicletypecomboboxfx.getValue();
        String deliveryRoute = dmroutecomboboxfx.getValue();
        String quantityStr = dmquantitytextfieldfx.getText();
        LocalDate deliveryDate = dmdelivarydatefx.getValue();
        if (vehicleType == null || deliveryRoute == null || quantityStr.isEmpty() || deliveryDate == null) {
            System.out.println("Please fill in all fields.");
            return;
        }
        if (!quantityStr.matches("\\d+")) {
            System.out.println("Please enter a valid numeric value for quantity.");
            return;
        }
        int quantity = Integer.parseInt(quantityStr);

        DeliveryModelClass data = new DeliveryModelClass(vehicleType, deliveryRoute, quantity, deliveryDate);
        deliveryModelClassList.add(data);
        dmvehicletypecomboboxfx.setValue(null);
        dmroutecomboboxfx.setValue(null);
        dmquantitytextfieldfx.clear();
        dmdelivarydatefx.setValue(null);
        tablefx.refresh();
    }
    @FXML
    public void dmbackbuttonfx(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Milk Processor.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

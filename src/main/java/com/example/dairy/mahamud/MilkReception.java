package com.example.dairy.mahamud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class MilkReception {
    @FXML
    private RadioButton mrpassradiobuttonfx;
    @FXML
    private TableColumn<ReceptionData, Double> mrquantitytablecollumfx;
    @FXML
    private TableColumn<ReceptionData, LocalDate> mrdatetablecollumfx;
    @FXML
    private TableView<ReceptionData> mrtablefx;
    @FXML
    private TableColumn<ReceptionData, String> mrtruckidtablecollumfx;
    @FXML
    private TextField mrquantitytextfieldfx;
    @FXML
    private TextField mrDeliveryidtextfieldfx;
    @FXML
    private TextField mrtruckidtextfieldfx;
    @FXML
    private RadioButton mrfailradiobuttonfx;
    @FXML
    private TableColumn<ReceptionData, String> mrstutustablecollumfx;
    @FXML
    private DatePicker mrdatefx;
    @FXML
    private TableColumn<ReceptionData, String> mrdeliveryidtablecollumfx;

    private ObservableList<ReceptionData> receptionDataList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        mrdeliveryidtablecollumfx.setCellValueFactory(new PropertyValueFactory<>("deliveryId"));
        mrtruckidtablecollumfx.setCellValueFactory(new PropertyValueFactory<>("truckId"));
        mrquantitytablecollumfx.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        mrdatetablecollumfx.setCellValueFactory(new PropertyValueFactory<>("date"));
        mrstutustablecollumfx.setCellValueFactory(new PropertyValueFactory<>("status"));
        mrtablefx.setItems(receptionDataList);
    }

    @FXML
    public void mrconfirmdeliverybuttonfx(ActionEvent actionEvent) {
        String deliveryId = mrDeliveryidtextfieldfx.getText();
        String truckId = mrtruckidtextfieldfx.getText();
        String quantityStr = mrquantitytextfieldfx.getText();
        LocalDate date = mrdatefx.getValue();
        String status = mrpassradiobuttonfx.isSelected() ? "Pass" : mrfailradiobuttonfx.isSelected() ? "Fail" : "";

        if (deliveryId.isEmpty() || truckId.isEmpty() || quantityStr.isEmpty() || date == null || status.isEmpty()) {
            System.out.println("Please fill in all fields and select a status.");
            return;
        }

        try {
            double quantity = Double.parseDouble(quantityStr);
            ReceptionData data = new ReceptionData(deliveryId, truckId, quantity, date, status);
            receptionDataList.add(data);
            mrDeliveryidtextfieldfx.clear();
            mrtruckidtextfieldfx.clear();
            mrquantitytextfieldfx.clear();
            mrdatefx.setValue(null);
            mrpassradiobuttonfx.setSelected(false);
            mrfailradiobuttonfx.setSelected(false);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid quantity.");
        }
    }
    @FXML
    public void mrbackbuttonfx(ActionEvent actionEvent) {
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

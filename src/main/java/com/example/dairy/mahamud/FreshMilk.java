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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class FreshMilk {
    @FXML
    private TextField fmtempareturetextfieldfx;
    @FXML
    private ComboBox<String> fmRefrigerationcombobxfx;
    @FXML
    private TableColumn<freshmilkModelClass, String> fmstutuscollumfx;
    @FXML
    private TableView<freshmilkModelClass> fmtablefx;
    @FXML
    private TableColumn<freshmilkModelClass, Double> fmtempareturecollumfx;

    private ObservableList<freshmilkModelClass> freshmilkModelClassList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        fmRefrigerationcombobxfx.getItems().setAll("Running", "Idle", "Cooling");
        fmtempareturecollumfx.setCellValueFactory(new PropertyValueFactory<>("temperature"));
        fmstutuscollumfx.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Set table data
        fmtablefx.setItems(freshmilkModelClassList);
    }
    @FXML
    public void fmstartcollectionbuttonfx(ActionEvent actionEvent) {
        String temperatureStr = fmtempareturetextfieldfx.getText();
        String status = fmRefrigerationcombobxfx.getValue();
        if (temperatureStr.isEmpty() || status == null) {
            System.out.println("Please fill in all fields.");
            return;
        }
        try {
            double temperature = Double.parseDouble(temperatureStr);
            freshmilkModelClass data = new freshmilkModelClass(temperature, status);
            freshmilkModelClassList.add(data);
            fmtempareturetextfieldfx.clear();
            fmRefrigerationcombobxfx.setValue(null);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid temperature.");
        }
    }

    @FXML
    public void fmbackbuttonfx(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Milk Collector.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            // Handle FXML loading error
            e.printStackTrace();
        }
}}

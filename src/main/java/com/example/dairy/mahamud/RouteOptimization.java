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

public class RouteOptimization {

    @FXML
    private TableColumn<RouteData, String> roidtablecollumfx;
    @FXML
    private TableColumn<RouteData, String> roquantitytablecollumfx;
    @FXML
    private TextField rofarmernametextfieldfx;
    @FXML
    private TextField rosampleidtextfieldfx;
    @FXML
    private TableColumn<RouteData, String> ronametablecollumfx;
    @FXML
    private TableView<RouteData> rotablefx;
    @FXML
    private TableColumn<RouteData, String> rodestinationtablecollumfx;
    @FXML
    private TextField roquantitytextfieldfx;
    @FXML
    private ComboBox<String> rodestinationcomboboxfx;

    private ObservableList<RouteData> routeDataList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        rodestinationcomboboxfx.getItems().setAll("Dhaka to Gazipur", "Gazipur to Uttara", "Uttara to Jatrabari", "Jatrabari to Dhanmondi");
        roidtablecollumfx.setCellValueFactory(new PropertyValueFactory<>("sampleId"));
        roquantitytablecollumfx.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        ronametablecollumfx.setCellValueFactory(new PropertyValueFactory<>("farmerName"));
        rodestinationtablecollumfx.setCellValueFactory(new PropertyValueFactory<>("destination"));
        rotablefx.setItems(routeDataList);
    }

    @FXML
    public void roconfirmcollectionbuttonfx(ActionEvent actionEvent) {
        String sampleId = rosampleidtextfieldfx.getText();
        String quantityStr = roquantitytextfieldfx.getText();
        String farmerName = rofarmernametextfieldfx.getText();
        String destination = rodestinationcomboboxfx.getValue();
        if (sampleId.isEmpty() || quantityStr.isEmpty() || farmerName.isEmpty() || destination == null) {
            System.out.println("Please fill in all fields.");
            return;
        }
        if (!quantityStr.matches("\\d+")) {
            System.out.println("Please enter a valid numeric value for quantity.");
            return;
        }

        int quantity = Integer.parseInt(quantityStr);

        RouteData data = new RouteData(sampleId, quantity, farmerName, destination);
        routeDataList.add(data);
        rosampleidtextfieldfx.clear();
        roquantitytextfieldfx.clear();
        rofarmernametextfieldfx.clear();
        rodestinationcomboboxfx.setValue(null);

        rotablefx.refresh();
    }

    @FXML
    public void robackbuttonfx(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Milk Collector.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            // Handle FXML loading error
            e.printStackTrace();
        }
    }
}

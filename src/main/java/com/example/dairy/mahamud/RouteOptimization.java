package com.example.dairy.mahamud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

//import java.awt.event.ActionEvent;

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
    private TextField rodestinationfx;
    @FXML
    private TableColumn<RouteData, String> rodestinationtablecollumfx;
    @FXML
    private TextField roquantitytextfieldfx;

    private ObservableList<RouteData> routeDataList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Initialize Table Columns
        roidtablecollumfx.setCellValueFactory(new PropertyValueFactory<>("sampleId"));
        ronametablecollumfx.setCellValueFactory(new PropertyValueFactory<>("farmerName"));
        roquantitytablecollumfx.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        rodestinationtablecollumfx.setCellValueFactory(new PropertyValueFactory<>("destination"));

        // Set table data
        rotablefx.setItems(routeDataList);
    }

    @FXML
    public void robackbuttonfx(ActionEvent actionEvent) {
        // Handle back button action
        System.out.println("Back button clicked.");
    }

    @FXML
    public void roconfirmcollectionbuttonfx(ActionEvent actionEvent) {

    }

    private boolean isValidDestination(String destination) {
        String[] validDestinations = {"Dhaka", "Gajipur", "Jatrabari", "Dhanmondi", "Gulistan", "Uttara"};
        for (String validDestination : validDestinations) {
            if (validDestination.equalsIgnoreCase(destination)) {
                return true;
            }
        }
        return false;
    }


}

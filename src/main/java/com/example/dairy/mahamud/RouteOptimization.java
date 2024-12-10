package com.example.dairy.mahamud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.ActionEvent;

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
        String sampleId = rosampleidtextfieldfx.getText();
        String farmerName = rofarmernametextfieldfx.getText();
        String destination = rodestinationfx.getText();
        String quantityStr = roquantitytextfieldfx.getText();

        if (sampleId.isEmpty() || farmerName.isEmpty() || destination.isEmpty() || quantityStr.isEmpty()) {
            System.out.println("Please fill in all fields.");
            return;
        }

        try {
            double quantity = Double.parseDouble(quantityStr);
            if (quantity < 1 || quantity > 50) {
                System.out.println("Please enter a quantity between 1 and 50 liters.");
                return;
            }

            if (!isValidDestination(destination)) {
                System.out.println("Invalid destination. Please enter a valid destination.");
                return;
            }

            RouteData data = new RouteData(sampleId, farmerName, quantity, destination);
            routeDataList.add(data);

            // Clear the fields after submission
            rosampleidtextfieldfx.clear();
            rofarmernametextfieldfx.clear();
            rodestinationfx.clear();
            roquantitytextfieldfx.clear();

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid quantity.");
        }
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

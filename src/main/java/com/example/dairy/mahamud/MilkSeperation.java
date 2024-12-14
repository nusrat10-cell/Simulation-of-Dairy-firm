package com.example.dairy.mahamud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;

public class MilkSeperation {
    @FXML
    private ComboBox<String> msmilkcomponantcomboboxfx;
    @FXML
    private TextField msamountofmilktextfieldfx;
    @FXML
    private ComboBox<String> msmilktypecomboboxfx;
    @FXML
    private Label mslabelmassagefx;
    @FXML
    private TableView<SeperationData> mstablefx;
    @FXML
    private TableColumn<SeperationData, String> mscomponantcolfx;
    @FXML
    private TableColumn<SeperationData, String> mstypecolfx;
    @FXML
    private TableColumn<SeperationData, Double> msquantitycolfx;

    private ObservableList<SeperationData> seperationDataList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        msmilkcomponantcomboboxfx.getItems().setAll("Fat", "Lactose", "Whey", "Cream", "Butter");
        msmilktypecomboboxfx.getItems().setAll("Cow", "Goat", "Buffalo");
        mscomponantcolfx.setCellValueFactory(new PropertyValueFactory<>("milkComponent"));
        mstypecolfx.setCellValueFactory(new PropertyValueFactory<>("milkType"));
        msquantitycolfx.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        mstablefx.setItems(seperationDataList);
    }

    @FXML
    public void msRunSeperationbuttonfx(ActionEvent actionEvent) {
        String milkComponent = msmilkcomponantcomboboxfx.getValue();
        String milkType = msmilktypecomboboxfx.getValue();
        String quantityStr = msamountofmilktextfieldfx.getText();
        if (milkComponent == null || milkType == null || quantityStr.isEmpty()) {
            mslabelmassagefx.setText("Please fill in all fields.");
            return;
        }
        double quantity = 0;
        boolean isValidQuantity = true;

        if (!quantityStr.matches("\\d+(\\.\\d+)?")) {
            isValidQuantity = false;
        } else {
            quantity = Double.parseDouble(quantityStr);
        }

        if (!isValidQuantity) {
            mslabelmassagefx.setText("Please enter a valid quantity.");
            return;
        }

        SeperationData data = new SeperationData(milkComponent, milkType, quantity);
        seperationDataList.add(data);
        msmilkcomponantcomboboxfx.setValue(null);
        msmilktypecomboboxfx.setValue(null);
        msamountofmilktextfieldfx.clear();
        mslabelmassagefx.setText("Milk is separated well!");
    }
    @FXML
    public void msbackbuttonfx(ActionEvent actionEvent) {
        // Handle back button action
        System.out.println("Back button clicked.");
    }
}

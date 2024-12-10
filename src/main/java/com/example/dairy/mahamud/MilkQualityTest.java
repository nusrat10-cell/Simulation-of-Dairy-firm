package com.example.dairy.mahamud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;


public class MilkQualityTest {
    @FXML
    private ComboBox<String> mqtmilktypecomboboxfx;
    @FXML
    private ComboBox<String> mqtqualitycomboboxfx;
    @FXML
    private RadioButton mqtpassradiobuttonfx;
    @FXML
    private TextField mqtfarmernametextfieldfx;
    @FXML
    private RadioButton mqtfailradiobuttonfx;
    @FXML
    private TextField mqtsampleidtextfieldfx;
    @FXML
    private Label mqtlabelmassagefx;

    private ObservableList<milkqualitytestModelClass> milkqualitytestModelClassList = FXCollections.observableArrayList();

    @FXML
    private ToggleGroup qualityToggleGroup;

    @FXML
    public void initialize() {
        mqtmilktypecomboboxfx.getItems().setAll("Cow Milk", "Goat Milk", "Sheep Milk");
        mqtqualitycomboboxfx.getItems().setAll("Grade A", "Grade B", "Grade C");

        qualityToggleGroup = new ToggleGroup();
        mqtpassradiobuttonfx.setToggleGroup(qualityToggleGroup);
        mqtfailradiobuttonfx.setToggleGroup(qualityToggleGroup);
    }

    @FXML
    public void mqtprocedbuttonfx(ActionEvent actionEvent) {
        String sampleId = mqtsampleidtextfieldfx.getText();
        String farmerName = mqtfarmernametextfieldfx.getText();
        String milkType = mqtmilktypecomboboxfx.getValue();
        String milkQuality = mqtqualitycomboboxfx.getValue();
        String qualityResult = (mqtpassradiobuttonfx.isSelected()) ? "Pass" : "Fail";

        if (sampleId.isEmpty() || farmerName.isEmpty() || milkType == null || milkQuality == null) {
            mqtlabelmassagefx.setText("Please fill in all fields.");
            return;
        }

        milkqualitytestModelClass data = new milkqualitytestModelClass(sampleId, farmerName, milkType, milkQuality, qualityResult);
        milkqualitytestModelClassList.add(data);
        for (milkqualitytestModelClass entry : milkqualitytestModelClassList) {
            System.out.println(entry);
        }
        mqtsampleidtextfieldfx.clear();
        mqtfarmernametextfieldfx.clear();
        mqtmilktypecomboboxfx.setValue(null);
        mqtqualitycomboboxfx.setValue(null);
        qualityToggleGroup.selectToggle(null);
        mqtlabelmassagefx.setText("Data added successfully!");
    }

    @FXML
    public void mqtbackbuttonfx(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Milk Collector.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {

            e.printStackTrace();
        }
        // Handle back button action

        System.out.println("Back button clicked.");
    }
}

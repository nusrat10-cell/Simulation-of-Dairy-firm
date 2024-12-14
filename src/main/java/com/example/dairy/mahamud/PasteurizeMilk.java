package com.example.dairy.mahamud;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PasteurizeMilk {
    @FXML
    private Label pmlabelfx;
    @FXML
    private Label pmlabelfx1;
    @FXML
    private Label pmlabelfx2;
    @FXML
    private Label pmlabelfx3;

    @FXML
    public void initialize() {
    }

    @FXML
    public void pmbckbuttonfx(ActionEvent actionEvent) {
        // Handle back button action
        System.out.println("Back button clicked.");
    }

    @FXML
    public void pmfinishfx(ActionEvent actionEvent) {
        // Set the text for each label
        pmlabelfx2.setText("Cow, Goat, Buffalo");
        pmlabelfx1.setText("Healthy, Long Lasting, Safe");
        pmlabelfx3.setText("Rich in Nutrition, Hygienically Processed, Longer Shelf Life");
        pmlabelfx.setText("Our milk is 100% pure and certified.");
    }
}

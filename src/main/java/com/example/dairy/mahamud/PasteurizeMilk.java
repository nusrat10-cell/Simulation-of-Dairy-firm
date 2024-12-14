package com.example.dairy.mahamud;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

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
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Milk Processor.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void pmfinishfx(ActionEvent actionEvent) {
        pmlabelfx2.setText("Cow, Goat, Buffalo");
        pmlabelfx1.setText("Healthy, Long Lasting, Safe");
        pmlabelfx3.setText("Rich in Nutrition, Hygienically Processed, Longer Shelf Life");
        pmlabelfx.setText("Our milk is 100% pure and certified.");
    }
}

package com.example.dairy.mahamud;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class SupplierManagemen {
    @FXML
    private Label smlabelthankfx;
    @FXML
    private TextField smnametextfieldfx;
    @FXML
    private TextField smcontacttextfieldfx;
    @FXML
    private TextField smidtextfieldfx;
    @FXML
    private DatePicker smdatefx;

    private ArrayList<SupplierData> supplierDataList = new ArrayList<>();

    @FXML
    public void initialize() {
    }

    @FXML
    public void smconfirmorderbuttonfx(ActionEvent actionEvent) {
        String id = smidtextfieldfx.getText();
        String name = smnametextfieldfx.getText();
        String contact = smcontacttextfieldfx.getText();
        LocalDate date = smdatefx.getValue();

        if (id.isEmpty() || name.isEmpty() || contact.isEmpty() || date == null) {
            smlabelthankfx.setText("Please fill in all fields.");
            return;
        }

        if (contact.length() != 11 || !contact.matches("\\d+")) {
            smlabelthankfx.setText("Contact number should be 11 digits.");
            return;
        }

        SupplierData data = new SupplierData(id, name, contact, date);
        supplierDataList.add(data);


        smidtextfieldfx.clear();
        smnametextfieldfx.clear();
        smcontacttextfieldfx.clear();
        smdatefx.setValue(null);

        smlabelthankfx.setText("Congratulations! Data added successfully.");
    }

    @FXML
    public void smbackbuttonfx(ActionEvent actionEvent) {
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

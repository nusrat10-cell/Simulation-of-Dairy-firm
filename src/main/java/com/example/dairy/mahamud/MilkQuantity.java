package com.example.dairy.mahamud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;


public class MilkQuantity {
    @FXML
    private TableView<QuantityData> mqtablefx;
    @FXML
    private TableColumn<QuantityData, String> mqquantitycollumfx;
    @FXML
    private TextField mqidtextfieldfx;
    @FXML
    private TextField mqquantitytextfieldfx;
    @FXML
    private TableColumn<QuantityData, String> mqnamecollumfx;
    @FXML
    private TextField mqnametextfieldfx;
    @FXML
    private TableColumn<QuantityData, String> mqidcollumfx;

    private ObservableList<QuantityData> quantityDataList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        mqidcollumfx.setCellValueFactory(new PropertyValueFactory<>("id"));
        mqnamecollumfx.setCellValueFactory(new PropertyValueFactory<>("name"));
        mqquantitycollumfx.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        mqtablefx.setItems(quantityDataList);
    }

    @FXML
    public void mqconfirmquantitybuttonfx(ActionEvent actionEvent) {
        String id = mqidtextfieldfx.getText();
        String name = mqnametextfieldfx.getText();
        String quantityStr = mqquantitytextfieldfx.getText();

        if (id.isEmpty() || name.isEmpty() || quantityStr.isEmpty()) {
            System.out.println("Please fill in all fields.");
            return;
        }

        try {
            double quantity = Double.parseDouble(quantityStr);
            if (quantity < 1 || quantity > 50) {
                System.out.println("Please enter a quantity between 1 and 50 liters.");
                return;
            }

            QuantityData data = new QuantityData(id, name, quantity);
            quantityDataList.add(data);
            mqidtextfieldfx.clear();
            mqnametextfieldfx.clear();
            mqquantitytextfieldfx.clear();

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid quantity.");
        }
    }

    @FXML
    public void mqbackbuttonfx(ActionEvent actionEvent) {
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

    @FXML
    public void mqaddbuttonfx(ActionEvent actionEvent) {
        // This method can be used for additional logic if needed
    }
}

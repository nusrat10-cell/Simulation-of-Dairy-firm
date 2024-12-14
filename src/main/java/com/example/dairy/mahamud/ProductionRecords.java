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

public class ProductionRecords {

    @FXML
    private ComboBox<String> prwastagecomboxfx;
    @FXML
    private TextField prquantitytextfieldfx;
    @FXML
    private ComboBox<String> prtypeofquantityscomboxfx;

    @FXML
    private TableView<ProductionRecordModel> prtablefx;
    @FXML
    private TableColumn<ProductionRecordModel, String> prwastagetablecollumfx;
    @FXML
    private TableColumn<ProductionRecordModel, Integer> prquantitytablecollumfx;
    @FXML
    private TableColumn<ProductionRecordModel, String> prtypeqquantitytablecollumfx;

    private ObservableList<ProductionRecordModel> productionRecordList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        prwastagecomboxfx.getItems().setAll("Low", "Moderate", "High");
        prtypeofquantityscomboxfx.getItems().setAll("Milk", "Butter", "Cheese", "Cream");
        prwastagetablecollumfx.setCellValueFactory(new PropertyValueFactory<>("wastage"));
        prquantitytablecollumfx.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        prtypeqquantitytablecollumfx.setCellValueFactory(new PropertyValueFactory<>("typeOfQuantity"));
        prtablefx.setItems(productionRecordList);
    }

    @FXML
    public void prsaverecordbuttonfx(ActionEvent actionEvent) {
        String wastage = prwastagecomboxfx.getValue();
        String quantityStr = prquantitytextfieldfx.getText();
        String typeOfQuantity = prtypeofquantityscomboxfx.getValue();

        if (wastage == null || quantityStr.isEmpty() || typeOfQuantity == null) {
            System.out.println("Please fill in all fields.");
            return;
        }

        if (!quantityStr.matches("\\d+")) {
            System.out.println("Please enter a valid numeric value for quantity.");
            return;
        }

        int quantity = Integer.parseInt(quantityStr);
        ProductionRecordModel data = new ProductionRecordModel(typeOfQuantity, quantity, wastage);
        productionRecordList.add(data);
        prwastagecomboxfx.setValue(null);
        prquantitytextfieldfx.clear();
        prtypeofquantityscomboxfx.setValue(null);

        prtablefx.refresh();
    }

    @FXML
    public void prbackbuttonfx(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Milk Processor.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

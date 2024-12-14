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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class qualityControl {
    @FXML
    private TextField idfx;
    @FXML
    private TextField tempfx;
    @FXML
    private TextField phfx;
    @FXML
    private ComboBox<String> contentfx;
    @FXML
    private RadioButton passfx;
    @FXML
    private RadioButton failfx;

    @FXML
    private TableView<QualityControlModel> tablefx;
    @FXML
    private TableColumn<QualityControlModel, String> idclfx;
    @FXML
    private TableColumn<QualityControlModel, String> tempcolfx;
    @FXML
    private TableColumn<QualityControlModel, String> phcolfx;
    @FXML
    private TableColumn<QualityControlModel, String> contentcolfx;
    @FXML
    private TableColumn<QualityControlModel, String> stutusfxrad;

    private ObservableList<QualityControlModel> qualityControlList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        contentfx.getItems().setAll("Low Fat", "Regular", "High Fat");
        idclfx.setCellValueFactory(new PropertyValueFactory<>("id"));
        tempcolfx.setCellValueFactory(new PropertyValueFactory<>("temperature"));
        phcolfx.setCellValueFactory(new PropertyValueFactory<>("ph"));
        contentcolfx.setCellValueFactory(new PropertyValueFactory<>("fatContent"));
        stutusfxrad.setCellValueFactory(new PropertyValueFactory<>("status"));
        tablefx.setItems(qualityControlList);
    }
    @FXML
    public void confirmbuttonfx(ActionEvent actionEvent) {
        String id = idfx.getText();
        String temperature = tempfx.getText();
        String ph = phfx.getText();
        String fatContent = contentfx.getValue();
        String status = passfx.isSelected() ? "Pass" : failfx.isSelected() ? "Fail" : "";

        if (id.isEmpty() || temperature.isEmpty() || ph.isEmpty() || fatContent == null || status.isEmpty()) {
            System.out.println("Please fill in all fields and select a status.");
            return;
        }
        QualityControlModel data = new QualityControlModel(id, temperature, ph, fatContent, status);
        qualityControlList.add(data);
        idfx.clear();
        tempfx.clear();
        phfx.clear();
        contentfx.setValue(null);
        passfx.setSelected(false);
        failfx.setSelected(false);

        tablefx.refresh();
    }

    @FXML
    public void backbuttonfx(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Milk Processor.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }}
}

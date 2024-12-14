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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

public class EquipmentMonitoring {
    @FXML
    private ComboBox<String> emmachinescomboboxfx;
    @FXML
    private TableView<EquipmentData> emtablefx;
    @FXML
    private Label emerrorlabelfx;
    @FXML
    private TableColumn<EquipmentData, String> emequipmentnamecollumfx;
    @FXML
    private TableColumn<EquipmentData, LocalDate> emLastMaintenanceDatecollumfx;
    @FXML
    private TableColumn<EquipmentData, String> emStatuscollumfx;
    @FXML
    private TableColumn<EquipmentData, Integer> emCurrentUsagecollumfx;

    private ObservableList<EquipmentData> equipmentDataList = FXCollections.observableArrayList();
    private final Random random = new Random();

    @FXML
    public void initialize() {
        emmachinescomboboxfx.getItems().setAll("Pasteurizer", "Homogenizer", "Separator", "Filling Machine", "Cooling Tank");
        emequipmentnamecollumfx.setCellValueFactory(new PropertyValueFactory<>("equipmentName"));
        emLastMaintenanceDatecollumfx.setCellValueFactory(new PropertyValueFactory<>("lastMaintenanceDate"));
        emStatuscollumfx.setCellValueFactory(new PropertyValueFactory<>("status"));
        emCurrentUsagecollumfx.setCellValueFactory(new PropertyValueFactory<>("currentUsage"));
        emtablefx.setItems(equipmentDataList);
    }

    @FXML
    public void emcheackedbuttonfx(ActionEvent actionEvent) {
        emerrorlabelfx.setText("Checked button clicked.");
    }

    @FXML
    public void embackbuttonfx(ActionEvent actionEvent) {
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
    public void emmonitoreqquipmentbuttonfx(ActionEvent actionEvent) {
        String equipmentName = emmachinescomboboxfx.getValue();

        if (equipmentName == null) {
            emerrorlabelfx.setText("Please select a machine.");
            return;
        }
        String status = generateRandomStatus();
        LocalDate lastMaintenanceDate = generateRandomDate();
        int currentUsage = generateRandomUsage();

        EquipmentData data = new EquipmentData(equipmentName, lastMaintenanceDate, status, currentUsage);
        equipmentDataList.add(data);
        emmachinescomboboxfx.setValue(null);
        emerrorlabelfx.setText("Equipment monitored successfully.");
    }
    private String generateRandomStatus() {
        String[] statuses = {"Operational", "Under Maintenance", "Out of Service"};
        return statuses[random.nextInt(statuses.length)];
    }
    private LocalDate generateRandomDate() {
        int year = LocalDate.now().getYear() - random.nextInt(5); // Random year in the last 5 years
        int dayOfYear = random.nextInt(365) + 1; // Random day of the year
        return LocalDate.ofYearDay(year, dayOfYear);
    }
    private int generateRandomUsage() {
        return random.nextInt(1000); // Random usage value between 0 and 1000
    }
}

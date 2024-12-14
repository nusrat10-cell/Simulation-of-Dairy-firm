package com.example.dairy.mahamud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
        // Initialize ComboBox with machine names
        emmachinescomboboxfx.getItems().setAll("Pasteurizer", "Homogenizer", "Separator", "Filling Machine", "Cooling Tank");

        // Initialize Table Columns
        emequipmentnamecollumfx.setCellValueFactory(new PropertyValueFactory<>("equipmentName"));
        emLastMaintenanceDatecollumfx.setCellValueFactory(new PropertyValueFactory<>("lastMaintenanceDate"));
        emStatuscollumfx.setCellValueFactory(new PropertyValueFactory<>("status"));
        emCurrentUsagecollumfx.setCellValueFactory(new PropertyValueFactory<>("currentUsage"));

        // Set table data
        emtablefx.setItems(equipmentDataList);
    }

    @FXML
    public void emcheackedbuttonfx(ActionEvent actionEvent) {
        // Handle checked button action
        emerrorlabelfx.setText("Checked button clicked.");
    }

    @FXML
    public void embackbuttonfx(ActionEvent actionEvent) {
        // Handle back button action
        System.out.println("Back button clicked.");
    }

    @FXML
    public void emmonitoreqquipmentbuttonfx(ActionEvent actionEvent) {
        String equipmentName = emmachinescomboboxfx.getValue();

        if (equipmentName == null) {
            emerrorlabelfx.setText("Please select a machine.");
            return;
        }

        // Generate random status, maintenance date, and usage
        String status = generateRandomStatus();
        LocalDate lastMaintenanceDate = generateRandomDate();
        int currentUsage = generateRandomUsage();

        EquipmentData data = new EquipmentData(equipmentName, lastMaintenanceDate, status, currentUsage);
        equipmentDataList.add(data);

        // Clear the ComboBox selection
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

package com.example.dairy.mahamud;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

public class ReportIssues {
    @FXML
    private RadioButton riTransportationradbuttonfx;
    @FXML
    private RadioButton rimilkqualityradiobuttonfx;
    @FXML
    private RadioButton riSupplierProblemradbuttonfx;
    @FXML
    private Label rilabelmassagefx;
    @FXML
    private PieChart piechartfx;

    @FXML
    public void initialize() {
        // Initialize pie chart with no data
        piechartfx.setData(FXCollections.observableArrayList());
    }

    @FXML
    public void ribackbuttonfx(ActionEvent actionEvent) {
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
    public void risubmitbuttonfx(ActionEvent actionEvent) {
        String errorType = getSelectedErrorType();

        if (errorType == null) {
            rilabelmassagefx.setText("Please select an issue type.");
            return;
        }

        // Update pie chart with the selected issue
        updatePieChart(errorType);

        // Show success message
        rilabelmassagefx.setText("Issue reported successfully!");
    }

    private String getSelectedErrorType() {
        if (riTransportationradbuttonfx.isSelected()) {
            return "Transportation Issue";
        } else if (rimilkqualityradiobuttonfx.isSelected()) {
            return "Milk Quality Issue";
        } else if (riSupplierProblemradbuttonfx.isSelected()) {
            return "Supplier Problem";
        }
        return null;
    }

    private void updatePieChart(String errorType) {
        ObservableList<PieChart.Data> pieChartData = piechartfx.getData();

        PieChart.Data data = pieChartData.stream()
                .filter(d -> d.getName().equals(errorType))
                .findFirst()
                .orElseGet(() -> {
                    PieChart.Data newData = new PieChart.Data(errorType, 0);
                    pieChartData.add(newData);
                    return newData;
                });

        data.setPieValue(data.getPieValue() + 1);
    }
}

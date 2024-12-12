package com.example.dairy.Nupur;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ProductRecommendations {

    @FXML
    private TextField customerNameTF;
    @FXML
    private TextField idTF;
    @FXML
    private ListView<String> listView;
    @FXML
    private PieChart salesPieChart;
    @FXML
    private Label statusLabel;

    private ObservableList<String> recommendationList = FXCollections.observableArrayList();
    private ObservableList<PieChart.Data> salesData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        listView.setItems(recommendationList);
        salesPieChart.setData(salesData);
    }

    @FXML
    public void recommandButton(ActionEvent actionEvent) {
        String customerName = customerNameTF.getText();
        String customerId = idTF.getText();

        // Validate inputs
        if (customerName.isEmpty() || customerId.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Input Error", "Please fill out all fields correctly.");
            return;
        }

        // Example: Fetch and display sales data for the pie chart
        // Replace this with real data fetching logic
        salesData.clear();
        salesData.addAll(
                new PieChart.Data("Butter", 50),
                new PieChart.Data("Ghee", 15),
                new PieChart.Data("Milk", 40),
                new PieChart.Data("Ice Cream", 35),
                new PieChart.Data("Cream", 40),
                new PieChart.Data("Paneer", 9),
                new PieChart.Data("Yogert", 55),
                new PieChart.Data("Cheese", 70)
        );

        // Update the recommendations based on the sales data
        updateRecommendations();

        statusLabel.setText("Recommendations for Customer: " + customerName);
    }

    private void updateRecommendations() {
        recommendationList.clear();

        // Sort salesData by value in descending order
        salesData.sorted((d1, d2) -> Double.compare(d2.getPieValue(), d1.getPieValue()))
                .forEach(data -> recommendationList.add("Recommendation: " + data.getName()));
    }

    @FXML
    public void submitButton(ActionEvent actionEvent) {
        // Logic to process the submission of recommendations
        // This is a placeholder and should be implemented as needed
        showAlert(Alert.AlertType.INFORMATION, "Submission", "Recommendations have been submitted.");
    }

    @FXML
    public void backButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("customer representative dashboard.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            // Handle FXML loading error
            e.printStackTrace();
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

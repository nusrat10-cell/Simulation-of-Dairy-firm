package com.example.dairy.ParvezHassan;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProfitAndLossController
{
    @javafx.fxml.FXML
    private LineChart<String, Number> revenueChart;
    @javafx.fxml.FXML
    private ComboBox<String> year_CB;
    @javafx.fxml.FXML
    private ComboBox<String> expenseMonth_CB;
    @javafx.fxml.FXML
    private TextArea textArea;
    @javafx.fxml.FXML
    private ComboBox<String> year2_CB;

    @javafx.fxml.FXML
    public void initialize() {
        year_CB.getItems().addAll("2024", "2025");
        year2_CB.getItems().addAll("2024", "2025");
        expenseMonth_CB.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");


    }

    @javafx.fxml.FXML
    public void calcuProfitLoss(ActionEvent actionEvent) {
        String selectedYear = year2_CB.getSelectionModel().getSelectedItem();
        String selectedMonth = expenseMonth_CB.getSelectionModel().getSelectedItem();

        if (selectedYear != null && selectedMonth != null) {
            double revenue = getRevenue(selectedYear, selectedMonth);
            double expense = getExpense(selectedYear, selectedMonth);

            double profitOrLoss = revenue - expense;

            // Display profit or loss in the text area
            String result;
            if (profitOrLoss > 0) {
                result = "Profit for " + selectedMonth + " is " + profitOrLoss;
            } else {
                result = "Loss for " + selectedMonth + " is " + (-profitOrLoss);
            }
            textArea.setText(result);
        } else {
            textArea.setText("Please select both year and month.");
        }
    }



    @javafx.fxml.FXML
    public void showRevenueButton(ActionEvent actionEvent) {
        String selectedYear = year_CB.getSelectionModel().getSelectedItem();

        if (selectedYear != null) {
            // Clear existing data in the chart
            revenueChart.getData().clear();

            // Read revenue data from Revenue.txt
            Map<String, Integer> monthlyRevenue = new HashMap<>();
            try (BufferedReader br = new BufferedReader(new FileReader("Revenue.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(", ");
                    if (parts.length == 3) {
                        String month = parts[0].trim();
                        String year = parts[1].trim();
                        int revenue = Integer.parseInt(parts[2].trim());

                        if (year.equals(selectedYear)) {
                            monthlyRevenue.put(month, revenue);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Create a series for the chart
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName("Revenue for " + selectedYear);

            String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            for (String month : months) {
                Integer revenue = monthlyRevenue.get(month);
                if (revenue != null) {
                    series.getData().add(new XYChart.Data<>(month, revenue));
                }
            }
            revenueChart.getData().add(series);
        } else {
            textArea.setText("Please select a year.");
        }
    }

    private double getExpense(String year, String month) {
        double expense = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("Expenses.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    String fileYear = parts[0].split(": ")[1].trim();
                    String fileMonth = parts[1].split(": ")[1].trim();
                    double fileExpense = Double.parseDouble(parts[2].split(": ")[1].trim());

                    if (fileYear.equals(year) && fileMonth.equals(month)) {
                        expense = fileExpense;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return expense;
    }

    private double getRevenue(String year, String month) {
        double revenue = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("Revenue.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    String fileMonth = parts[0].trim();
                    String fileYear = parts[1].trim();
                    double fileRevenue = Double.parseDouble(parts[2].trim());

                    if (fileYear.equals(year) && fileMonth.equals(month)) {
                        revenue = fileRevenue;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return revenue;
    }


    @javafx.fxml.FXML
    public void back_Button(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Dashboard2.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            // Handle FXML loading error
            e.printStackTrace();
        }
    }
}

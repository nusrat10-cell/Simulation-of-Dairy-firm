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

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
//DEBUG
        System.out.println("expense: " + getExpense(selectedYear,selectedMonth));
        System.out.printf("revenue " + getRevenue(selectedYear,selectedMonth));


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
    public void showRevenueButton(ActionEvent actionEvent) {String selectedYear = year_CB.getSelectionModel().getSelectedItem();

        if (selectedYear != null) {
            // Clear existing data in the chart
            revenueChart.getData().clear();

            // Read revenue data from generateRevenue.bin
            Map<String, Double> monthlyRevenue = new HashMap<>();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DataStore/generateRevenue.bin"))) {
                List<Revenue> revenues = (List<Revenue>) ois.readObject();

                for (Revenue revenue : revenues) {
                    if (String.valueOf(revenue.getYear()).equals(selectedYear)) {
                        monthlyRevenue.put(revenue.getMonth(), monthlyRevenue.getOrDefault(revenue.getMonth(), 0.0) + revenue.getAmount());
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            // Create a series for the chart
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName("Revenue for " + selectedYear);

            String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            for (String month : months) {
                Double revenue = monthlyRevenue.get(month);
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
        Map<String, Map<String, Double>> yearlyExpenses = new HashMap<>();


        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DataStore/Expenses.bin"))) {
            yearlyExpenses = (Map<String, Map<String, Double>>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        }

        if (yearlyExpenses.containsKey(year)) {
            Map<String, Double> monthlyExpenses = yearlyExpenses.get(year);
            if (monthlyExpenses.containsKey(month)) {
                expense = monthlyExpenses.get(month);
            }
        }

        return expense;

    }

    private double getRevenue(String year, String month) {
        double revenue = 0;
        List<Revenue> revenueList = new ArrayList<>();


        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DataStore/generateRevenue.bin"))) {
            revenueList = (List<Revenue>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        }

        for (Revenue rev : revenueList) {
            if (String.valueOf(rev.getYear()).equals(year) && rev.getMonth().equalsIgnoreCase(month)) {
                revenue = rev.getAmount();
                break;
            }
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

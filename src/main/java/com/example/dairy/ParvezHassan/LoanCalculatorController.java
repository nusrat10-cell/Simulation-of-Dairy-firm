package com.example.dairy.ParvezHassan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoanCalculatorController {

    @FXML
    private TextField input_Rate;
    @FXML
    private TextField output_Monthly;
    @FXML
    private TextField output_Total;
    @FXML
    private TextField input_Amount;
    @FXML
    private TextField input_Period;
    @FXML
    private TextField output_TotalInterest;

    @FXML
    public void initialize() {
    }



    @FXML
    public void calculate_Button(ActionEvent actionEvent) {
        try {
            double amount = Double.parseDouble(input_Amount.getText());
            double period = Double.parseDouble(input_Period.getText()) * 12;
            double annualRate = Double.parseDouble(input_Rate.getText());
            double monthlyRate = annualRate / 12 / 100;


            double monthlyPayment = (amount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -period));
            double totalPayment = monthlyPayment * period;
            double totalInterest = totalPayment - amount;

            output_Monthly.setText(String.format("%.2f", monthlyPayment));
            output_Total.setText(String.format("%.2f", totalPayment));
            output_TotalInterest.setText(String.format("%.2f", totalInterest));
        } catch (NumberFormatException e) {
            showError("Please enter valid numbers");
        }
    }

    private void showError(String message) {
        System.err.println("Error baby, You messed up.");
    }

    @FXML
    public void reset_Button(ActionEvent actionEvent) {
        input_Amount.clear();
        input_Period.clear();
        input_Rate.clear();
        output_Monthly.clear();
        output_Total.clear();
        output_TotalInterest.clear();
    }
}

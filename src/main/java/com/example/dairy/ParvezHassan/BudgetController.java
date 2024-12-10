package com.example.dairy.ParvezHassan;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import com.example.milestone3.BudgetItem;

import java.io.*;

import static com.example.milestone3.DataStore.populateTransactionList;

public class BudgetController
{
    @javafx.fxml.FXML
    private TableColumn<BudgetItem, Double> allocationCol;
    @javafx.fxml.FXML
    private TableColumn<BudgetItem, Double> amountCol;
    @javafx.fxml.FXML
    private TextField laborBudget_TF;
    @javafx.fxml.FXML
    private TextField processingBudget_TF;
    @javafx.fxml.FXML
    private TextArea remaining_TA;
    @javafx.fxml.FXML
    private TableView<BudgetItem> budgetTV;
    @javafx.fxml.FXML
    private TextField developementBudget_TF;
    @javafx.fxml.FXML
    private TextField transportationBudget_TF;
    @javafx.fxml.FXML
    private TableColumn<BudgetItem, String> nameCol;
    @javafx.fxml.FXML
    private TextField utilitiesBudget_TF;
    @javafx.fxml.FXML
    private TextField operationsBudget_TF;
    @javafx.fxml.FXML
    private TextField marketingBudget_TF;
    @javafx.fxml.FXML
    private TextField totalBudget_TF;
    @javafx.fxml.FXML
    private Label error_label;

    double totalExpense= 0;
    double totalBudget= 0;
    double remaining=0;

    public ObservableList<BudgetItem> budgetItems = FXCollections.observableArrayList();

    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Oopsie!!");
        alert.setContentText(message);
        alert.showAndWait();
    }


    @javafx.fxml.FXML
    public void initialize() {
        // Set cell value factories for columns
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        allocationCol.setCellValueFactory(new PropertyValueFactory<>("allocation"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));

    }

    @javafx.fxml.FXML
    public void setTotalBudget_button(ActionEvent actionEvent) {
        totalBudget = Double.parseDouble(totalBudget_TF.getText());
    }

    @javafx.fxml.FXML
    public void saveAndshow_button(ActionEvent actionEvent) {
        try {
            double marketing = (Double.parseDouble(marketingBudget_TF.getText()) / 100);
            double operations = (Double.parseDouble(operationsBudget_TF.getText()) / 100);
            double transportations = (Double.parseDouble(transportationBudget_TF.getText()) / 100);
            double development = (Double.parseDouble(developementBudget_TF.getText()) / 100);
            double processing = (Double.parseDouble(processingBudget_TF.getText()) / 100);
            double labor = (Double.parseDouble(laborBudget_TF.getText()) / 100);
            double utility = (Double.parseDouble(utilitiesBudget_TF.getText()) / 100);

            if ((marketing + operations + transportations + development + processing + labor + utility) <= 1) {
//            return totalExpense= (marketing+operations+transportations+development+processing+labor+utility);

//            Amount of each catagory

                Double marketingAmount = totalBudget * marketing;
                Double operationsAmount = totalBudget * operations;
                Double transportationsAmount = totalBudget * transportations;
                Double developmentAmount = totalBudget * development;
                Double processingAmount = totalBudget * processing;
                Double laborAmount = totalBudget * labor;
                Double utilityAmount = totalBudget * utility;

                totalExpense = (marketingAmount + operationsAmount + transportationsAmount + developmentAmount + processingAmount + laborAmount + utilityAmount);
                remaining = (totalBudget - totalExpense);


                budgetItems.setAll(
                        new BudgetItem("Marketing", marketing * 100, marketingAmount),
                        new BudgetItem("Operations", operations * 100, operationsAmount),
                        new BudgetItem("Transportation", transportations * 100, transportationsAmount),
                        new BudgetItem("Development", development * 100, developmentAmount),
                        new BudgetItem("Processing", processing * 100, processingAmount),
                        new BudgetItem("Labor", labor * 100, laborAmount),
                        new BudgetItem("Utilities", utility * 100, utilityAmount)
                );

                // Bind the data to the TableView
                budgetTV.setItems(budgetItems);
                remaining_TA.setText("Total Budget: " + totalBudget + "\n" + "Allocated Budget " + totalExpense + "\n" + "Remaining: " + remaining);

                // Hardcoded file path
//                String filePath = "C:/ProjectDatabase/budgetData.txt"; // Modify this path as needed

                try (BufferedWriter writer = new BufferedWriter(new FileWriter("BudgetData.txt", true))) {
//                    writer.write("Name,Allocation,Amount\n");
                    for (BudgetItem item : budgetItems) {
//                        writer.write(item.getName() + "," + item.getAllocation() + "," + item.getAmount() + "\n");

                        writer.write("name: " + item.getName() + ", Allocation%: " +item.getAllocation() + ", Amount: " + item.getAmount() + "\n" );
                    }
                    System.out.println("Budget data saved");
                    showError("Budget data saved " );
                } catch (IOException e) {
                    showError("Failed to save budget data: " + e.getMessage());
                }

            } else {
                // Handle error: Allocations do not sum to 100%
                error_label.setText("Error: Allocations sum greater than 100%");

            }
        } catch (NumberFormatException e) {
            // Handle FXML loading error
            showError("Input not integer/double");
        }


    }

    @javafx.fxml.FXML
    public void back_button(ActionEvent actionEvent) {
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


    public ObservableList<BudgetItem> getBudgetItems() {
        return budgetItems;}

//    @javafx.fxml.FXML
//    public void showTrans_button(ActionEvent actionEvent) {
//
//        populateTransactionList();
//        String FILE_PATH = "C:/ProjectDatabase/TransactionData.txt"; // Same path as used for saving the file
//        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                // Process each line of the file
//                System.out.println(line);
//                String[] parts = line.split(", ");
//                String name = parts[0].split(": ")[1];
//                String amount = parts[2].split(": ")[1];
//
//                System.out.println(name);
//                System.out.println(amount);;
//            }
//        } catch (IOException e) {
//            System.err.println("Failed to read budget data: " + e.getMessage());
//        }
//
//    }
}
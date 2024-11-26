package com.example.milestone3;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ExpensesController
{
    @javafx.fxml.FXML
    private Label error_label;
    @javafx.fxml.FXML
    private ComboBox<String> itemCatagory1_CB;
//    @javafx.fxml.FXML
//    private TableColumn<Map<String, Object>, LocalDate> dateCol;
//    @javafx.fxml.FXML
//    private TableColumn<Map<String, Object>, Double> amountCol;
    @javafx.fxml.FXML
    private DatePicker expenseDate_DP;
    @javafx.fxml.FXML
    private TextField amountExpense_TF;
//    @javafx.fxml.FXML
//    private TableView<Map<String, Object>> expenseTable;
    @javafx.fxml.FXML
    private ComboBox<String> itemCatagory2_CB;
//    @javafx.fxml.FXML
//    private TableColumn<Map<String, Object>, Double> expenseCatCol;
    @javafx.fxml.FXML
    private TextArea alert_TA;
//    @javafx.fxml.FXML
//    private TableView budgetTV;

    @javafx.fxml.FXML
    private TableView<Map<String, Object>> expenseTable;
    @javafx.fxml.FXML
    private TableColumn<Map<String, Object>, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<Map<String, Object>, String> expenseCatCol;
    @javafx.fxml.FXML
    private TableColumn<Map<String, Object>, Double> amountCol;

    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Login Error");
        alert.setContentText(message);
        alert.showAndWait();
    }


    private static final String FILE_PATH = "C:/BudgetData/budgetData.txt"; // Same path as used for saving the file
    @javafx.fxml.FXML
    private Label isAmount_TF;

    private ObservableList<Map<String, Object>> expenseData = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        itemCatagory1_CB.getItems().addAll("Marketing", "Operations","Transportation","Development","Processing","Labor","Utilities");
        itemCatagory2_CB.getItems().addAll("Marketing", "Operations","Transportation","Development","Processing","Labor","Utilities");

        // Initialize the table columns
        // Initialize the table columns
        dateCol.setCellValueFactory(cellData -> new SimpleObjectProperty<>((LocalDate) cellData.getValue().get("date")));
        expenseCatCol.setCellValueFactory(cellData -> new SimpleObjectProperty<>((String) cellData.getValue().get("category")));
        amountCol.setCellValueFactory(cellData -> new SimpleObjectProperty<>((Double) cellData.getValue().get("amount")));


        // Bind the data to the TableView
        expenseTable.setItems(expenseData);





    }

    @javafx.fxml.FXML
    public void showAllExpense_button(ActionEvent actionEvent) {
        LocalDate date = expenseDate_DP.getValue();
        String expenseCategory = (String) itemCatagory2_CB.getSelectionModel().getSelectedItem();
        double amount = Double.parseDouble(amountExpense_TF.getText());

        // Check the condition
        if (itemCatagory1_CB.getValue().equals(expenseCategory) && amount <= Double.parseDouble(isAmount_TF.getText())) {
            // Create a Map to represent the row data
            Map<String, Object> rowData = new HashMap<>();
            rowData.put("date", date);
            rowData.put("category", expenseCategory);
            rowData.put("amount", amount);

            // Add the new row data to the list
            expenseData.add(rowData);
        } else {
            showError("Amount Exceeds Budget");
        }

    }




    @javafx.fxml.FXML
    public void setTotalBudget_button(ActionEvent actionEvent) {
        String A = itemCatagory1_CB.getSelectionModel().getSelectedItem();





        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line of the file
                System.out.println(line);
                String[] parts = line.split(", ");
                String name = parts[0].split(": ")[1];
                String amount = parts[2].split(": ")[1];

                if (name.equals(A)) {
                    isAmount_TF.setText(amount);
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to read budget data: " + e.getMessage());
        }
    }





    @Deprecated
    public void addToExpense_button(ActionEvent actionEvent) {
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
}
package com.example.dairy.Nupur;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

public class LowStockAlert {

    @javafx.fxml.FXML
    private TableView<lowstockModelClass> lowStockAlertTV;

    @javafx.fxml.FXML
    private TableColumn<lowstockModelClass, String> productNameTC;

    @javafx.fxml.FXML
    private TableColumn<lowstockModelClass, Integer> currentStockTC;

    @javafx.fxml.FXML
    private TableColumn<lowstockModelClass, Integer> minimumStockTC;

    @javafx.fxml.FXML
    private ComboBox<String> selectProductCB;

    @javafx.fxml.FXML
    private ComboBox<String> chooseOptionCB;

    @javafx.fxml.FXML
    private Label label;

    private ObservableList<lowstockModelClass> lowStockData;

    @javafx.fxml.FXML
    public void initialize() {

        productNameTC.setCellValueFactory(new PropertyValueFactory<>("productName"));
        currentStockTC.setCellValueFactory(new PropertyValueFactory<>("currentStock"));
        minimumStockTC.setCellValueFactory(new PropertyValueFactory<>("minimumStock"));


        lowStockData = FXCollections.observableArrayList(
                new lowstockModelClass("Milk", 50, 30),
                new lowstockModelClass("Cheese", 20, 15),
                new lowstockModelClass("Butter", 40, 67),
                new lowstockModelClass("Yogurt", 15, 85),
                new lowstockModelClass("Cream", 5, 50),
                new lowstockModelClass("IceCream", 25, 75),
                new lowstockModelClass("Paneer", 10, 5),
                new lowstockModelClass("Ghee", 20, 6)
                );

        lowStockAlertTV.setItems(lowStockData);


        selectProductCB.setItems(FXCollections.observableArrayList("Milk", "Butter", "Cheese", "Yogurt", "Cream", "Ghee", "Paneer", "IceCream"));
        chooseOptionCB.setItems(FXCollections.observableArrayList("Restock", "Ignore"));
    }

    @javafx.fxml.FXML
    public void confirmButton(ActionEvent actionEvent) {
        label.setText("");


        String selectedProduct = selectProductCB.getValue();
        String selectedOption = chooseOptionCB.getValue();

        if (selectedProduct == null || selectedOption == null) {
            label.setText("Please select both a product and an action!");
            return;
        }


        for (lowstockModelClass item : lowStockData) {
            if (item.getProductName().equals(selectedProduct)) {
                if ("Restock".equals(selectedOption)) {
                    int newStock = item.getCurrentStock() + 20;
                    item.setCurrentStock(newStock);
                    label.setText(selectedProduct + " restocked by 20 units!");
                } else if ("Ignore".equals(selectedOption)) {

                    label.setText("No action taken for " + selectedProduct + ".");
                }
                lowStockAlertTV.refresh();
                return;
            }
        }

        label.setText("Selected product not found!");
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Inventory Manager Dashboard.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            // Handle FXML loading error
            e.printStackTrace();
        }
    }


}

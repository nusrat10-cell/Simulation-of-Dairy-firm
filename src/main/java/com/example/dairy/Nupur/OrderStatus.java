package com.example.dairy.Nupur;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class OrderStatus {

    @FXML
    private Label statuslabel;

    private ObservableList<trackOrderClass> orderList = FXCollections.observableArrayList();
    @FXML
    private TableColumn<trackOrderClass, LocalDate> orderdateTC;
    @FXML
    private TableColumn<trackOrderClass, String> nameTC;
    @FXML
    private TableColumn<trackOrderClass, String> statusTC;
    @FXML
    private TableColumn<trackOrderClass, Integer> orderIdTC;
    @FXML
    private TableColumn<trackOrderClass, Integer> quantityTC;
    @FXML
    private ComboBox<String> updateStatusCB;
    @FXML
    private TableView<trackOrderClass> ordersTableView;

    @FXML
    public void initialize() {
        updateStatusCB.getItems().addAll("Pending", "Shipped", "Delivered");


        orderIdTC.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getOrderID()).asObject());
        orderdateTC.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDate()));
        nameTC.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProductName()));
        statusTC.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStatus()));
        quantityTC.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getQuantity()).asObject());


        loadSampleData();
        ordersTableView.setItems(orderList);
    }

    @FXML
    public void backButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("customer representative dashboard.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void updateStatusButton(ActionEvent actionEvent) {
        trackOrderClass selectedOrder = ordersTableView.getSelectionModel().getSelectedItem();
        String newStatus = updateStatusCB.getValue();

        if (selectedOrder == null || newStatus == null) {
            showAlert(Alert.AlertType.WARNING, "Input Error", "Please select an order and status.");
            return;
        }

        selectedOrder.setStatus(newStatus);
        ordersTableView.refresh();
        statuslabel.setText("Order status updated successfully.");
    }

    private void loadSampleData() {
        orderList.addAll(
                new trackOrderClass("Milk", "Pending", LocalDate.of(2024, 12, 10), 10, 1),
                new trackOrderClass("Butter", "Shipped", LocalDate.of(2024, 12, 11), 5, 2),
                new trackOrderClass("Cheese", "Delivered", LocalDate.of(2024, 12, 12), 7, 3),
                new trackOrderClass("Cream", "Pending", LocalDate.of(2024, 12, 12), 12, 4),
                new trackOrderClass("Ice Cream", "Shipped", LocalDate.of(2024, 12, 13), 34, 5),
                new trackOrderClass("Yogurt", "Delivered", LocalDate.of(2024, 12, 12), 21, 6)
        );
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

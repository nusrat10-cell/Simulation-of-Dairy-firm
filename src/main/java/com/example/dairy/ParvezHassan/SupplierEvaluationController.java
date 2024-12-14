package com.example.dairy.ParvezHassan;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class SupplierEvaluationController
{
    @javafx.fxml.FXML
    private ComboBox<String> selectSupplier_CB;

    @javafx.fxml.FXML
    private TableView<OrderToSupplier> supplierDetails_TableView;
    @javafx.fxml.FXML
    private TableColumn<OrderToSupplier, Integer> orderedQuantity_Col;
    @javafx.fxml.FXML
    private TableColumn<OrderToSupplier, String> itemName_Col;
    @javafx.fxml.FXML
    private TableColumn<OrderToSupplier, Integer> deliveredQuantity_Col;
    @javafx.fxml.FXML
    private TableColumn<OrderToSupplier, LocalDate> orderDate_Col;
    @javafx.fxml.FXML
    private TableColumn<OrderToSupplier, String> supplierName_Col;
    @javafx.fxml.FXML
    private TableColumn<OrderToSupplier, String> delays_Col; //Lambda expression
    @javafx.fxml.FXML
    private TableColumn<OrderToSupplier, String> deficit_Col; //Lambda Expression
    @javafx.fxml.FXML
    private TableColumn<OrderToSupplier, LocalDate> deliveryDate_Col;

    @javafx.fxml.FXML
    private Label totalDelivere_label;
    @javafx.fxml.FXML
    private Label TotalOrder_label;
    @javafx.fxml.FXML
    private Label highestTime_label;
    @javafx.fxml.FXML
    private Label lowestTime_label;
    @javafx.fxml.FXML
    private Label averageTime_Label;
    @javafx.fxml.FXML
    private BarChart barChart;
    @javafx.fxml.FXML
    private PieChart pieChart;

    @javafx.fxml.FXML
    public void initialize() {
        File file = new File("DataStore/Supplier.bin");
        if (file.exists()){
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
                List<Supplier> suppliers = (List<Supplier>)  ois.readObject();
                for (Supplier supplier : suppliers){
                    selectSupplier_CB.getItems().addAll(supplier.getName());
                }

            } catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }


    }

    @javafx.fxml.FXML
    public void load_Button(ActionEvent actionEvent) {
        String selectedSupplier = selectSupplier_CB.getValue();
        File file = new File("DataStore/PlacedOrderToSupplier.bin");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                List<OrderToSupplier> orders = (List<OrderToSupplier>) ois.readObject();
                List<OrderToSupplier> supplierOrders = orders.stream()
                        .filter(order -> order.getSupplier().equals(selectedSupplier))
                        .collect(Collectors.toList());

                supplierDetails_TableView.getItems().setAll(supplierOrders);

                // Set cell value factories using PropertyValueFactory for standard columns
                orderedQuantity_Col.setCellValueFactory(new PropertyValueFactory<>("quantity"));
                itemName_Col.setCellValueFactory(new PropertyValueFactory<>("itemName"));
                deliveredQuantity_Col.setCellValueFactory(new PropertyValueFactory<>("deliveredQuantity"));
                orderDate_Col.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
                supplierName_Col.setCellValueFactory(new PropertyValueFactory<>("supplier"));
                deliveryDate_Col.setCellValueFactory(new PropertyValueFactory<>("deliveryDate"));

                // Use lambda expressions for custom columns
                delays_Col.setCellValueFactory(data -> new SimpleStringProperty(calculateDelay(data.getValue())));
                deficit_Col.setCellValueFactory(data -> new SimpleStringProperty(calculateDeficit(data.getValue())));

                // Calculate and set label values
                int totalDelivered = supplierOrders.stream().mapToInt(OrderToSupplier::getDeliveredQuantity).sum();
                int totalOrdered = supplierOrders.stream().mapToInt(OrderToSupplier::getQuantity).sum();
                long highestTime = supplierOrders.stream().mapToLong(order -> ChronoUnit.DAYS.between(order.getOrderDate(), order.getDeliveryDate() != null ? order.getDeliveryDate() : order.getOrderDate())).max().orElse(0);
                long lowestTime = supplierOrders.stream().mapToLong(order -> ChronoUnit.DAYS.between(order.getOrderDate(), order.getDeliveryDate() != null ? order.getDeliveryDate() : order.getOrderDate())).min().orElse(0);
                double averageTime = supplierOrders.stream().mapToLong(order -> ChronoUnit.DAYS.between(order.getOrderDate(), order.getDeliveryDate() != null ? order.getDeliveryDate() : order.getOrderDate())).average().orElse(0.0);

                totalDelivere_label.setText(String.valueOf(totalDelivered) + " Units");
                TotalOrder_label.setText(String.valueOf(totalOrdered) + " Units");
                highestTime_label.setText(String.valueOf(highestTime) + " Days");
                lowestTime_label.setText(String.valueOf(lowestTime) + " Days");
                averageTime_Label.setText(String.format("%.2f", averageTime) + " Days");

                pieChart.getData().clear();
                PieChart.Data deliveredData = new PieChart.Data("Delivered", totalDelivered);
                PieChart.Data deficitData = new PieChart.Data("Not Delivered", totalOrdered - totalDelivered);
                pieChart.getData().addAll(deliveredData, deficitData);
                // COLORS
                deliveredData.getNode().setStyle("-fx-pie-color: #90EE90");
                deficitData.getNode().setStyle("-fx-pie-color: #ff0000");

                // Update BarChart
                barChart.getData().clear();
                XYChart.Series<String, Number> series = new XYChart.Series<>();
                series.setName("Delivery Times");

                XYChart.Data<String, Number> highestTimeData = new XYChart.Data<>("Highest Time", highestTime);
                XYChart.Data<String, Number> averageTimeData = new XYChart.Data<>("Average Time", averageTime);
                XYChart.Data<String, Number> lowestTimeData = new XYChart.Data<>("Lowest Time", lowestTime);

                highestTimeData.nodeProperty().addListener((observable, oldValue, newvalue)-> newvalue.setStyle("-fx-bar-fill: #ff0000"));
                averageTimeData.nodeProperty().addListener((observable, oldValue, newvalue)-> newvalue.setStyle("-fx-bar-fill: #90EE90"));
                lowestTimeData.nodeProperty().addListener((observable, oldValue, newvalue)-> newvalue.setStyle("-fx-bar-fill: #0000ff"));



                series.getData().add(highestTimeData);
                series.getData().add(averageTimeData);
                series.getData().add(lowestTimeData);

                barChart.getData().add(series);




            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("File does not exist: " + file.getPath());
        }
    }








    @javafx.fxml.FXML
    public void back_Button(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            // Handle FXML loading error
            e.printStackTrace();
        }
    }

    private String calculateDelay(OrderToSupplier order) {
        if (order.getDeliveryDate() != null) {
            return String.valueOf(ChronoUnit.DAYS.between(order.getOrderDate(), order.getDeliveryDate())) + " days";
        } else {
            return "N/A";
        }
    }

    private String calculateDeficit(OrderToSupplier order) {
        return String.valueOf(order.getQuantity() - order.getDeliveredQuantity());
    }

}
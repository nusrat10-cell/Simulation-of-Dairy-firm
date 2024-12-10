package com.example.Nupur;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ExpiryDates
{
    @javafx.fxml.FXML
    private TableColumn<expiryDateModelClass,String> productNameTC;
    @javafx.fxml.FXML
    private ComboBox<String> selectProductCB;
    @javafx.fxml.FXML
    private TableView<expiryDateModelClass> expiryDateTV;
    @javafx.fxml.FXML
    private TableColumn<expiryDateModelClass,Integer> currentStockTC;
    @javafx.fxml.FXML
    private TableColumn<expiryDateModelClass, LocalDate> expiryDateTC;
    @javafx.fxml.FXML
    private Label label;
    @javafx.fxml.FXML
    private ComboBox<String> chooseActionCB;


    private ObservableList<expiryDateModelClass> productList = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
        productNameTC.setCellValueFactory(new PropertyValueFactory<>("productName"));
        currentStockTC.setCellValueFactory(new PropertyValueFactory<>("currentStock"));
        expiryDateTC.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));


        productList.addAll(
                new expiryDateModelClass("Milk",100,LocalDate.now().plusDays(5)),
                new expiryDateModelClass("Butter",50,LocalDate.now().plusDays(10)),
                new expiryDateModelClass("Yogurt",30,LocalDate.now().plusDays(3)),
                new expiryDateModelClass("Cheese",60,LocalDate.now().plusDays(15)),
                new expiryDateModelClass("Cream",40,LocalDate.now().plusDays(6)),
                new expiryDateModelClass("Ghee",70,LocalDate.now().plusDays(17)),
                new expiryDateModelClass("Paneer",65,LocalDate.now().plusDays(12)),
                new expiryDateModelClass("IceCream",80,LocalDate.now().plusDays(20))
        );
        expiryDateTV.setItems(productList);

        selectProductCB.getItems().addAll("Milk", "Butter", "Cheese", "Yogurt", "Cream", "Ghee","Paneer", "IceCream");
        chooseActionCB.getItems().addAll("Discount","Discard");


    }

//    @javafx.fxml.FXML
//    public void confirmActionButton(ActionEvent actionEvent) {
//        String selectedProduct = selectProductCB.getValue();
//        String selectedAction = chooseActionCB.getValue();
//
//        if (selectedProduct == null || selectedAction == null) {
//            showAlert("Error", "Please select a product and an action.", Alert.AlertType.ERROR);
//            return;
//        }
//
//
//
//    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
    }
}
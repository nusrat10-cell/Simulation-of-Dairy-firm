package com.example.Nupur;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class CustomerInquiries
{
    @javafx.fxml.FXML
    private TableColumn<inquiryClass,String> inquiryTypeTC;
    @javafx.fxml.FXML
    private TableColumn<inquiryClass,String> statusTC;
    @javafx.fxml.FXML
    private TableColumn<inquiryClass,String> customerNameTC;
    @javafx.fxml.FXML
    private TableColumn<inquiryClass,Integer> inquiryidTC;
    @javafx.fxml.FXML
    private TextArea responseTA;
    @javafx.fxml.FXML
    private TableView inquiriesTV;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void sendResponseButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
    }
}
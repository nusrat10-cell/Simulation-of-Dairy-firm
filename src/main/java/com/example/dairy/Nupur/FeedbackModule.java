package com.example.dairy.Nupur;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class FeedbackModule
{
    @javafx.fxml.FXML
    private ComboBox<String> feedbackTypeCB;
    @javafx.fxml.FXML
    private TableColumn<feedbackModelClass,String> feedbackTypeTC;
    @javafx.fxml.FXML
    private TableColumn<feedbackModelClass,String> customerNameTC;
    @javafx.fxml.FXML
    private TextField customerNameTF;
    @javafx.fxml.FXML
    private TextArea feedbackTA;
    @javafx.fxml.FXML
    private TableColumn<feedbackModelClass,String> feedbackTC;
    @javafx.fxml.FXML
    private TableView<feedbackModelClass>feedbackTV;

    private ObservableList<feedbackModelClass> feedbackList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        feedbackTypeTC.setCellValueFactory(new PropertyValueFactory<>("feedbackType"));
        customerNameTC.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        feedbackTC.setCellValueFactory(new PropertyValueFactory<>("feedback"));

        feedbackTypeCB.getItems().addAll("Positive", "Negative", "Neutral");
        feedbackTV.setItems(feedbackList);
    }




    @javafx.fxml.FXML
    public void generateTableButton(ActionEvent actionEvent) {
        String customerName = customerNameTF.getText();
        String feedbackType = feedbackTypeCB.getValue();
        String feedback = feedbackTA.getText();
        if (customerName.isEmpty() || feedbackType == null || feedback.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Input Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill out all fields.");
            alert.showAndWait();
            return;
        }
        feedbackModelClass newFeedback = new feedbackModelClass(customerName, feedback, feedbackType);
        feedbackList.add(newFeedback);

        // Clear input fields
        customerNameTF.clear();
        feedbackTypeCB.setValue(null);
        feedbackTA.clear();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("customer representative dashboard.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            // Handle FXML loading error
            e.printStackTrace();
        }

    }
    }


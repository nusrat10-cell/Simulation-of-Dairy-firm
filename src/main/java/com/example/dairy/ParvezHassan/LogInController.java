package com.example.dairy.ParvezHassan;

import com.example.dairy.Samiul.User7.SalesAndMarketingManager;
import com.example.dairy.Samiul.User7.SalesDashboard;
import com.example.dairy.Samiul.User8.Customer;
import com.example.dairy.Samiul.User8.CustomerDashboard;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class LogInController {
    @javafx.fxml.FXML
    private TextField userID_textField;
    @javafx.fxml.FXML
    private ComboBox<String> designation_ComboBox;
    @javafx.fxml.FXML
    private PasswordField pass_textField;

    SalesAndMarketingManager salesAndMarketingManager ;
    Customer customer;

    @javafx.fxml.FXML
    public void initialize() {
        designation_ComboBox.getItems().addAll("Milk Collector", "Milk Processor", "Inventory Manager", "Customer Service Representative", "Supply Chain & Logistics", "Financial Manager", "Sales & Marketing Manager", "Customer");
        salesAndMarketingManager = new SalesAndMarketingManager(11111, "Rayhan", "fewf@gmail.com", "01622729101", "1234");
        customer = new Customer(2, "John", "sasasa@gmail.com", "0838384", "1234");
    }
    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Login Error");
        alert.setContentText(message);
        alert.showAndWait();
    }


    @javafx.fxml.FXML
    public void logIn_button(ActionEvent actionEvent) {
        try {
            String password = pass_textField.getText();
            String userID = userID_textField.getText(); // Read user ID as String
            String designation = designation_ComboBox.getSelectionModel().getSelectedItem();
            boolean verified = false;



//            DEBUG
            System.out.println("UserID " + userID);
            System.out.println("Password: " +password);
            System.out.println("Designation " +designation);


            List<User> users = new ArrayList<>();
            File file = new File("DataStore/UserData.bin");
            if (file.exists()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                    users = (List<User>) ois.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                    showError("Unable to read user data.");
                    return;
                }
            }

            for (User user : users) {
//                DEBUG
                System.out.println("StoredID: " + user.getUserID());
                System.out.println("StoredPassword: " +user.getPassword());
                System.out.println("StoredDesignation: " +user.getDesignation());

                if (String.valueOf(user.getUserID()).equals(userID) && user.getPassword().equals(password) && user.getDesignation().equals(designation)) {
                    verified = true;
                    break;
                }
            }

            if (verified) {

                Parent root = null;
                switch (designation) {
                    case "Supply Chain & Logistics":
                        root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                        break;
                    case "Financial Manager":
                        root = FXMLLoader.load(getClass().getResource("Dashboard2.fxml"));
                        break;
                    case "Sales & Marketing Manager": //1,1
                        root = FXMLLoader.load(getClass().getResource("/com/example/dairy/Samiul/User7/salesAndMarketingManagerDashboard.fxml"));
                        break;
                    case "Customer": //2,2
                        root = FXMLLoader.load(getClass().getResource("/com/example/dairy/Samiul/User8/customerDashboard.fxml"));
                        break;
                    case "Milk Collector": //1234,1234
                        root = FXMLLoader.load(getClass().getResource("/com/example/dairy/mahamud/Milk Collector.fxml"));
                        break;
                    default:
                        showError("Invalid designation.");
                        return;
                }
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } else {
                showError("Invalid credentials. Please try again.");
            }
        } catch (NumberFormatException e) {
            showError("User ID must be a number.");
        } catch (IOException e) {
            e.printStackTrace();
            showError("Unable to load the next page.");
        }
    }



    @javafx.fxml.FXML
    public void createNewUser_Button(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AddUser.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            // Handle FXML loading error
            e.printStackTrace();


        }
    }
}


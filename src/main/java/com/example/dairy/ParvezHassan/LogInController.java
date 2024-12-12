package com.example.dairy.ParvezHassan;

import com.example.dairy.Samiul.User7.AnalyzeSalesPerformance;
import com.example.dairy.Samiul.User7.SalesAndMarketingManager;
import com.example.dairy.Samiul.User7.SalesDashboard;
import com.example.dairy.Samiul.User8.CustomerDashboard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.EventObject;

public class LogInController {
    @javafx.fxml.FXML
    private TextField userID_textField;
    @javafx.fxml.FXML
    private ComboBox<String> designation_ComboBox;
    @javafx.fxml.FXML
    private PasswordField pass_textField;

    SalesAndMarketingManager salesAndMarketingManager ;

    @javafx.fxml.FXML
    public void initialize() {
        designation_ComboBox.getItems().addAll("Milk Collector", "Milk Processor", "Inventory Manager", "Customer Service Representative", "Supply Chain & Logistics", "Financial Manager", "Sales & Marketing Manager", "Customer");
        salesAndMarketingManager = new SalesAndMarketingManager(11111, "Rayhan", "fewf@gmail.com", "01622729101", "1234");
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
            int userID = Integer.parseInt(userID_textField.getText());
            String designation = designation_ComboBox.getSelectionModel().getSelectedItem();
            boolean verified = false;
//        VERIFICATION
            if (userID == 1234 && password.equals("1234") && designation.equals("Supply Chain & Logistics")){
                // Load Page 2
                Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
                verified =true;
            } if ((userID== 1234 && password.equals("12345") && designation.equals("Financial Manager"))) {
                // Load Page 2
                Parent root = FXMLLoader.load(getClass().getResource("Dashboard2.fxml"));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
                verified =true;

            }if (userID == 11111 && password.equals("1234") && designation.equals("Sales & Marketing Manager")){
                // Load Page 2
                Parent root = null ;
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com.example.dairy/Samiul/User7/sales and marketing manager dashboard.fxml"));
                root = fxmlLoader.load() ;

                SalesDashboard adc = fxmlLoader.getController() ;
                adc.setter(this.salesAndMarketingManager);

                Scene scene = new Scene(root) ;
                Stage stage = (Stage)(((Node) actionEvent.getSource()).getScene().getWindow());
                stage.setScene(scene);
                stage.show();
                verified =true;
            } if ((userID== 1234 && password.equals("12345") && designation.equals("Customer"))) {
                // Load Page 2
                Parent root = null ;
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com.example.dairy/Samiul/User7/customer dashboard.fxml"));
                root = fxmlLoader.load() ;

                CustomerDashboard adc = fxmlLoader.getController() ;
                // adc.setter(this.user);

                Scene scene = new Scene(root) ;
                Stage stage = (Stage)(((Node) actionEvent.getSource()).getScene().getWindow());
                stage.setScene(scene);
                stage.show();
                verified =true;

            }
            if (userID == 1234 && password.equals("1234") && designation.equals("Milk Collector")){
                // Load Page 2
                Parent root = FXMLLoader.load(getClass().getResource("/com.example.dairy/mahamud/Milk Collector.fxml"));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
                verified =true;}
            if (!verified) {
                // Show error message
                showError("Invalid credentials. Please try again.");
            }
        } catch (NumberFormatException e) {
            // Handle invalid integer input
            showError("User ID must be a number.");
        } catch (IOException e) {
            // Handle FXML loading error
            e.printStackTrace();
            showError("Unable to load the next page.");
        }
    }


}


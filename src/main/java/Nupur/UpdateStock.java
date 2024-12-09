package Nupur;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class UpdateStock
{
    @javafx.fxml.FXML
    private DatePicker deliveryDateDP;
    @javafx.fxml.FXML
    private TextField batchNumberTF;
    @javafx.fxml.FXML
    private Label errorMessageLabel;
    @javafx.fxml.FXML
    private TextField productNameTF;
    @javafx.fxml.FXML
    private DatePicker expiryDateDP;
    @javafx.fxml.FXML
    private TextField receivedQuantityTF;
    @javafx.fxml.FXML
    private ComboBox<String> storageLocationCB;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
    }
}
package Nupur;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class ExpiryDates
{
    @javafx.fxml.FXML
    private TableColumn<expiryDateModelClass,String> productNameTC;
    @javafx.fxml.FXML
    private ComboBox<String> selectProductCB;
    @javafx.fxml.FXML
    private TableView expiryDateTV;
    @javafx.fxml.FXML
    private TableColumn<expiryDateModelClass,Integer> currentStockTC;
    @javafx.fxml.FXML
    private TableColumn<expiryDateModelClass, LocalDate> expiryDateTC;
    @javafx.fxml.FXML
    private Label label;
    @javafx.fxml.FXML
    private ComboBox<String> chooseActionCB;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void confirmActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
    }
}
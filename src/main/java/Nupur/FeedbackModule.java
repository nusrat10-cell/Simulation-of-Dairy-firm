package Nupur;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

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
    private TableView feedbackTV;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateTableButton(ActionEvent actionEvent) {
    }
}
package Nupur;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CustomerComplaints
{

    @javafx.fxml.FXML
    private TableColumn<complaintsClass,String> productTC;
    @javafx.fxml.FXML
    private TableView complaintsTV;
    @javafx.fxml.FXML
    private TableColumn<complaintsClass,String> customernameTC;
    @javafx.fxml.FXML
    private TableColumn<complaintsClass,String> complaintsTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void backbutton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
    }
}
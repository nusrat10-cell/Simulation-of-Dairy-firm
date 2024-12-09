package Nupur;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ManageDispatchRequest
{
    @javafx.fxml.FXML
    private DatePicker dispatchDateDP;
    @javafx.fxml.FXML
    private ComboBox<String> selectProductsCB;
    @javafx.fxml.FXML
    private TableColumn<productDispatchmodelClass,String> productNameTC;
    @javafx.fxml.FXML
    private TableView dispatchTV;
    @javafx.fxml.FXML
    private TableColumn<productDispatchmodelClass,String> destinationTC;
    @javafx.fxml.FXML
    private TableColumn<productDispatchmodelClass,Integer> quantityTC;
    @javafx.fxml.FXML
    private ComboBox<String> logisticProviderCB;
    @javafx.fxml.FXML
    private TableColumn<productDispatchmodelClass,Integer>requestidTC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void processButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void dispatchButton(ActionEvent actionEvent) {
    }
}
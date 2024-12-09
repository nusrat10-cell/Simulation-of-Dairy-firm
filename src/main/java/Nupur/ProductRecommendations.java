package Nupur;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ProductRecommendations
{
    @javafx.fxml.FXML
    private TableView productREcommandationTV;
    @javafx.fxml.FXML
    private TableColumn<productRecommandationClass,String> productTypeTC;
    @javafx.fxml.FXML
    private TableColumn<productRecommandationClass,Integer> purchaseQuantityTC;
    @javafx.fxml.FXML
    private TableColumn<productRecommandationClass,String> customerNameTC;
    @javafx.fxml.FXML
    private TextField customerNameTF;
    @javafx.fxml.FXML
    private TextField idTF;

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
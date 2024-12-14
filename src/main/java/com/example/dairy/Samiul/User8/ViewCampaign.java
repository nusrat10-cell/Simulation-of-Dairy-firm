package com.example.dairy.Samiul.User8;

import com.example.dairy.Samiul.User7.CampaignClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ViewCampaign
{
    Customer user;
    @javafx.fxml.FXML
    private TableColumn<CampaignClass, String> statusTableview;
    @javafx.fxml.FXML
    private DatePicker endDatePicker;
    @javafx.fxml.FXML
    private TableColumn<CampaignClass, String> dateTableview;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private TableColumn<CampaignClass, String> nameTableview;
    @javafx.fxml.FXML
    private TableView<CampaignClass> viewCampaignTable;
    @javafx.fxml.FXML
    private TableColumn<CampaignClass, String> venueTableview;


    ObservableList<CampaignClass> campaignClasses = FXCollections.observableArrayList();


    public void setter (Customer customer){

        this.user = customer;
        show();
    }
    @javafx.fxml.FXML
    public void initialize() {
        nameTableview.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateTableview.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        venueTableview.setCellValueFactory(new PropertyValueFactory<>("venueLocation"));
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/dairy/Samiul/User8/customerDashboard.fxml"));
        root = fxmlLoader.load() ;

        CustomerDashboard adc = fxmlLoader.getController() ;
        adc.setter(this.user);

        Scene scene = new Scene(root) ;
        Stage stage = (Stage)(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }


    public ObservableList<CampaignClass> campaignFileRead() {
        ObservableList<CampaignClass> campaign = FXCollections.observableArrayList() ;

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("CampaignData.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            CampaignClass st ;
            try {
                while(true){
                    st = (CampaignClass) ois.readObject();
                    System.out.println((st));
                    campaign.add(st) ;
                }
            }//end of nested try
            catch(Exception e){
                // handling code
            }//nested catch
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }

        return campaign ;
    }
    public void show() {

        viewCampaignTable.setItems(campaignClasses);
        campaignClasses= campaignFileRead();

    }

    @javafx.fxml.FXML
    public void filterButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void showCampaignButton(ActionEvent actionEvent) {
        show();
    }
}
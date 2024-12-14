package com.example.dairy.Samiul.User7;

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;

public class CampaignManagement
{
    SalesAndMarketingManager user;
    @javafx.fxml.FXML
    private TableColumn<CampaignClass, Integer> idTableview;
    @javafx.fxml.FXML
    private TableColumn<CampaignClass, String> statusTableview;
    @javafx.fxml.FXML
    private TextField venueLocationTF;
    @javafx.fxml.FXML
    private TextField campaignNameTF;
    @javafx.fxml.FXML
    private TextField budgetAllocatedTF;
    @javafx.fxml.FXML
    private TableColumn<CampaignClass, String> dateTableview;
    @javafx.fxml.FXML
    private DatePicker startDatePicker;
    @javafx.fxml.FXML
    private DatePicker ednDatePicker;
    @javafx.fxml.FXML
    private TableColumn<CampaignClass, String> nameTableview;
    @javafx.fxml.FXML
    private TableColumn<CampaignClass, Integer> budgetTableview;
    @javafx.fxml.FXML
    private TableColumn<CampaignClass, String> venueTableview;
    @javafx.fxml.FXML
    private TableView<CampaignClass> campaignTable;

    ObservableList<CampaignClass> campaignClasses = FXCollections.observableArrayList();

    public void setter (SalesAndMarketingManager manager){
        this.user = manager;
        show();
    }
    @javafx.fxml.FXML
    public void initialize() {
        idTableview.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTableview.setCellValueFactory(new PropertyValueFactory<>("name"));
        budgetTableview.setCellValueFactory(new PropertyValueFactory<>("budget"));
        venueTableview.setCellValueFactory(new PropertyValueFactory<>("venueLocation"));
        dateTableview.setCellValueFactory(new PropertyValueFactory<>("startDate"));

    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        Parent root = null ;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/dairy/Samiul/User7/salesAndMarketingManagerDashboard.fxml"));
        root = fxmlLoader.load() ;

        SalesDashboard adc = fxmlLoader.getController() ;
        adc.setter(this.user);

        Scene scene = new Scene(root) ;
        Stage stage = (Stage)(((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void createCampaignButton(ActionEvent actionEvent) {
        String venueLocation = venueLocationTF.getText();
        String campaignName = campaignNameTF.getText();
        int budget = Integer.parseInt(budgetAllocatedTF.getText());
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = ednDatePicker.getValue();


        CampaignClass campaign = new CampaignClass( campaignName, startDate, endDate, venueLocation, budget );

        //campaignClasses.add(campaign);
        campaignFileWrite(campaign);
        show();
    }

    public void campaignFileWrite(CampaignClass campaign) {
        System.out.println(campaign);
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("CampaignData.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new mainpkg.project.AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(campaign);

        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
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
        campaignTable.setItems(campaignClasses);
        campaignClasses= campaignFileRead();

    }
}
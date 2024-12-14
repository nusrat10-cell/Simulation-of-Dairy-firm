package com.example.dairy.Samiul.User7;

import com.example.dairy.Samiul.User8.OrderClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class IncomeManagement
{
    SalesAndMarketingManager user;
    @javafx.fxml.FXML
    private Label totalSalesLabel;
    @javafx.fxml.FXML
    private Label campaignCostLabel;
    @javafx.fxml.FXML
    private Label profitLabel;

    public void setter (SalesAndMarketingManager manager){
        this.user = manager;
    }

    ObservableList<OrderClass> sales = FXCollections.observableArrayList();
    ObservableList<CampaignClass> campaign = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    public void initialize() {

        sales= salesFileRead();
        campaign= campaignFileRead();

        int totalPrice=0;
        int campaignPrice=0;

        for (OrderClass o: sales){
            totalPrice+= (o.getPrice() * o.getQuantity());


        }

        for (CampaignClass camp: campaign){
            campaignPrice+= camp.getBudget();

        }

        int profit= totalPrice-campaignPrice;
        profitLabel.setText(Integer.toString(profit));
        totalSalesLabel.setText(Integer.toString(totalPrice));
        campaignCostLabel.setText(Integer.toString(campaignPrice));



    }

    public ObservableList<OrderClass> salesFileRead() {
        ObservableList<OrderClass> sales = FXCollections.observableArrayList() ;

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("OrderData.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            OrderClass st ;
            try {
                while(true){
                    st = (OrderClass) ois.readObject();
                    System.out.println((st));
                    sales.add(st) ;
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

        return sales ;
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
}
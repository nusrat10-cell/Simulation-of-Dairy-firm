package com.example.dairy.Samiul.User7;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ReportProblem
{
    SalesAndMarketingManager user;
    @javafx.fxml.FXML
    private TextField reportTopicTF;
    @javafx.fxml.FXML
    private TextField describeProblemTF;



    public void setter (SalesAndMarketingManager manager){
        this.user = manager;
    }
    @javafx.fxml.FXML
    public void initialize() {
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

    public void reportFileWrite(ReportClass report) {
        System.out.println(report);
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("ReportDataManager.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new mainpkg.project.AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(report);

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

    @javafx.fxml.FXML
    public void sendReportButton(ActionEvent actionEvent) {

        String reportTopic = reportTopicTF.getText();
        String reportDescription = describeProblemTF.getText();

        ReportClass report= new ReportClass(reportTopic, reportDescription );
        reportFileWrite(report);





    }
}
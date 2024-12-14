package com.example.dairy;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


<<<<<<< HEAD
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/dairy/Nupur/OrderStatus.fxml"));

        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/dairy/ParvezHassan/LogIn.fxml"));
=======
       // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/dairy/mahamud/Milk Processor.fxml"));

        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Nupur/Manage Dispatch Request.fxml"));

        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/dairy/mahamud/Payment Management.fxml"));



       // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Nupur/Manage inventory level.fxml"));



      //  FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Nupur/Inventory Manager Dashboard.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ParvezHassan/LogIn.fxml"));



        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/dairy/ParvezHassan/LogIn.fxml"));

        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/dairy/ParvezHassan/LogIn.fxml"));

>>>>>>> e3dda8649ee0b527c6dcb8433ed2b20a32b6eabd


        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

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

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Nupur/Update Stock.fxml"));

        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/dairy/mahamud/Payment Management.fxml"));
=======
<<<<<<< HEAD
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/dairy/mahamud/Fresh milk .fxml"));
=======
<<<<<<< HEAD
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Nupur/Manage Dispatch Request.fxml"));
=======
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/dairy/mahamud/Payment Management.fxml"));
>>>>>>> 3d1363a492e4bf1d7162d9ad4a0dc13379db2aea
>>>>>>> 3e6ba684b13b57c0dd1a75d2f23553f3cec95e83


       // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Nupur/Manage inventory level.fxml"));


        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/dairy/ParvezHassan/LogIn.fxml"));


        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

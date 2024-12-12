package com.example.dairy.ParvezHassan;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Arrays;

public class revenueList extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Revenue.generatepopulateRevenue(Arrays.asList(
                new Revenue("January", 2024, 700000),
                new Revenue("February", 2024, 900000),
                new Revenue("March", 2024, 850000),
                new Revenue("April", 2024, 750000),
                new Revenue("May", 2024, 690000),
                new Revenue("June", 2024, 680000),
                new Revenue("July", 2024, 710000),
                new Revenue("August", 2024, 750000),
                new Revenue("September", 2024, 730000),
                new Revenue("October", 2024, 800000),
                new Revenue("November", 2024, 810000),
                new Revenue("December", 2024, 660000)
                ,
                new Revenue("January", 2025, 690000),
                new Revenue("February", 2025, 650000),
                new Revenue("March", 2025, 430000),
                new Revenue("April", 2025, 690000),
                new Revenue("May", 2025, 750000),
                new Revenue("June", 2025, 780000),
                new Revenue("July", 2025, 760000),
                new Revenue("August", 2025, 730000),
                new Revenue("September", 2025, 730000),
                new Revenue("October", 2025, 790000),
                new Revenue("November", 2025, 800000),
                new Revenue("December", 2025, 900000)
        ));


    }
}

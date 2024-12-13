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
        Supplier.pupulateSupplier(Arrays.asList(
                new Supplier(101,"Rahim and Sons Dairy","01928682961","77, Bashabo, Dhaka-1214"),
                new Supplier(102,"Mustang Meadows","01928682961","77, Bashabo, Dhaka-1214"),
                new Supplier(103,"Blue Sky Ranch","01928682961","77, Bashabo, Dhaka-1214"),
                new Supplier(106,"Abdullah Goat House","01928682961","77, Bashabo, Dhaka-1214"),
                new Supplier(104,"Tanisha Processing House","01928682961","77, Bashabo, Dhaka-1214"),
                new Supplier(107,"Adib's Milk Processing","01928682961","77, Bashabo, Dhaka-1214"),
                new Supplier(108,"Cheese Maker Saif","01928682961","77, Bashabo, Dhaka-1214"),
                new Supplier(109,"Roger's Packaging","01928682961","77, Bashabo, Dhaka-1214"),
                new Supplier(105,"Sumaiya Bottling & Co.","01928682961","77, Bashabo, Dhaka-1214"),
                new Supplier(200,"Samsung Dairy Equipments","01928682961","77, Bashabo, Dhaka-1214")
        ));


    }
}

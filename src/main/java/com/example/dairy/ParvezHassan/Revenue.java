package com.example.dairy.ParvezHassan;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Revenue implements Serializable {
    String month;
    int year;
    double amount;

    public Revenue(String month, int year, double amount) {
        this.month = month;
        this.year = year;
        this.amount = amount;
    }

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public double getAmount() {
        return amount;
    }

    public static void generatepopulateRevenue(List<Revenue> newRevenues) {
        List<Revenue> revenues = new ArrayList<>();

        // Read existing revenues from file, if any
        File file = new File("DataStore/generateRevenue.bin");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                revenues = (List<Revenue>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        // Append new revenues
        revenues.addAll(newRevenues);

        // Write updated revenues to file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(revenues);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    }



package com.example.dairy.Samiul.User7;

import java.time.LocalDate;
import java.util.Random;

public class InhouseOrderClass {
    String name;
    int quantity;
    LocalDate date;
    int id;



    public InhouseOrderClass(String name, int quantity, LocalDate date) {
        this.name = name;
        this.quantity = quantity;
        this.date = date;
        this.id = generateId();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "InhouseOrderClass{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", date=" + date +
                ", id=" + id +
                '}';
    }

    private int generateId() {
        Random rand = new Random();
        int id = rand.nextInt(1000, 9999);
        return id;
    }
}

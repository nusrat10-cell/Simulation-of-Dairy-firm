package com.example.dairy.Samiul.User8;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class OrderClass implements Serializable {
    int id;
    String name;
    int quantity;
    LocalDate deliveryDate;
    int price;

    public OrderClass(String name, int quantity, LocalDate deliveryDate, int price ) {
        this.name = name;
        this.quantity = quantity;
        this.deliveryDate = deliveryDate;
        this.price = price;
        this.id = generateId();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String toString() {
        return "OrderClass{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", deliveryDate=" + deliveryDate +
                ", price=" + price +
                '}';
    }

    private int generateId(){
        Random rand = new Random();
        int id = rand.nextInt(1000, 9999);
        return id;

    }
}

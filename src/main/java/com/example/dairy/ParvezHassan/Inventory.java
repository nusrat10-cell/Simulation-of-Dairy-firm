package com.example.dairy.ParvezHassan;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.Serializable;

public class Inventory implements Serializable{
    String product_name;
    int product_price;
    int product_stockLevel;
    String product_type;



    public Inventory(String product_name, int product_price, int product_stockLevel, String product_type) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_stockLevel = product_stockLevel;
        this.product_type = product_type;
    }

// Getter and Setter
    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public int getProduct_stockLevel() {
        return product_stockLevel;
    }

    public void setProduct_stockLevel(int product_stockLevel) {
        this.product_stockLevel = product_stockLevel;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "name='" + product_name + '\'' +
                ", priceperUnit=" + product_price +
                ", stockLevel=" + product_stockLevel +
                ", type='" + product_type + '\'' +
                '}';
    }

}



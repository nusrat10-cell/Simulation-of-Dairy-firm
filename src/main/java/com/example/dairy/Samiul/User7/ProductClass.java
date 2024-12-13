package com.example.dairy.Samiul.User7;

public class ProductClass {

    String name;
    int price;
    int remainingStock;
    int upcomingStock;
    String description;

    public ProductClass(String name, int price, int remainingStock, int upcomingStock, String description ) {
        this.name = name;
        this.price = price;
        this.remainingStock = remainingStock;
        this.upcomingStock = upcomingStock;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRemainingStock() {
        return remainingStock;
    }

    public void setRemainingStock(int remainingStock) {
        this.remainingStock = remainingStock;
    }

    public int getUpcomingStock() {
        return upcomingStock;
    }

    public void setUpcomingStock(int upcomingStock) {
        this.upcomingStock = upcomingStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductClass{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", remainingStock=" + remainingStock +
                ", upcomingStock=" + upcomingStock +
                ", description='" + description + '\'' +
                '}';
    }
}

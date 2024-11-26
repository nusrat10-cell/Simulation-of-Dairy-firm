package com.example.milestone3;

public class Inventory {
    String name;
    int unit;
    int priceperUnit;
    int stockLevel;
    String type;

    public Inventory(String name, int unit, int priceperUnit, int stockLevel, String type) {
        this.name = name;
        this.unit = unit;
        this.priceperUnit = priceperUnit;
        this.stockLevel = stockLevel;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getPriceperUnit() {
        return priceperUnit;
    }

    public void setPriceperUnit(int priceperUnit) {
        this.priceperUnit = priceperUnit;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "name='" + name + '\'' +
                ", unit=" + unit +
                ", priceperUnit=" + priceperUnit +
                ", stockLevel=" + stockLevel +
                ", type='" + type + '\'' +
                '}';
    }
}

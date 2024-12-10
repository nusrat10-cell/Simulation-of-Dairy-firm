package com.example.dairy.mahamud;

public class quantityModelClass {
    private int id;
    private String name;
    private int Quantity;

    public quantityModelClass(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        Quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    @Override
    public String toString() {
        return "quantityModelClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Quantity=" + Quantity +
                '}';
    }
}

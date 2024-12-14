package com.example.dairy.mahamud;

public class ProductionRecordModel {
    private String typeOfQuantity;
    private int quantity;
    private String wastage;

    public ProductionRecordModel(String typeOfQuantity, int quantity, String wastage) {
        this.typeOfQuantity = typeOfQuantity;
        this.quantity = quantity;
        this.wastage = wastage;
    }

    public String getTypeOfQuantity() {
        return typeOfQuantity;
    }

    public void setTypeOfQuantity(String typeOfQuantity) {
        this.typeOfQuantity = typeOfQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getWastage() {
        return wastage;
    }

    public void setWastage(String wastage) {
        this.wastage = wastage;
    }
}

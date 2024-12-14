package com.example.dairy.mahamud;

public class SeperationData {
    private String milkComponent;
    private String milkType;
    private double quantity;

    public SeperationData(String milkComponent, String milkType, double quantity) {
        this.milkComponent = milkComponent;
        this.milkType = milkType;
        this.quantity = quantity;
    }

    public String getMilkComponent() {
        return milkComponent;
    }

    public void setMilkComponent(String milkComponent) {
        this.milkComponent = milkComponent;
    }

    public String getMilkType() {
        return milkType;
    }

    public void setMilkType(String milkType) {
        this.milkType = milkType;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SeperationData{" +
                "milkComponent='" + milkComponent + '\'' +
                ", milkType='" + milkType + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

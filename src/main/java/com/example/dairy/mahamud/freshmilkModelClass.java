package com.example.dairy.mahamud;

public class freshmilkModelClass {
    private double quantity;
    private  double tempareture;

    public freshmilkModelClass(double quantity, double tempareture) {
        this.quantity = quantity;
        this.tempareture = tempareture;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getTempareture() {
        return tempareture;
    }

    public void setTempareture(double tempareture) {
        this.tempareture = tempareture;
    }

    @Override
    public String toString() {
        return "freshmilkModelClass{" +
                "quantity=" + quantity +
                ", tempareture=" + tempareture +
                '}';
    }
}

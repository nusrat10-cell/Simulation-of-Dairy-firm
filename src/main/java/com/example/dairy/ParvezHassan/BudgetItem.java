package com.example.dairy.ParvezHassan;

import java.io.Serializable;

public class BudgetItem implements Serializable {
    private String name;
    private double allocation;
    private double amount;

    public BudgetItem(String name, double allocation, double amount) {
        this.name = name;
        this.allocation = allocation;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAllocation() {
        return allocation;
    }

    public double getAmount() {
        return amount;
    }
}

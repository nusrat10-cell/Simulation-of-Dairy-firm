package com.example.dairy.ParvezHassan;

public class BudgetItem {
    private final String name;
    private final double allocation;
    private final double amount;

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



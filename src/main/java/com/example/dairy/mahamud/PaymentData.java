package com.example.dairy.mahamud;

import java.time.LocalDate;

public class PaymentData {
    private String name;
    private double amount;
    private LocalDate date;

    public PaymentData(String name, double amount, LocalDate date) {
        this.name = name;
        this.amount = amount;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PaymentData{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
package com.example.milestone3;

import java.time.LocalDate;

public class Transactions {
    String recipientName;
    int trans_ID;
    String trans_type;
    String trans_method;
    int amount;
    LocalDate trans_date;

    public Transactions(String recipientName, LocalDate trans_date, int amount, String trans_method, String trans_type, int trans_ID) {
        this.recipientName = recipientName;
        this.trans_date = trans_date;
        this.amount = amount;
        this.trans_method = trans_method;
        this.trans_type = trans_type;
        this.trans_ID = trans_ID;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public LocalDate getTrans_date() {
        return trans_date;
    }

    public void setTrans_date(LocalDate trans_date) {
        this.trans_date = trans_date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTrans_method() {
        return trans_method;
    }

    public void setTrans_method(String trans_method) {
        this.trans_method = trans_method;
    }

    public String getTrans_type() {
        return trans_type;
    }

    public void setTrans_type(String trans_type) {
        this.trans_type = trans_type;
    }

    public int getTrans_ID() {
        return trans_ID;
    }

    public void setTrans_ID(int trans_ID) {
        this.trans_ID = trans_ID;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "recipientName='" + recipientName + '\'' +
                ", trans_ID=" + trans_ID +
                ", trans_type='" + trans_type + '\'' +
                ", trans_method='" + trans_method + '\'' +
                ", amount=" + amount +
                ", trans_date=" + trans_date +
                '}';
    }
}

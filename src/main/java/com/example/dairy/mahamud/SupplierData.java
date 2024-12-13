package com.example.dairy.mahamud;

import java.time.LocalDate;

public class SupplierData {
    private String id;
    private String name;
    private String contact;
    private LocalDate date;

    public SupplierData(String id, String name, String contact, LocalDate date) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SupplierData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", date=" + date +
                '}';
    }
}

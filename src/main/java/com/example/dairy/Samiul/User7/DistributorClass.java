package com.example.dairy.Samiul.User7;

public class DistributorClass {

    String name;
    int number;
    String email;
    String Zone;

    public DistributorClass(String name, int number, String email, String zone) {
        this.name = name;
        this.number = number;
        this.email = email;
        Zone = zone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZone() {
        return Zone;
    }

    public void setZone(String zone) {
        Zone = zone;
    }

    @Override
    public String toString() {
        return "DistributorClass{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", email='" + email + '\'' +
                ", Zone='" + Zone + '\'' +
                '}';
    }


}

package com.example.dairy.Samiul.User7;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class CampaignClass implements Serializable {
    String name;
    LocalDate startDate, endDate;
    String venueLocation;
    int budget;
    int id;

    public CampaignClass(String name, LocalDate startDate, LocalDate endDate, String venueLocation, int budget) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.venueLocation = venueLocation;
        this.budget = budget;
        this.id = generateId();


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getVenueLocation() {
        return venueLocation;
    }

    public void setVenueLocation(String venueLocation) {
        this.venueLocation = venueLocation;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CampaignClass{" +
                "name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", venueLocation='" + venueLocation + '\'' +
                ", budget=" + budget +
                '}';
    }

    private int generateId(){
        Random rand = new Random();
        int id = rand.nextInt(1000, 9999);
        return id;

    }


}

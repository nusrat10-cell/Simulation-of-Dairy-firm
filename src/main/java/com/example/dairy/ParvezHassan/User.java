package com.example.dairy.ParvezHassan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class User implements Serializable {
    int userID;
    String name;
    String emailID;
    String phoneNumber;
    String designation;
    String password;

    public User(int userID, String name, String emailID, String phoneNumber, String designation, String password) {
        this.userID = userID;
        this.name = name;
        this.emailID = emailID;
        this.phoneNumber = phoneNumber;
        this.designation = designation;
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", emailID='" + emailID + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", designation='" + designation + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public static void addUser(List<User> newUser) {
        List<User> users = new ArrayList<>();

        File file = new File("DataStore/UserData.bin");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                users = (List<User>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


        users.addAll(newUser);

        // Write updated revenues to file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

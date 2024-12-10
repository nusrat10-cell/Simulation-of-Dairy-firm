package com.example.dairy;

public class User {
    int Id;
    String Name;
    String Email;
    String PhoneNumber;
    String Password;

    public User(int id, String name, String email, String phoneNumber, String password) {
        Id = id;
        Name = name;
        Email = email;
        PhoneNumber = phoneNumber;
        Password = password;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

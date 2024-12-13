package com.example.dairy.ParvezHassan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Supplier implements Serializable {
    private int id;
    private String name;
    private String contact;
    private String address;

    public Supplier(int id, String name, String contact, String address) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                '}';
    }



    public static void pupulateSupplier(List<Supplier> newSupplier) {
        List<Supplier> suppliers = new ArrayList<>();

        // Read existing revenues from file, if any
        File file = new File("DataStore/Supplier.bin");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                suppliers = (List<Supplier>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        // Append new revenues
        suppliers.addAll(newSupplier);

        // Write updated revenues to file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(suppliers);
            System.out.println("Suppliers list created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

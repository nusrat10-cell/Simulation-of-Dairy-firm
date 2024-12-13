package com.example.dairy.ParvezHassan;

import java.io.Serializable;
import java.time.LocalDate;

public class OrderToSupplier implements Serializable {
    private static final long serialVersionUID = 1L;

    private int orderId;
    private String itemName;
    private int quantity;
    private String supplier;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private int deliveredQuantity;
    private double price; // New field

    public OrderToSupplier(int orderId, String itemName, int quantity, String supplier, LocalDate orderDate) {
        this.orderId = orderId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.supplier = supplier;
        this.orderDate = orderDate;
        this.deliveryDate = null; // Initially null
        this.deliveredQuantity = 0; // Initially 0
        this.price = 0.0; // Initially 0.0
    }

    public int getOrderId() {
        return orderId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getDeliveredQuantity() {
        return deliveredQuantity;
    }

    public void setDeliveredQuantity(int deliveredQuantity) {
        this.deliveredQuantity = deliveredQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderToSupplier{" +
                "orderId=" + orderId +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", supplier='" + supplier + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", deliveredQuantity=" + deliveredQuantity +
                ", price=" + price +
                '}';
    }
}

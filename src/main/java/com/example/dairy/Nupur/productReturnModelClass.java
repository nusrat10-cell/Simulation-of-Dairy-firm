package com.example.dairy.Nupur;

import java.time.LocalDate;

public class productReturnModelClass {
    private String productName;
    private String returnReason;
    private Integer quantity;
    private LocalDate returndate;
    private String status;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getReturndate() {
        return returndate;
    }

    public void setReturndate(LocalDate returndate) {
        this.returndate = returndate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
    }

    public productReturnModelClass(String productName, String status, LocalDate returndate, Integer quantity, String returnReason) {
        this.productName = productName;
        this.status = status;
        this.returndate = returndate;
        this.quantity = quantity;
        this.returnReason = returnReason;
    }

    @Override
    public String toString() {
        return "productReturnModelClass{" +
                "productName='" + productName + '\'' +
                ", returnReason='" + returnReason + '\'' +
                ", quantity=" + quantity +
                ", returndate=" + returndate +
                ", status='" + status + '\'' +
                '}';
    }
}



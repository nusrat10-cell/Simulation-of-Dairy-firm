package com.example.dairy.Nupur;

public class inquiryClass {
    private String customerName;
    private Integer inquiryID;
    private String inquiryType;
    private String status;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInquiryType() {
        return inquiryType;
    }

    public void setInquiryType(String inquiryType) {
        this.inquiryType = inquiryType;
    }

    public Integer getInquiryID() {
        return inquiryID;
    }

    public void setInquiryID(Integer inquiryID) {
        this.inquiryID = inquiryID;
    }

    public inquiryClass(String customerName, String status, String inquiryType, Integer inquiryID) {
        this.customerName = customerName;
        this.status = status;
        this.inquiryType = inquiryType;
        this.inquiryID = inquiryID;
    }

    @Override
    public String toString() {
        return "inquiryClass{" +
                "customerName='" + customerName + '\'' +
                ", inquiryID=" + inquiryID +
                ", inquiryType='" + inquiryType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

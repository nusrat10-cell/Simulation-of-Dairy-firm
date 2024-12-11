package com.example.dairy.Nupur;

public class feedbackModelClass {
    public String customerName;
    public String feedbackType;
    public String feedback;

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getFeedbackType() {
        return feedbackType;
    }

    public void setFeedbackType(String feedbackType) {
        this.feedbackType = feedbackType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public feedbackModelClass(String customerName, String feedback, String feedbackType) {
        this.customerName = customerName;
        this.feedback = feedback;
        this.feedbackType = feedbackType;
    }

    @Override
    public String toString() {
        return "feedbackModelClass{" +
                "customerName='" + customerName + '\'' +
                ", feedbackType='" + feedbackType + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}

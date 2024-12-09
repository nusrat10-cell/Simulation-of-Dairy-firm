package Nupur;

public class complaintsClass {
    public String productName;
    public String customerName;
    public String issueDescription;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public complaintsClass(String productName, String issueDescription, String customerName) {
        this.productName = productName;
        this.issueDescription = issueDescription;
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "complaintsClass{" +
                "productName='" + productName + '\'' +
                ", customerName='" + customerName + '\'' +
                ", issueDescription='" + issueDescription + '\'' +
                '}';
    }
}

package Nupur;

public class productReturnModelClass {
    public String productName;
    public String returnReason;
    public Integer returnID;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getReturnID() {
        return returnID;
    }

    public void setReturnID(Integer returnID) {
        this.returnID = returnID;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
    }

    @Override
    public String toString() {
        return "productReturnModelClass{" +
                "productName='" + productName + '\'' +
                ", returnReason='" + returnReason + '\'' +
                ", returnID=" + returnID +
                '}';
    }

    public productReturnModelClass(String productName, Integer returnID, String returnReason) {
        this.productName = productName;
        this.returnID = returnID;
        this.returnReason = returnReason;
    }
}

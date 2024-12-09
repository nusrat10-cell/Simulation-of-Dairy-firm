package Nupur;

public class packagingmaterialModelClass {
    public String productName;
    public Integer quantityUsed;
    public Integer remainingStock;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getRemainingStock() {
        return remainingStock;
    }

    public void setRemainingStock(Integer remainingStock) {
        this.remainingStock = remainingStock;
    }

    public Integer getQuantityUsed() {
        return quantityUsed;
    }

    public void setQuantityUsed(Integer quantityUsed) {
        this.quantityUsed = quantityUsed;
    }

    public packagingmaterialModelClass(String productName, Integer remainingStock, Integer quantityUsed) {
        this.productName = productName;
        this.remainingStock = remainingStock;
        this.quantityUsed = quantityUsed;
    }

    @Override
    public String toString() {
        return "packagingmaterialModelClass{" +
                "productName='" + productName + '\'' +
                ", quantityUsed=" + quantityUsed +
                ", remainingStock=" + remainingStock +
                '}';
    }
}

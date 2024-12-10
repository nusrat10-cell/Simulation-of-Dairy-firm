package com.example.dairy.mahamud;

public class RouteOptimizationModelClass {
    private int sampleid;
    private String farmername;
    private int milkQuantity;
    private String distance;

    public RouteOptimizationModelClass(int sampleid, String farmername, int milkQuantity, String distance) {
        this.sampleid = sampleid;
        this.farmername = farmername;
        this.milkQuantity = milkQuantity;
        this.distance = distance;

    }

    public int getSampleid() {
        return sampleid;
    }

    public void setSampleid(int sampleid) {
        this.sampleid = sampleid;
    }

    public String getFarmername() {
        return farmername;
    }

    public void setFarmername(String farmername) {
        this.farmername = farmername;
    }

    public int getMilkQuantity() {
        return milkQuantity;
    }

    public void setMilkQuantity(int milkQuantity) {
        this.milkQuantity = milkQuantity;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "RouteOptimizationModelClass{" +
                "sampleid=" + sampleid +
                ", farmername='" + farmername + '\'' +
                ", milkQuantity=" + milkQuantity +
                ", distance='" + distance + '\'' +
                '}';
    }
}

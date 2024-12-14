package com.example.dairy.mahamud;

public class QualityControlModel {
    private String id;
    private String temperature;
    private String ph;
    private String fatContent;
    private String status;

    public QualityControlModel(String id, String temperature, String ph, String fatContent, String status) {
        this.id = id;
        this.temperature = temperature;
        this.ph = ph;
        this.fatContent = fatContent;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getFatContent() {
        return fatContent;
    }

    public void setFatContent(String fatContent) {
        this.fatContent = fatContent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

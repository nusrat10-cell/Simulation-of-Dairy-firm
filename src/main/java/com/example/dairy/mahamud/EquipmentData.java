package com.example.dairy.mahamud;

import java.time.LocalDate;

public class EquipmentData {
    private String equipmentName;
    private LocalDate lastMaintenanceDate;
    private String status;
    private int currentUsage;

    public EquipmentData(String equipmentName, LocalDate lastMaintenanceDate, String status, int currentUsage) {
        this.equipmentName = equipmentName;
        this.lastMaintenanceDate = lastMaintenanceDate;
        this.status = status;
        this.currentUsage = currentUsage;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public LocalDate getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public void setLastMaintenanceDate(LocalDate lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCurrentUsage() {
        return currentUsage;
    }

    public void setCurrentUsage(int currentUsage) {
        this.currentUsage = currentUsage;
    }
}

package com.springboot.ems.dto;

public class RateDto {
    private Double communication;
    private Double productivity;
    private Double creativity;
    private Double integrity;
    private Double punctuality;
    private Double attendance;

    // int communication, int productivity, int creativity, int integrity,int punctuality, int attendance

    public RateDto(Double communication, Double productivity, Double creativity, Double integrity, Double punctuality,
            Double attendance) {
        this.communication = communication;
        this.productivity = productivity;
        this.creativity = creativity;
        this.integrity = integrity;
        this.punctuality = punctuality;
        this.attendance = attendance;
    }

    public Double getCommunication() {
        return communication;
    }

    public void setCommunication(Double communication) {
        this.communication = communication;
    }

    public Double getProductivity() {
        return productivity;
    }

    public void setProductivity(Double productivity) {
        this.productivity = productivity;
    }

    public Double getCreativity() {
        return creativity;
    }

    public void setCreativity(Double creativity) {
        this.creativity = creativity;
    }

    public Double getIntegrity() {
        return integrity;
    }

    public void setIntegrity(Double integrity) {
        this.integrity = integrity;
    }

    public Double getPunctuality() {
        return punctuality;
    }

    public void setPunctuality(Double punctuality) {
        this.punctuality = punctuality;
    }

    public Double getAttendance() {
        return attendance;
    }

    public void setAttendance(Double attendance) {
        this.attendance = attendance;
    }

    


}

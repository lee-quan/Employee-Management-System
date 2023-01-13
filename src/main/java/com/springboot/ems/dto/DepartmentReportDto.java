package com.springboot.ems.dto;

import java.text.DecimalFormat;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

// @NoArgsConstructor
// @AllArgsConstructor
// @Data

public class DepartmentReportDto {
    private int id;
    private String department_name;
    private String department_branch;
    private Double communication;
    private Double integrity;
    private Double productivity;

    private Double creativity;
    private Double attendance;
    private Double punctuality;
    private Double performance;

    DecimalFormat df = new DecimalFormat("#0.00");

    public DepartmentReportDto() {
    }
    // Double.parseDouble(df.format(avgrate)

    public DepartmentReportDto(int id, String department_name, String department_branch, Double communication, Double integrity,
            Double productivity, Double creativity, Double attendance, Double punctuality, Double performance) {
        this.id = id;
        this.department_name = department_name;
        this.department_branch = department_branch;
        this.communication = Double.parseDouble(df.format(communication));
        this.integrity = Double.parseDouble(df.format(integrity));
        this.productivity = Double.parseDouble(df.format(productivity));
        this.creativity = Double.parseDouble(df.format(creativity));
        this.attendance = Double.parseDouble(df.format(attendance));
        this.punctuality = Double.parseDouble(df.format(punctuality));
        this.performance = Double.parseDouble(df.format(performance));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getDepartment_branch() {
        return department_branch;
    }

    public void setDepartment_branch(String department_branch) {
        this.department_branch = department_branch;
    }

    public Double getCommunication() {
        return communication;
    }

    public void setCommunication(Double communication) {
        this.communication = communication;
    }

    public Double getIntegrity() {
        return integrity;
    }

    public void setIntegrity(Double integrity) {
        this.integrity = integrity;
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

    public Double getAttendance() {
        return attendance;
    }

    public void setAttendance(Double attendance) {
        this.attendance = attendance;
    }

    public Double getPunctuality() {
        return punctuality;
    }

    public void setPunctuality(Double punctuality) {
        this.punctuality = punctuality;
    }

    public Double getPerformance() {
        return performance;
    }

    public void setPerformance(Double performance) {
        this.performance = performance;
    }

    
}

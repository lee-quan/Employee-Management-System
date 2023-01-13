package com.springboot.ems.dto;

public class EmployeeReportDto {
    private int id;
    private String first_name;
    private String last_name;
    private String department_name;
    private String branch_name;
    private String designation;
    private Double avg;

    public EmployeeReportDto(int id, String first_name, String last_name, String department_name, String branch_name,
            String designation, Double avg) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.department_name = department_name;
        this.branch_name = branch_name;
        this.designation = designation;
        this.avg = avg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

}

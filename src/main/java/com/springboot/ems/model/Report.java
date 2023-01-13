package com.springboot.ems.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Double communication;
    private Double integrity;
    private Double productivity;
    private Double creativity;
    private Double attendance;
    private Double punctuality;
    private Double performance;
    private String department_name;
    private String department_branch;

    public Report(Double communication, Double integrity, Double productivity, Double creativity, Double attendance,
            Double punctuality, Double performance, String department_name, String department_branch) {
        this.communication = communication;
        this.integrity = integrity;
        this.productivity = productivity;
        this.creativity = creativity;
        this.attendance = attendance;
        this.punctuality = punctuality;
        this.performance = performance;
        this.department_branch = department_branch;
        this.department_name = department_name;
    }
}

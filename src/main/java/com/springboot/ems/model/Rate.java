package com.springboot.ems.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "rate")
public class Rate {

    @Id
    @Column(name = "rate_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getCommunication() {
        return communication;
    }

    public void setCommunication(int communication) {
        this.communication = communication;
    }

    public int getProductivity() {
        return productivity;
    }

    public void setProductivity(int productivity) {
        this.productivity = productivity;
    }

    public int getCreativity() {
        return creativity;
    }

    public void setCreativity(int creativity) {
        this.creativity = creativity;
    }

    public int getIntegrity() {
        return integrity;
    }

    public void setIntegrity(int integrity) {
        this.integrity = integrity;
    }

    public int getPunctuality() {
        return punctuality;
    }

    public void setPunctuality(int punctuality) {
        this.punctuality = punctuality;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    @Column(name = "rate_to")
    private int to;

    @Column(name = "rate_from")
    private int from;

    @Column(name = "rate_at")
    private String at;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "communication")
    private int communication;

    @Column(name = "productivity")
    private int productivity;

    @Column(name = "creativity")
    private int creativity;

    @Column(name = "integrity")
    private int integrity;

    @Column(name = "punctuality")
    private int punctuality;

    @Column(name = "attendance")
    private int attendance;

    @Column(name = "rate_at_date")
    private Date rate_at_date;
    
    @PrePersist
    void preInsert(){
        if(this.rate_at_date == null){
            this.rate_at_date = new Date();
        }
    }
    public Rate(int to, int from, int communication, int productivity, int creativity, int integrity,
            int punctuality, int attendance) {
        this.to = to;
        this.from = from;
        this.communication = communication;
        this.productivity = productivity;
        this.creativity = creativity;
        this.integrity = integrity;
        this.punctuality = punctuality;
        this.attendance = attendance;
    }

    public Rate() {
    }

    public Rate(Integer from, Integer to) {
        this.rate = 0.0;
        this.to = to;
        this.from = from;
    }

    public Date getRate_at_date() {
        return rate_at_date;
    }

    public void setRate_at_date(Date rate_at_date) {
        this.rate_at_date = rate_at_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

}

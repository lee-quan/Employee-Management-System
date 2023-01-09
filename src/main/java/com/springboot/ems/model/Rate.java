package com.springboot.ems.model;

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

    public Rate(int to, int from, String at, int communication, int productivity, int creativity, int integrity,
            int punctuality, int attendance) {
        this.to = to;
        this.from = from;
        this.at = at;
        this.communication = communication;
        this.productivity = productivity;
        this.creativity = creativity;
        this.integrity = integrity;
        this.punctuality = punctuality;
        this.attendance = attendance;
        int total = communication + productivity + creativity + integrity + punctuality + attendance;
        this.rate = Double.valueOf(total) / 6.0;
    }

    public Rate() {
    }

    public Rate(Integer from, Integer to) {
        this.rate = 0.0;
        this.to = to;
        this.from = from;
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

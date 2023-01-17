package com.springboot.ems.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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

    @Column(name = "rate_at_month")
    private String atMonth;
    @Column(name = "rate_at_year")
    private String atYear;
    @Column(name = "rate_at_day")
    private String atDay;

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
    void preInsert() {
        if (this.rate_at_date == null) {
            this.rate_at_date = new Date();
            this.atDay = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
            this.atMonth = new SimpleDateFormat("MMMM").format(Calendar.getInstance().getTime());
            this.atYear = Calendar.getInstance().getWeekYear()+"";
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

    public Rate(int to, int communication, int productivity, int creativity, int integrity,
            int punctuality, int attendance) {
        this.to = to;
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

}

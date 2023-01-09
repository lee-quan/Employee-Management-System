package com.springboot.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ems.model.Risk;

public interface RiskDao extends JpaRepository<Risk, Long>{}

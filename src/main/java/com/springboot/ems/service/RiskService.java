package com.springboot.ems.service;

import java.util.List;

import com.springboot.ems.model.Risk;

public interface RiskService {

	List<Risk> findAll();

	Risk findById(Long id);

	void save(Risk risk);

}

package com.springboot.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ems.model.Rate;
import com.springboot.ems.repo.RateRepository;

@Service
public class RateServiceImpl implements RateService {

    @Autowired
    private RateRepository rateRepository;

    @Override
    public Double getAverageRate(int id) {
        return rateRepository.getAverageRate(id);
    }

    @Override
    public Rate getRateById(int id1, int id2) {
        return rateRepository.getRateByID(id1, id2);
    }

    @Override
    public void saveRate(Rate rate) {
        System.out.println(rate.getRate()+ "@@@@@@@@@@@@@@@@@@@@@");
        // this.rateRepository.save(rate);
        // TODO Auto-generated method stub
        
    }
}

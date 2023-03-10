package com.springboot.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ems.dto.RateDto;
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
        int total = rate.getCommunication()+rate.getAttendance()+rate.getCreativity()+rate.getIntegrity()+rate.getPunctuality()+rate.getProductivity();
        Double avgRate = Double.valueOf(total)/6.0;
        rate.setRate(avgRate);
        this.rateRepository.save(rate);
        System.out.println(rate.getFrom());
        System.out.println("s2e1221312213123");
        // TODO Auto-generated method stub
        
    }

    @Override
    public RateDto getAvgRateById(int id) {
        return this.rateRepository.getAvgRateByID(id);
    }
}

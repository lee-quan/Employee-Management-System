package com.springboot.ems.service;

import com.springboot.ems.dto.RateDto;
import com.springboot.ems.model.Rate;

public interface RateService {
    Double getAverageRate(int id);
    Rate getRateById(int id1, int id2);
    void saveRate(Rate rate);
    RateDto getAvgRateById(int id);
}

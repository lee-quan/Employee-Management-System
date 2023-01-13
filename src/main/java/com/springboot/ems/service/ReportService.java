package com.springboot.ems.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.springboot.ems.dto.ReportDto;

import net.sf.jasperreports.engine.JRException;

public interface ReportService {
    String generateReport(String type)throws FileNotFoundException, JRException;
    List<ReportDto> getReportDto(); 
}

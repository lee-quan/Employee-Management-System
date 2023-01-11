package com.springboot.ems.service;

import java.io.FileNotFoundException;

import net.sf.jasperreports.engine.JRException;

public interface ReportService {
    String generateReport(String type)throws FileNotFoundException, JRException;
}

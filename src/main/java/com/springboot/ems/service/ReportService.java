package com.springboot.ems.service;

import java.io.FileNotFoundException;
import net.sf.jasperreports.engine.JRException;

public interface ReportService {
    void generateDepartmentByBranchReport() throws FileNotFoundException, JRException;
    void generateEmployeeReport() throws FileNotFoundException, JRException;
    void generateEmployeeReportByBranch() throws FileNotFoundException, JRException;
}

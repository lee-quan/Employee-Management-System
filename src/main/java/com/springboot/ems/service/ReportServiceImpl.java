package com.springboot.ems.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.springboot.ems.model.User;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private UserService userService;

    @Override
    public String generateReport(String type) throws FileNotFoundException, JRException {
        List<User> userList = userService.getAllUsers();
        String path = "/Users/leequan/Documents/CBSE/ems/report/";

        File file = ResourceUtils.getFile("classpath:Employees.jrxml");
        JasperReport jasper = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(userList);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("Employee", "List");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, params, dataSource);

        if(type.equalsIgnoreCase("html")) JasperExportManager.exportReportToHtmlFile(jasperPrint, path+"//employees.html");
        else if(type.equalsIgnoreCase("pdf")) JasperExportManager.exportReportToPdfFile(jasperPrint, path+"//employees.pdf");
        
        return "";
    }
    
}

package com.springboot.ems.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.ems.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("admin/export/{type}")
    public String export(@PathVariable String type, Model model) throws FileNotFoundException, JRException {
        if (type.equalsIgnoreCase("all")) {
            reportService.generateDepartmentByBranchReport();
            reportService.generateEmployeeReport();
            reportService.generateEmployeeReportByBranch();
        } else if (type.equalsIgnoreCase("departmentReport")) {
            reportService.generateDepartmentByBranchReport();
        } else if (type.equalsIgnoreCase("employeeReport")) {
            reportService.generateEmployeeReport();
        } else if (type.equalsIgnoreCase("employeeReportByBranch")) {
            reportService.generateEmployeeReportByBranch();
        }

        return "redirect:/admin/dashboard";
    }
}

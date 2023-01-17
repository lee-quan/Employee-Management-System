package com.springboot.ems.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.springboot.ems.dto.DepartmentReportDto;
import com.springboot.ems.dto.EmployeeReportDto;
import com.springboot.ems.model.Department;
import com.springboot.ems.model.User;
import com.springboot.ems.repo.DepartmentRepository;
import com.springboot.ems.repo.ReportRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportServiceImpl implements ReportService {

    public boolean containsID(final List<DepartmentReportDto> list, final int id) {
        return list.stream().filter(o -> o.getId() == id).findFirst().isPresent();
    }

    String time = new SimpleDateFormat("yyyy-MMMM").format(java.util.Calendar.getInstance().getTime());
    String path = "/Users/leequan/Documents/CBSE/Employee-Management-System/report/";

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void generateDepartmentByBranchReport() throws FileNotFoundException, JRException {
        List<DepartmentReportDto> list = reportRepository.getDepartmentWithRate();
        List<Department> departments = departmentRepository.getDepartmentListOrderByBranch();
        List<DepartmentReportDto> newList = new ArrayList<DepartmentReportDto>();

        for (int i = 0; i < departments.size(); i++) {
            if (containsID(list, departments.get(i).getId())) {
                for(int j=0; j<list.size();j++){
                    if(list.get(j).getId() == departments.get(i).getId()){
                        newList.add(list.get(j));
                        break;
                    }
                }
            }else{
                newList.add(new DepartmentReportDto(departments.get(i).getId(),departments.get(i).getDepartmentName(), departments.get(i).getDepartment_branch(), 0.0,0.0,0.0,0.0,0.0,0.0,0.0));
            }
        }

        // System.out.println(reportList.toString());
        File file = ResourceUtils.getFile("classpath:DepartmentsReport.jrxml");
        JasperReport jasper = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(newList);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("Employee", "List");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, params, dataSource);

        JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "//" + time + "-DepartmentReport.html");
        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "//" + time + "-DepartmentReport.pdf");

    }

    @Override
    public void generateEmployeeReport() throws FileNotFoundException, JRException {
        List<EmployeeReportDto> list = reportRepository.generateEmployeeReport();
        System.out.println(list.toString() + "sadsadsadsadsadsa");
        File file = ResourceUtils.getFile("classpath:Employees.jrxml");
        System.out.println(list.size() + "SIZE");
        JasperReport jasper = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("Employee", "List");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, params, dataSource);

        JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "//" + time + "-EmployeesReport.html");
        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "//" + time + "-EmployeesReport.pdf");

    }

    @Override
    public void generateEmployeeReportByBranch() throws FileNotFoundException, JRException {
        List<EmployeeReportDto> list = reportRepository.generateEmployeeReportByBranch();
        System.out.println(list.toString());
        File file = ResourceUtils.getFile("classpath:EmployeesByBranchReport.jrxml");
        JasperReport jasper = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("Employee", "List");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, params, dataSource);

        JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "//" + time + "-EmployeesReportByBranch.html");
        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "//" + time + "-EmployeesReportByBranch.pdf");
    }

}

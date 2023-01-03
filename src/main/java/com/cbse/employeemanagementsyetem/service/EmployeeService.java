package com.cbse.employeemanagementsyetem.service;

import java.util.List;

import com.cbse.employeemanagementsyetem.model.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployee();    
    void saveEmployee(Employee employee);
}

package com.cbse.employeemanagementsyetem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbse.employeemanagementsyetem.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}

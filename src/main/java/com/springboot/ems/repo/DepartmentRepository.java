package com.springboot.ems.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ems.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}

package com.springboot.ems.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.ems.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
    @Query("SELECT d FROM Department d ORDER BY department_branch")
    List<Department> getDepartmentListOrderByBranch();
}

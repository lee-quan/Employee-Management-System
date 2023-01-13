package com.springboot.ems.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ems.dto.DepartmentReportDto;
import com.springboot.ems.dto.EmployeeReportDto;
import com.springboot.ems.model.Rate;

@Repository
public interface ReportRepository extends JpaRepository<Rate, Integer> {
    @Query("SELECT new com.springboot.ems.dto.DepartmentReportDto (d.id, d.departmentName, d.department_branch, AVG(r.attendance), AVG(r.communication), AVG(r.creativity), AVG(r.integrity), AVG(r.productivity), AVG(r.punctuality), AVG(r.rate)) FROM Rate r JOIN User u ON u.id = r.to JOIN Department d ON u.department_id = d.id WHERE u.id != 1 GROUP BY u.department_id ORDER BY d.department_branch")
    List<DepartmentReportDto> generateDepartmentByBranchReport();

@Query("SELECT new com.springboot.ems.dto.EmployeeReportDto (u.id, u.firstName, u.lastName, d.departmentName, d.department_branch, u.designation, u.avg) FROM User u JOIN Department d ON u.department_id = d.id WHERE u.id !=1 ORDER BY d.branch_id, u.avg desc ")
    List<EmployeeReportDto> generateEmployeeReportByBranch();

@Query("SELECT new com.springboot.ems.dto.EmployeeReportDto (u.id, u.firstName, u.lastName, d.departmentName, d.department_branch, u.designation, u.avg) FROM User u JOIN Department d ON u.department_id = d.id WHERE u.id !=1 ORDER BY u.avg desc ")
    List<EmployeeReportDto> generateEmployeeReport();


}

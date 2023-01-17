package com.springboot.ems.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ems.dto.DepartmentReportDto;
import com.springboot.ems.dto.EmployeeReportDto;
import com.springboot.ems.model.Department;
import com.springboot.ems.model.Rate;

@Repository
public interface ReportRepository extends JpaRepository<Rate, Integer> {
    // u.department_id, d.departmentName, d.department_branch, AVG(r.communication) as communication, AVG(r.punctuality) as punctuality,AVG(r.productivity) as productivity,AVG(r.creativity) as creativity,AVG(r.attendance) as attendance,AVG(r.integrity) as integrity,AVG(r.rate) as rate
    @Query("SELECT new com.springboot.ems.dto.DepartmentReportDto (u.department_id, d.departmentName, d.department_branch, AVG(r.communication) as communication, AVG(r.punctuality) as punctuality,AVG(r.productivity) as productivity,AVG(r.creativity) as creativity,AVG(r.attendance) as attendance,AVG(r.integrity) as integrity,AVG(r.rate) as rate) FROM Rate r JOIN User u ON u.id = r.to JOIN Department d ON u.department_id = d.id GROUP BY u.department_id")
    List<DepartmentReportDto>  getDepartmentWithRate();

    // SELECT u.user_id, u.first_name, u.last_name, d.department_name, d.department_branch, u.designation, u.avg FROM users u JOIN departments d on u.department_id = d.id ORDER BY d.branch_id
@Query("SELECT new com.springboot.ems.dto.EmployeeReportDto (u.id, u.firstName, u.lastName, d.departmentName, d.branch_id, d.department_branch, u.designation, u.avg) FROM User u JOIN Department d ON u.department_id = d.id WHERE u.id !=1 ORDER BY d.branch_id, u.avg desc")
    List<EmployeeReportDto> generateEmployeeReportByBranch();

@Query("SELECT new com.springboot.ems.dto.EmployeeReportDto (u.id, u.firstName, u.lastName, d.departmentName, d.branch_id, d.department_branch, u.designation, u.avg) FROM User u JOIN Department d ON u.department_id = d.id WHERE u.id !=1 ORDER BY u.avg desc ")
    List<EmployeeReportDto> generateEmployeeReport();


}

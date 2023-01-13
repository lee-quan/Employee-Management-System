package com.springboot.ems.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ems.model.Report;

@Repository
public interface ReportRepository extends CrudRepository<Report, Integer> {
    // String query = "SELECT new com.springboot.ems.model.Report(AVG(communication), AVG(integrity),AVG(productivity) AVG(creativity), AVG(attendance), AVG(punctuality), AVG(performance), d.department_name, d.department_branch) FROM rate r JOIN users u ON u.user_id = r.rate_to JOIN departments d ON u.department_id = d.id WHERE u.user_id != 1 GROUP BY u.department_id";
    // @Query(query)
    // List<Report> generateReportForDepartments();
    
    // public Report(Double communication, Double integrity, Double productivity, Double creativity, Double attendance,
    // Double punctuality, Double performance, String department_name, String department_branch) 
    // @Query("SELECT d.department_name,d.department_branch,AVG(attendance) as attendance, AVG(communication) as communication, AVG(creativity) as creativity, AVG(integrity) as integrity, AVG(productivity) as productivity, AVG(punctuality) as punctuality, AVG(r.rate) as performance FROM rate r JOIN users u ON u.user_id = r.rate_to JOIN departments d ON u.department_id = d.id WHERE u.user_id != 1 GROUP BY u.department_id")
    // List<Report> generateReportForDepartments();


}

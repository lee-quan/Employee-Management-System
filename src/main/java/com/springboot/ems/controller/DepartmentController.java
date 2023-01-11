package com.springboot.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.ems.model.Department;

import com.springboot.ems.service.BranchService;
import com.springboot.ems.service.DepartmentService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private BranchService branchService;

    @GetMapping("/admin/departments")
    public String departmentDataTable(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "admin/department_table_list";
    }

    // Add New Department
    @GetMapping("/admin/newDepartment")
    public String addNewDepartment(Model model) {
        Department department = new Department();
        model.addAttribute("department", department);
        model.addAttribute("branches", branchService.getAllBranches());
        return "admin/new_department";
    }

    @PostMapping("/saveDepartment")
    public String saveEmployee(@ModelAttribute("department") Department department) {
        departmentService.saveDepartment(department);
        return "redirect:/admin/departments";
    }

    // View Department by ID
    @GetMapping("/admin/viewDepartment")
    public String viewDepartment(@RequestParam int id, Model model) {

        Department department = departmentService.getDepartmentById(id);
        model.addAttribute("branches", branchService.getAllBranches());

        model.addAttribute("department", department);
        return "admin/view_department";
    }

}
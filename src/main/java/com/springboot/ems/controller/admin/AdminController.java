package com.springboot.ems.controller.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.ems.controller.MyUserDetails;
import com.springboot.ems.model.Branch;
import com.springboot.ems.model.Department;
import com.springboot.ems.model.Rate;
import com.springboot.ems.model.User;
import com.springboot.ems.repo.RateRepository;
import com.springboot.ems.repo.UserRepository;
import com.springboot.ems.service.BranchService;
import com.springboot.ems.service.DepartmentService;
import com.springboot.ems.service.RateService;
import com.springboot.ems.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private BranchService branchService;

    @Autowired
    private RateService rateService;

    // Dashboard Page
    @RequestMapping("/admin/dashboard")
    public String employeeDash() {
        return "admin/admin_dashboard";
    }

    // Employee List
    @GetMapping("/admin/employees")
    public String employeeDataTable(Model model) {
        model.addAttribute("employees", userService.getAllUsersNot());
        return "admin/employee_table_list";
    }

    // Delete Employee by ID
    @RequestMapping("/admin/deleteEmployee")
    public String deleteEmployee(@RequestParam int id) {

        userService.deleteUserById(id);
        return "redirect:/admin/employees";
    }

    // View Employee by ID
    @GetMapping("/admin/viewEmployee")
    public String viewEmployee(@RequestParam int id, Model model) {

        User employee = userService.getUserById(id);
        model.addAttribute("departments", departmentService.getAllDepartments());

        model.addAttribute("employee", employee);
        return "admin/view_employee";
    }

    // Add New Employee
    @GetMapping("/admin/newEmployee")
    public String employeeAdminAdd(Model model) {
        User employee = new User();
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "admin/new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") User employee) {
        userService.saveUser(employee);
        return "redirect:/admin/employees";
    }

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

    @GetMapping("/admin/branches")
    public String branchDataTable(Model model) {
        model.addAttribute("branches", branchService.getAllBranches());
        return "admin/branch_table_list";
    }

    // Add New Branch
    @GetMapping("/admin/newBranch")
    public String addNewBranch(Model model) {
        Branch branch = new Branch();
        model.addAttribute("branch", branch);
        return "admin/new_branch";
    }

    @PostMapping("/saveBranch")
    public String saveBranch(@ModelAttribute("branch") Branch branch) {
        branchService.saveBranch(branch);
        return "redirect:/admin/branches";
    }

    // View Department by ID
    @GetMapping("/admin/viewBranch")
    public String viewBranch(@RequestParam int id, Model model) {

        Branch branch = branchService.getBranchById(id);
        model.addAttribute("branch", branch);
        return "admin/view_branch";
    }

    // Employee View () EmployeeList
    @GetMapping("/employee/employees")
    public String employeeDataTableForEmployee(Model model) {
        // Update average here
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails userDetails = new MyUserDetails(userRepository.getUserByUsername(auth.getName().toString()));
        User currUser = userService.getUserById(userDetails.getId());
        List<User> userList = userService.getAllUsersNot();
        List<Rate> rateList = new ArrayList<Rate>();
        for (int i = 0; i < userList.size(); i++) {
            int id = userList.get(i).getId();
            Double avgrate = rateService.getAverageRate(id);
            if (avgrate instanceof Double) {
                userList.get(i).setAvg(avgrate);
            } else {
                userList.get(i).setAvg(0);
            }
            userService.saveUser(userList.get(i));

            Rate rate = rateService.getRateById(currUser.getId(), userList.get(i).getId());
            System.out.println(currUser.getId() + " +++++++++++++  " + userList.get(i).getId());
            if (rate instanceof Rate) {
                rateList.add(rate);
            } else {
                Rate newRate = new Rate(currUser.getId(), userList.get(i).getId());
                rateList.add(newRate);

            }
        }
        model.addAttribute("rates", rateList);
        model.addAttribute("employees", userList);
        // model.addAttribute("userAndRate", userAndRate);
        return "employee/employee_table_list";
    }


    @GetMapping("/rate/{id}")
    public String showRateForm(@PathVariable (value="id") Integer id, Model model){
        return "employee/rate_form";
    }
    @PostMapping("/saveRating")
    public String saveRating(@ModelAttribute("rate") Rate rate) {
        // // rateService.saveRate(rate);
        // System.out.println(rate.getRate()+" @@@@@@@@@@@@@@");
        return "redirect:/employee/employees";
    }
}
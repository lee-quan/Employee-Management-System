package com.springboot.ems.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
// import java.time.LocalDate;
// import java.time.Month;

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

@Controller
public class EmployeeController {

    DecimalFormat df = new DecimalFormat("#0.00");

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
        List<User> userList = userService.getAllUsers();
        for (int i = 0; i < userList.size(); i++) {
            int id = userList.get(i).getId();
            Double avgrate = rateService.getAverageRate(id);
            if (avgrate instanceof Double) {
                userList.get(i).setAvg(Double.parseDouble(df.format(avgrate)));
            } else {
                userList.get(i).setAvg(0);
            }
            userService.saveUser(userList.get(i));

        }
        model.addAttribute("employees", userList);
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
        System.out.println(employee.getDepartment_id()+"iddddd");;
        // Department department = departmentService.getDepartmentById(employee.getDepartment_id());
        // employee.setDepartment(department.getDepartmentName()+", "+department.getDepartment_branch());
        userService.saveUser(employee);
        return "redirect:/admin/employees";
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Employee View EmployeeList
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
                userList.get(i).setAvg(Double.parseDouble(df.format(avgrate)));
            } else {
                userList.get(i).setAvg(0);
            }
            userService.saveUser(userList.get(i));

            Rate rate = rateService.getRateById(currUser.getId(), userList.get(i).getId());
            System.out.println(currUser.getId() + " +++++++++++++  " + userList.get(i).getId());
            if (rate instanceof Rate) {
                // userList.get(i).setAvg(Double.parseDouble(df.format(avgrate)));

                // rate.setRate(rate.getRate());
                rate.setRate(Double.parseDouble(df.format(rate.getRate())));
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

}
package com.springboot.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.ems.model.Branch;

import com.springboot.ems.service.BranchService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BranchController {

    @Autowired
    private BranchService branchService;

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

    // Delete Employee by ID
    @RequestMapping("/admin/deleteBranch")
    public String deleteBranch(@RequestParam int id) {
        // System.out.println("12321312321321321321312321");
        branchService.deleteBranchById(id);
        return "redirect:/admin/branches";
    }

}
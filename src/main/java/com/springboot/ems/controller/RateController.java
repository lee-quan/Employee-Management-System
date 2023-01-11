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
import com.springboot.ems.model.Rate;
import com.springboot.ems.model.User;
import com.springboot.ems.other.Rates;
import com.springboot.ems.repo.UserRepository;
import com.springboot.ems.service.RateService;
import com.springboot.ems.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RateController {

    DecimalFormat df = new DecimalFormat("#0.00");

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RateService rateService;

   
    @GetMapping("/rate/{id}")
    public String showRateForm(@PathVariable(value = "id") Integer id, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails userDetails = new MyUserDetails(userRepository.getUserByUsername(auth.getName().toString()));
        User user = userService.getUserById(userDetails.getId());
        Rate rate = rateService.getRateById(user.getId(), id);
        if (!(rate instanceof Rate)) {
            model.addAttribute("rate", new Rate(id, user.getId(), 0, 0, 0, 0, 0, 0));
            model.addAttribute("ifRateExist", false);
        } else {
            rate.setRate(Double.parseDouble(df.format(rate.getRate())));
            model.addAttribute("rate", rate);
            model.addAttribute("ifRateExist", true);
        }

        // model.addAttribute("rates", Rates.values());
        model.addAttribute("id", id);
        model.addAttribute("user", user);
        return "employee/rate_form";
    }

    @PostMapping("/saveRating")
    public String saveRating(@ModelAttribute("rate") Rate rate) {
        System.out.println(rate.getFrom() + " #################### ");
        rateService.saveRate(rate);
        return "redirect:/employee/employees";
    }

}
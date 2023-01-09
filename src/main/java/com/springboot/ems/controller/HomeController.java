package com.springboot.ems.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.ems.repo.UserRepository;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "home";
	}

	@Autowired
	UserRepository ur;

	@RequestMapping("/success")
	public void loginPageRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult)
			throws IOException, ServletException {
		String role = authResult.getAuthorities().toString();

		MyUserDetails userDetails = new MyUserDetails(ur.getUserByUsername(authResult.getName().toString()));
		System.out.println(userDetails.getId()+"##################");
		if (role.contains("ADMIN")) {
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/admin/dashboard"));
		} else {
			response.sendRedirect(
					response.encodeRedirectURL(request.getContextPath() + "/employee/employees"));
		}
	}

}

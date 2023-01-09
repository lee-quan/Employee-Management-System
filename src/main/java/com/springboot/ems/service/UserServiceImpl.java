package com.springboot.ems.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.springboot.ems.controller.MyUserDetails;
import com.springboot.ems.model.Role;
import com.springboot.ems.model.User;
import com.springboot.ems.repo.RoleRepository;
import com.springboot.ems.repo.UserRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleService roleService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void saveUser(User user) {
		if(!(user.getId() instanceof Integer)){
			String password = user.getBirthday().replace("-", "");
			user.setPassword(encoder.encode(password));
			user.setUsername(user.getEmail());
			user.setEnabled(true);
			user.setRoles(Arrays.asList(roleService.getEmployeeRole()));
		}
		this.userRepository.save(user);
		// encoder.encode(password), true));
	}

	@Override
	public User getUserById(int id) {
		Optional<User> optional = userRepository.findById(id);
		User User = null;
		if (optional.isPresent()) {
			User = optional.get();
		} else {
			throw new RuntimeException("Employee not found for id :: " + id);
		}
		return User;
	}

	@Override
	public void deleteUserById(int id) {
		this.userRepository.deleteById(id);

	}

	public String exportReport(String format) throws FileNotFoundException, JRException {
		List<User> employeeList = getAllUsers();
		String path = "D://JasperReports//";

		File file = ResourceUtils.getFile("classpath:Employees.jrxml");
		JasperReport jasper = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(employeeList);
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("Employee", "List");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, parameters, ds);

		if (format.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "//employees.html");
		}
		if (format.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "//employees.pdf");
		}

		return "path : " + path;
	}

	@Override
	public List<User> getAllUsersNot() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return this.userRepository.getAllEmployeesNot(auth.getName().toString());
	}

	@Override
	public List<User> getAllUsersNotWithRating() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MyUserDetails userDetails = new MyUserDetails(userRepository.getUserByUsername(auth.getName().toString()));
		return this.userRepository.getAllEmployeesNotWithRating(userDetails.getId());
	}

}

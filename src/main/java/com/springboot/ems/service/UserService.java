package com.springboot.ems.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.springboot.ems.model.User;

import net.sf.jasperreports.engine.JRException;

public interface UserService {	
	List<User> getAllUsers();
	List<User> getAllUsersNot();
	List<User> getAllUsersNotWithRating();
	void saveUser(User employee);
	User getUserById(int id);
	void deleteUserById(int id);
	String exportReport(String format) throws FileNotFoundException, JRException;
}

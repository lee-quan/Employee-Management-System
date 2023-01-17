package com.springboot.ems.model;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "users")
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String username;
	private boolean enabled;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "gender")
	private String gender;

	@Column(name = "address")
	private String address;

	@Column(name = "nic")
	private String nic;

	@Column(name = "mobile_number")
	private String mobileNo;

	@Column(name = "designation")
	private String designation;

	@Column(name = "birthday")
	private String birthday;

	@Column(name = "joined_date")
	private String joinedDate;

	@Column(name = "department")
	private String department;

	@Column(name = "password")
	private String password;

	@Column(name = "avg")
	private double avg;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(uniqueConstraints = @UniqueConstraint(columnNames = {
			"user_id" }), name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))

	private Collection<Role> roles;

	@Column(name = "department_id")
	private int department_id;
	
	public User() {
	}

	public User(String username, boolean enabled, String firstName, String lastName, String email, String gender,
			String address, String nic, String mobileNo, String designation, String birthday, String joinedDate,
			String department, String password, Set<Role> roles) {
		super();
		this.username = username;
		this.enabled = enabled;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.nic = nic;
		this.mobileNo = mobileNo;
		this.designation = designation;
		this.birthday = birthday;
		this.joinedDate = joinedDate;
		this.department = department;
		this.password = password;
		this.roles = roles;
		this.avg = 0;
	}

}

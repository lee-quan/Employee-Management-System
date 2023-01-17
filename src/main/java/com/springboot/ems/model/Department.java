package com.springboot.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "departments")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "department_name")
	private String departmentName;
	
	@Column(name = "dphone_number")
	private String dphoneNo;
	
	@Column(name = "department_email")
	private String departmentEmail;
	
	@Column(name = "department_branch")
	private String department_branch;

	@Column(name = "branch_id")
	private int branch_id;
	
	@Column(name = "department_address")
	private String department_address;
	
	@Column(name = "department_ententionNo")
	private String department_ententionNo;

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + ", dphoneNo=" + dphoneNo
				+ ", departmentEmail=" + departmentEmail + ", department_branch=" + department_branch
				+ ", department_address=" + department_address + ", department_ententionNo=" + department_ententionNo
				+ "]";
	}

}

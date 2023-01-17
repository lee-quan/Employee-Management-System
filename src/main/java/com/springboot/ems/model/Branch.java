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

@Getter
@Setter
@ToString
@Entity
@Table(name = "branches")
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// [id=0, branchName=wqewqewqewqe, bphoneNo=21312321, branchEmail=null, branchLocation=null, branchAddress=null, branchPCode=null, branchFaxNo=null]
	@Column(name = "branch_name")
	private String branchName;
	
	@Column(name = "bphone_number")
	private String bphoneNo;
	
	@Column(name = "branch_email")
	private String branchEmail;
	
	@Column(name = "branch_location")
	private String branchLocation;
	
	@Column(name = "branch_address")
	private String branchAddress;
	
	@Column(name = "branch_pCode")
	private String branchPCode;
	
	@Column(name = "branch_faxNo")
	private String branchFaxNo;	
}

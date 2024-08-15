package com.ish.ar.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitizenApplicationInputBean {
	
	private String name;
	private LocalDate dob;
	private String gender;
	private String emailId;
	private String ssn;
	private Long mobileNo;
}

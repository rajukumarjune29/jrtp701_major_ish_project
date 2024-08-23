package com.ish.ar.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CITIZEN_APPLICATION")
@Data
public class CitizenApplicationEntity {
	
	@Id
	@SequenceGenerator(name = "arSeqGen",sequenceName = "AR-SEQ-GEN",initialValue = 10001,allocationSize = 1)
	@GeneratedValue(generator = "arSeqGen",strategy = GenerationType.SEQUENCE)
	@Column(name = "CITIZEN_APPLICATION_ID")
	private Long citizenApplicationId;
	@Column(name = "NAME",length = 50)
	private String name;
	private LocalDate dob;
	@Column(name = "GENDER",length = 7)
	private String gender;
	@Column(name = "EMAIL_ID",length = 70)
	private String emailId;
	@Column(name = "STATE_NAME", length = 30)
	private String stateName;
	@Column(name = "SSN",length = 11)
	private String ssn;
	private Long mobileNo;
	
	@Column(name = "CREATED_BY",length = 50)
	private String createdBy;
	@Column(name = "CREATED_DATE",insertable = true,updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;
	@Column(name = "UPDATED_BY",length = 50)
	private String updatedeBy;
	@Column(name = "UPDATED_DATE",insertable = false,updatable = true)
	@UpdateTimestamp
	private LocalDateTime updatedDate;

}

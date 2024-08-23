package com.ish.dc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "DC_CASES")
public class DcCaseEnity {

	@Id
	@SequenceGenerator(name = "dcCaseSeqGen", sequenceName = "DC_CASE_SEQ_GEN", initialValue = 90000, allocationSize = 1)
	@GeneratedValue(generator = "dcCaseSeqGen",strategy = GenerationType.SEQUENCE)
	@Column(name = "CASE_NUMBER")
	private Long caseNumber;
	@Column(name = "CITIZEN_APPLICATION_ID")
	private Long citizenAppId;
	
	@Column(name = "PLAN_MASER_ID")
	private Long planMasterId;

}

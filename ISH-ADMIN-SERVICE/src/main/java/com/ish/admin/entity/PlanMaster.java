package com.ish.admin.entity;

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
@Table(name = "PLAN_MASTER")
@Data
public class PlanMaster {

	@Id
	@SequenceGenerator(name = "planMasterSeqGen", sequenceName = "PLAN-Master-SEQ-GEN", initialValue = 1000001, allocationSize = 1)
	@GeneratedValue(generator = "planMasterSeqGen", strategy = GenerationType.SEQUENCE)
	@Column(name = "PLAN_ID")
	private Integer planId;

	@Column(name = "PLAN_NAME", length = 50)
	private String planName;
	
	@Column(name = "DESCRIPTION", length = 225)
	private String description;

	@Column(name = "PLAN_START_DATE")
	private LocalDate planStartDate;

	@Column(name = "PLAN_END_DATE")
	private LocalDate planEndDate;

	@Column(name = "CATEGORY_ID")
	private Integer categoryId;

	@Column(name = "ACTIVE_STATUS")
	private Boolean activeStatus;

	@Column(name = "CREATED_BY", length = 50)
	private String createdBy;

	@Column(name = "CREATED_DATE", insertable = true, updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;

	@Column(name = "UPDATED_BY", length = 50)
	private String updatedeBy;

	@Column(name = "UPDATED_DATE", insertable = false, updatable = true)
	@UpdateTimestamp
	private LocalDateTime updatedDate;
}

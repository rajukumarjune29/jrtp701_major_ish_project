package com.ish.admin.entity;

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
@Table(name = "PLAN_CATEGORY")
@Data
public class PlanCategory {

	@Id
	@SequenceGenerator(name = "planSeqGen",sequenceName = "PLAN-SEQ-GEN",initialValue = 100001,allocationSize = 1)
	@GeneratedValue(generator = "planSeqGen",strategy = GenerationType.SEQUENCE)
	@Column(name = "CATEGORY_ID")
	private Long categoryId;
	@Column(name = "CATEGORY_NAME",length = 50)
	private String categoryName;
	@Column(name = "ACTIVE_STATUS")
	private Boolean activeStatus;
	
	
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

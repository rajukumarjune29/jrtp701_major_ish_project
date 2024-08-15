package com.ish.admin.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PlanMasterBean {
	private String planName;

	private String description;

	private LocalDate planStartDate;

	private LocalDate planEndDate;

	private Integer categoryId;

	private Boolean activeStatus;
}

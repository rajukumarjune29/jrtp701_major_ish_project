package com.ish.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "US_STATE")
public class USState {
	
	@Id
	@Column(name = "state_id")
	private Integer stateId;
	@Column(name = "state_code")
	private Integer stateCode;
	@Column(name = "state_name", length = 50)
	private String stateName;
}

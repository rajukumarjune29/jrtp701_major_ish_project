package com.ish.ar.service;

import java.util.List;

import com.ish.ar.entity.CitizenApplicationEntity;
import com.ish.ar.model.CitizenApplicationInputBean;

public interface ICitizenAppRegistrationService {
	
	public String citizenRegistration(CitizenApplicationInputBean citizenApplicationInputBean);

	public List<CitizenApplicationEntity> getCitizenRegistration();

	public CitizenApplicationEntity getCitizenRegistrationById(Long citizenAppId);


}

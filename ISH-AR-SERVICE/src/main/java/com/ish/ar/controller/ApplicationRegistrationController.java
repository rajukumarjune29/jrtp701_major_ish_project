package com.ish.ar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ish.ar.entity.CitizenApplicationEntity;
import com.ish.ar.model.CitizenApplicationInputBean;
import com.ish.ar.service.ICitizenAppRegistrationService;

@RestController
@RequestMapping("/api/v1/ar")
public class ApplicationRegistrationController {

	@Autowired
	ICitizenAppRegistrationService service;

	@PostMapping("/registration")
	public ResponseEntity<?> registration(@RequestBody CitizenApplicationInputBean citizenApplicationInputBean) {

		return new ResponseEntity<String>(service.citizenRegistration(citizenApplicationInputBean), HttpStatus.CREATED);
	}

	@GetMapping("/registrations")
	public ResponseEntity<?> getRegistrations() {

		return new ResponseEntity<List<CitizenApplicationEntity>>(service.getCitizenRegistration(), HttpStatus.OK);
	}
	@GetMapping("/registration/{citizenAppId}")
	public ResponseEntity<?> getRegistration(@PathVariable("citizenAppId") Long citizenAppId) {

		return new ResponseEntity<CitizenApplicationEntity>(service.getCitizenRegistrationById(citizenAppId), HttpStatus.OK);
	}
}

package com.ish.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ish.service.ISSAService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/v1/ssa")
public class SSARestController {
	
	@Autowired
	private ISSAService service;
	@GetMapping("/state/{ssn}")
	public ResponseEntity<?> getStateNameBySSN(@PathVariable("ssn") String ssn) {
		String ssnRegex="^[0-9]{3}[-]?[0-9]{2}[-]?[0-9]{4}$";
		if (!ssn.matches(ssnRegex)) {
			return new ResponseEntity<String>("Invaild SSN Number", HttpStatus.BAD_REQUEST);
		}
		// Get state code from ssn number of starting three digits
		String stateCode=ssn.substring(0,3);
		
		
		
		String stateName=service.findStateByStateCode(stateCode);
		if(stateName==null) {
			return new ResponseEntity<String>("State name does not founds for SSN number :"+ssn, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String> (stateName,HttpStatus.OK);
	}
	
}

package com.ish.dc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ish.dc.service.IDCMgmtService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/dc/")
public class DcController {

	@Autowired
	private IDCMgmtService mgmtService; 

	@GetMapping("/generate/case/{citizenAppId}")
	public ResponseEntity<?> gerateCase(@PathVariable("citizenAppId") Long citizenAppId) {

		return new ResponseEntity<>(mgmtService.createCase(citizenAppId),HttpStatus.OK);
	}
	@GetMapping("/show/plans")
	public ResponseEntity<?> showPlans(){

		return new ResponseEntity<Map<Long,String>>(mgmtService.showPlans(),HttpStatus.OK);
	}
	@GetMapping("/show/plans/{planId}")
	public ResponseEntity<?> showPlans(@PathVariable("planId") Long planId){

		return new ResponseEntity<>(mgmtService.showPlans(planId).getBody(),HttpStatus.OK);
	}
	
	@PutMapping("plans/{caseNumber}")
	public ResponseEntity<?> selectPlan(@PathVariable Long caseNumber, @RequestParam Long planId) {
		
		
		return new ResponseEntity<>(mgmtService.selectPlan(caseNumber,planId),HttpStatus.OK);
	}
}

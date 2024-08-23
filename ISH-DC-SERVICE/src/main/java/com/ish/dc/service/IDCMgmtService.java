package com.ish.dc.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;


public interface IDCMgmtService {

	public String createCase(Long citizenAppId) ;

	public Map<Long, String> showPlans();

	public ResponseEntity<?> showPlans(Long planId);

	public String selectPlan(Long caseNumber, Long planId);
}

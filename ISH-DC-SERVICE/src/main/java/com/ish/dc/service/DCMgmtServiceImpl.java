package com.ish.dc.service;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ish.dc.entity.DcCaseEnity;
import com.ish.dc.exception.CaseDetailsNotFoundException;
import com.ish.dc.exception.CitizenNotFoundException;
import com.ish.dc.ms.client.IARServiceMSClient;
import com.ish.dc.ms.client.IAdminServiceMSClient;
import com.ish.dc.repository.IDcCaseRepository;
import feign.FeignException.NotFound;

@Service
public class DCMgmtServiceImpl implements IDCMgmtService {

	@Autowired
	private IARServiceMSClient iarServiceMSClient;

	@Autowired
	private IAdminServiceMSClient iAdminServiceMSClient;

	@Autowired
	private IDcCaseRepository caseRepo;

	@Override
	public String createCase(Long citizenAppId) {
		try {
			ResponseEntity<?> registrations = iarServiceMSClient.getRegistrations(citizenAppId);

			if (registrations.getStatusCode().value() == 200) {

				DcCaseEnity dcCaseEnity = new DcCaseEnity();
				dcCaseEnity.setCitizenAppId(citizenAppId);
				return "caseNumber:" + caseRepo.save(dcCaseEnity).getCaseNumber();
			}

			return registrations.getBody().toString();

		} catch (NotFound e) {
			throw new CitizenNotFoundException(e.contentUTF8());
		}

	}

	@Override
	public Map<Long, String> showPlans() {

		ResponseEntity<?> responseEntity = iAdminServiceMSClient.getPlanMasterNames();

		return (Map<Long, String>) responseEntity.getBody();

	}

	@Override
	public ResponseEntity<?> showPlans(Long planId) {
		
		return iAdminServiceMSClient.getPlanMaster(planId);
		
		
	}

	@Override
	public String selectPlan(Long caseNumber, Long planId) {
		DcCaseEnity dcCaseEnity = caseRepo.findById(caseNumber).orElseThrow(()->new CaseDetailsNotFoundException("Case details not found for case number :"+caseNumber));
		dcCaseEnity.setPlanMasterId(planId);
		return "caseNumber:"+caseRepo.save(dcCaseEnity).getCaseNumber();
	}

}

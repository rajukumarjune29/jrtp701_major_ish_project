package com.ish.dc.ms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ISH-ADMIN-SERVICE")
public interface IAdminServiceMSClient {

	@GetMapping("/api/v1/admin/plan-masters/names")
	public ResponseEntity<?> getPlanMasterNames();
	
	@GetMapping("/api/v1/admin/plan-master/{planMasterId}")
	public ResponseEntity<?> getPlanMaster(@PathVariable("planMasterId") Long planMasterId);
}

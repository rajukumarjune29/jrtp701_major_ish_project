package com.ish.dc.ms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ISH-AR-SERVICE")
public interface IARServiceMSClient {

	@GetMapping("/api/v1/ar/registration/{citizenAppId}")
	public ResponseEntity<?> getRegistrations(@PathVariable("citizenAppId") Long citizenAppId);
}

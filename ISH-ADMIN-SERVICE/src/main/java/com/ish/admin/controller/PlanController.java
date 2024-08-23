package com.ish.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ish.admin.entity.PlanCategory;
import com.ish.admin.entity.PlanMaster;
import com.ish.admin.model.PlanCategoryBean;
import com.ish.admin.model.PlanMasterBean;
import com.ish.admin.repository.IPlanCategoryRepository;
import com.ish.admin.service.IPlanCategoryService;
import com.ish.admin.service.IPlanMasterService;

@RestController
@RequestMapping("/api/v1/admin")
public class PlanController {

	@Autowired
	private IPlanMasterService planMasterService;
	@Autowired
	private IPlanCategoryService planCategoryService;

	@PostMapping("/plan-category")
	public ResponseEntity<?> addPlanCategory(@RequestBody PlanCategoryBean planCategoryBean) {

		return new ResponseEntity<String>(planCategoryService.addPlanCategory(planCategoryBean), HttpStatus.CREATED);

	}

	@PostMapping("/plan-categories")
	public ResponseEntity<?> addPlanCategorys(@RequestBody List<PlanCategoryBean> planCategoryBeans) {
		return new ResponseEntity<List<String>>(planCategoryService.addPlanCategories(planCategoryBeans),
				HttpStatus.CREATED);

	}

	@GetMapping("/plan-category/{planCategoryId}")
	public ResponseEntity<?> getPlanCategory(@PathVariable("planCategoryId") Long planCategoryId) {
		return new ResponseEntity<PlanCategory>(planCategoryService.getPlanCategoryById(planCategoryId),HttpStatus.OK);

	}

	@GetMapping("/plan-categories")
	public ResponseEntity<?> getPlanCategorys() {
		return new ResponseEntity<List<PlanCategory>>(planCategoryService.getPlanCategories(),HttpStatus.OK);

	}

	@PostMapping("/plan-master")
	public ResponseEntity<?> addPlanMaster(@RequestBody PlanMasterBean planMasterBean) {
		return new ResponseEntity<String>(planMasterService.addPlanMaster(planMasterBean), HttpStatus.CREATED);

	}

	@PostMapping("/plan-masters")
	public ResponseEntity<?> addPlanMasters(@RequestBody List<PlanMasterBean> planMasterBeans) {
		return new ResponseEntity<List<String>>(planMasterService.addPlanMasters(planMasterBeans), HttpStatus.CREATED);

	}
	
	@GetMapping("/plan-masters/names")
	public ResponseEntity<?> getPlanMasterNames() {
		return new ResponseEntity<Map<Long,String>>(planMasterService.getPlanMasterNames(),HttpStatus.OK);


	}
	@GetMapping("/plan-master/{planMasterId}")
	public ResponseEntity<?> getPlanMaster(@PathVariable("planMasterId") Long planMasterId) {
		return new ResponseEntity<PlanMaster>(planMasterService.getPlanMasterById(planMasterId),HttpStatus.OK);


	}

	@GetMapping("/plan-masters")
	public ResponseEntity<?> getPlanMasters() {
		return new ResponseEntity<List<PlanMaster>>(planMasterService.getPlanMasters(),HttpStatus.OK);

	}
}

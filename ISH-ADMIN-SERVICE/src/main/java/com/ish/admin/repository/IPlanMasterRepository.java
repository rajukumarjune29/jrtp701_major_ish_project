package com.ish.admin.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ish.admin.entity.PlanMaster;

public interface IPlanMasterRepository extends JpaRepository<PlanMaster, Long>{
	
	@Query("select planId, planName from PlanMaster where activeStatus=true")
	public List<Object[]> findAllPlanMasterIdAndNames();
}

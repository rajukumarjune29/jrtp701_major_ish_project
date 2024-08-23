package com.ish.admin.service;

import java.util.List;
import java.util.Map;

import com.ish.admin.entity.PlanMaster;
import com.ish.admin.model.PlanMasterBean;

public interface IPlanMasterService {

	public String addPlanMaster(PlanMasterBean planMasterBean);

	public List<String> addPlanMasters(List<PlanMasterBean> planMasterBeans);

	public PlanMaster getPlanMasterById(Long planMasterId);

	public List<PlanMaster> getPlanMasters();

	public Map<Long, String> getPlanMasterNames();
}

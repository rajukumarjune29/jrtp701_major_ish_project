package com.ish.admin.service;

import java.util.List;

import com.ish.admin.entity.PlanMaster;
import com.ish.admin.model.PlanMasterBean;

public interface IPlanMasterService {

	public String addPlanMaster(PlanMasterBean planMasterBean);

	public List<String> addPlanMasters(List<PlanMasterBean> planMasterBeans);

	public PlanMaster getPlanMasterById(Integer planMasterId);

	public List<PlanMaster> getPlanMasters();
}

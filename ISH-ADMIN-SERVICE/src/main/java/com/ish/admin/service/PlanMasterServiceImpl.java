package com.ish.admin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ish.admin.entity.PlanMaster;
import com.ish.admin.model.PlanMasterBean;
import com.ish.admin.repository.IPlanMasterRepository;

@Service
public class PlanMasterServiceImpl implements IPlanMasterService {

	@Autowired
	private IPlanMasterRepository masterRepository;

	@Override
	public String addPlanMaster(PlanMasterBean planMasterBean) {

		PlanMaster planMaster = new PlanMaster();
		BeanUtils.copyProperties(planMasterBean, planMaster);
		return masterRepository.save(planMaster).getPlanId().toString();
	}

	@Override
	public List<String> addPlanMasters(List<PlanMasterBean> planMasterBeans) {
		List<PlanMaster> planMasters=new ArrayList<PlanMaster>();
		planMasterBeans.forEach(planMasterBean-> {
			PlanMaster planMaster=new PlanMaster();
			BeanUtils.copyProperties(planMasterBean, planMaster);
			planMasters.add(planMaster);
		});
		
		return masterRepository.saveAll(planMasters).stream().map(planMaster->planMaster.getPlanId().toString()).toList();
	}

	@Override
	public PlanMaster getPlanMasterById(Long planMasterId) {
		
		return masterRepository.findById(planMasterId).orElseThrow();
	}

	@Override
	public List<PlanMaster> getPlanMasters() {
		
		return masterRepository.findAll();
	}

	@Override
	public Map<Long, String> getPlanMasterNames() {
		Map<Long, String> plansMap=new HashMap<Long, String>();
		masterRepository.findAllPlanMasterIdAndNames().forEach(obj->{
			plansMap.put((Long)obj[0], obj[1].toString());
		});
		return plansMap;
	}

}

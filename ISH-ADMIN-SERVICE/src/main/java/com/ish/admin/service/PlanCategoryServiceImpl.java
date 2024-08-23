package com.ish.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ish.admin.entity.PlanCategory;
import com.ish.admin.model.PlanCategoryBean;
import com.ish.admin.repository.IPlanCategoryRepository;

@Service
public class PlanCategoryServiceImpl implements IPlanCategoryService {

	@Autowired
	IPlanCategoryRepository categoryRepository;
	@Override
	public String addPlanCategory(PlanCategoryBean planCategoryBean) {
		PlanCategory planCategory=new PlanCategory();
		BeanUtils.copyProperties(planCategoryBean, planCategory);
		return categoryRepository.save(planCategory).getCategoryId().toString();
	}

	@Override
	public List<String> addPlanCategories(List<PlanCategoryBean> planCategoryBeans) {
		List<PlanCategory> planCategories=new ArrayList<PlanCategory>();
		planCategoryBeans.forEach(planCategoryBean ->{
			PlanCategory planCategory= new PlanCategory();
			BeanUtils.copyProperties(planCategoryBean, planCategory);
			planCategories.add(planCategory);
		});
		return categoryRepository.saveAll(planCategories).stream().map(p->p.getCategoryId().toString()).toList();
	}

	@Override
	public PlanCategory getPlanCategoryById(Long planCategoryId) {
		
		return categoryRepository.findById(planCategoryId).orElseThrow();
	}

	@Override
	public List<PlanCategory> getPlanCategories() {
		return categoryRepository.findAll();
	}

}

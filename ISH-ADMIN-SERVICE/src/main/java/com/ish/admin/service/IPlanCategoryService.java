package com.ish.admin.service;

import java.util.List;

import com.ish.admin.entity.PlanCategory;
import com.ish.admin.model.PlanCategoryBean;

public interface IPlanCategoryService {

	public String addPlanCategory(PlanCategoryBean planCategoryBean);

	public List<String> addPlanCategories(List<PlanCategoryBean> planCategoryBeans);

	public PlanCategory getPlanCategoryById(Long planCategoryId);

	public List<PlanCategory> getPlanCategories();

}

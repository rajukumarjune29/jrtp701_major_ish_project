package com.ish.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ish.admin.entity.PlanCategory;

public interface IPlanCategoryRepository extends JpaRepository<PlanCategory, Integer> {

}

package com.ish.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ish.entity.USState;

public interface ISSARepository extends JpaRepository<USState, Integer>{

	@Query("select stateName from USState where stateCode=:stateCode")
	String findStateNameByStateCode(int stateCode);

}

package com.ish.dc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ish.dc.entity.DcCaseEnity;

public interface IDcCaseRepository extends JpaRepository<DcCaseEnity, Long> {

}

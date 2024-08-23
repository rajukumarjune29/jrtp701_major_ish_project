package com.ish.ar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ish.ar.entity.CitizenApplicationEntity;

public interface ICitizenAppRegistrationRepository extends JpaRepository<CitizenApplicationEntity, Long> {

}

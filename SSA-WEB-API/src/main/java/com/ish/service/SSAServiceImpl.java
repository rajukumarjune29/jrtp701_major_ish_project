package com.ish.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ish.entity.USState;
import com.ish.repository.ISSARepository;

@Service
public class SSAServiceImpl implements ISSAService {

	@Autowired
	private ISSARepository repository;
	@Override
	public String findStateByStateCode(String stateCode) {
		
		return repository.findStateNameByStateCode(Integer.parseInt(stateCode));
	}

}

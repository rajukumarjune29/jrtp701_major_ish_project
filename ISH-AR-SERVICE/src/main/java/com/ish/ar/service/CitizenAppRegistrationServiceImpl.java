package com.ish.ar.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.client.RestTemplate;

import com.ish.ar.entity.CitizenApplicationEntity;
import com.ish.ar.exception.SSNNotFoundException;
import com.ish.ar.model.CitizenApplicationInputBean;
import com.ish.ar.repository.ICitizenAppRegistrationRepository;

@Service
public class CitizenAppRegistrationServiceImpl implements ICitizenAppRegistrationService {

	@Autowired
	private ICitizenAppRegistrationRepository registrationRepository;
	@Autowired
	private RestTemplate restTemplate;

	@Value("${ish.ssa.web-app.url}")
	private String ishSSAWebAppURL;
	@Value("${ish.ar.state}")
	private String state;

	@Override
	public String citizenRegistration(CitizenApplicationInputBean citizenApplicationInputBean) {

		try {

			ResponseEntity<String> responseEntity = restTemplate.exchange(ishSSAWebAppURL, HttpMethod.GET, null,
					String.class, citizenApplicationInputBean.getSsn());
			String stateName = responseEntity.getBody();
			if (stateName.equalsIgnoreCase(state)) {
				CitizenApplicationEntity citizenApplicationEntity = new CitizenApplicationEntity();
				BeanUtils.copyProperties(citizenApplicationInputBean, citizenApplicationEntity);
				citizenApplicationEntity.setStateName(stateName);
				Integer appId = registrationRepository.save(citizenApplicationEntity).getCitizenApplicationId();
				if (appId > 0) {
					return "Application Id : " + appId;
				} else {
					return "Unable to Register application. Please try after some time";
				}
			} else {
				throw new SSNNotFoundException("SSN Number not belong to California");
			}
		} catch (NotFound e) {
				throw new SSNNotFoundException(e.getMessage());
		}catch (BadRequest e) {
			throw new SSNNotFoundException(e.getMessage());
		}
	}

	@Override
	public List<CitizenApplicationEntity> getCitizenRegistration() {
		
		return registrationRepository.findAll();
	}

}

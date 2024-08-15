package com.ish.ar.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean(name = "restTemplate")
    RestTemplate createRestTemplate() {
		return new RestTemplate();
	}
}

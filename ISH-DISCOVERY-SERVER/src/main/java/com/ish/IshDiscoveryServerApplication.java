package com.ish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class IshDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IshDiscoveryServerApplication.class, args);
	}

}

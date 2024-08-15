package com.ish.admin.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class IshSpringBootAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IshSpringBootAdminServerApplication.class, args);
	}

}

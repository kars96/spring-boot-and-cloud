package com.restwebservices.webservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebServicesApplication {
	// localhost:8080/actuator
	// localhost:8080 - HAL browser - used to browse actuator responses
	public static void main(String[] args) {
		SpringApplication.run(WebServicesApplication.class, args);
	}

}

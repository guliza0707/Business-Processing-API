package com.processing.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class BusinessProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessProcessingApplication.class, args);
	}

}

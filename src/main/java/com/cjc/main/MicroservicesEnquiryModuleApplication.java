package com.cjc.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories
@SpringBootApplication
@EntityScan
public class MicroservicesEnquiryModuleApplication {
	public static void main(String[] args) {
		SpringApplication.run(MicroservicesEnquiryModuleApplication.class, args);
	}
} 


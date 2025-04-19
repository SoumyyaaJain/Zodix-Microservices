package com.compatibility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CompatibilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompatibilityApplication.class, args);
	}

}

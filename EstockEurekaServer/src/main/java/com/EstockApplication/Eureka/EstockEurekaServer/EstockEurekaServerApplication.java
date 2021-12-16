package com.EstockApplication.Eureka.EstockEurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EstockEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstockEurekaServerApplication.class, args);
	}

}

package com.bhaiti.kela.server.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.bhaiti"})
public class SpringBootRest3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRest3Application.class, args);
	}

}

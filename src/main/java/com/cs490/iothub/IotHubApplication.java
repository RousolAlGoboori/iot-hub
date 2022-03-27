package com.cs490.iothub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
/*
 * Author: Rousol Al Goboori
 * Semester: 05/2022
 * Class Description:Entry point to start the execution of a program.
 * Every Java application has at least one class and at least one main method.
 * Main class
 */
public class IotHubApplication {
	// main driver method
	public static void main(String[] args) {
		SpringApplication.run(IotHubApplication.class, args);
	}

}

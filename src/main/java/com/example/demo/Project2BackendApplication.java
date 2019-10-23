package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("dev.tasacdws")
public class Project2BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project2BackendApplication.class, args);
	}

}

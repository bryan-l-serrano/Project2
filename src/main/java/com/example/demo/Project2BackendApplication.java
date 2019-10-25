package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("dev.tasacdws.entities")
@ComponentScan("dev.tasacdws")
@EnableJpaRepositories("dev.tasacdws.repositories")
public class Project2BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project2BackendApplication.class, args);
	}

}

package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.example",
		"com.example.repository",
		"com.example.entity","com.example.controller","com.example.service"})
@EnableJpaRepositories
@Configuration
public class DeccanSportClubSpringApplication  {

	public static void main(String[] args) {
		SpringApplication.run(DeccanSportClubSpringApplication.class, args);
	}


}

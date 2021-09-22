package com.example.OlympicsDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.example.OlympicsDemo")
public class OlympicsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlympicsDemoApplication.class, args);
	}

}

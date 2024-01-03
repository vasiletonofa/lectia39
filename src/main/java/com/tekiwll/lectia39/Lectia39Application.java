package com.tekiwll.lectia39;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lectia39Application  { // tomcat -> 8080 -> http://localhost:8080

	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(Lectia39Application.class, args); // nu se opreste
	}

}

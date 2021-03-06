package com.jj.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@GetMapping("/")
	public String getHomePage() {
		return "Hello World!! Welcome to Spring Boot "+ LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String getWorkoutPage() {
		return "Run a 5k";
	}
	
	@GetMapping("/fortune")
	public String getFortunePage() {
		return "Your lucky day!";
	}

}

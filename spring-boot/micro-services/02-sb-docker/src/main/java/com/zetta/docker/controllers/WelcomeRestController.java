package com.zetta.docker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	

	@GetMapping("/welcome")
	public String ShowMsg() {
		return "Welcome to second micro service";
	}
}

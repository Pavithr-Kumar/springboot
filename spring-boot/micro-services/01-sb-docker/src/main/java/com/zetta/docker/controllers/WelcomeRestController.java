package com.zetta.docker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class WelcomeRestController {

	// @Value("${build.version}")
	// private String version;

	@Value("${server.meassage}")
	private String msg;

	public WelcomeRestController() {
		super();
		// TODO Auto-generated constructor stub
	}
	// @Autowired
	// private Environment env;

	@GetMapping("/welcome")
	public String ShowMsg() {
		return "Welcome to first micro service";
	}

	// @GetMapping("/version")
	// public String howVersion() {
	// return version;
	// }

	@GetMapping("/message")
	public String showEnvProp() {
		// return env.getProperty("USERNAME");
		return msg;
	}

}

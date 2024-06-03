package com.zettamine.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zettamine.security.entity.MyUser;
import com.zettamine.security.repository.UserRepo;

@Controller
public class AppController {
	@Autowired
	private UserRepo repo;
	@Autowired
	private PasswordEncoder encoder;
	
	@PostMapping("/register/user")
	@ResponseBody
	public MyUser storeUsers(@RequestBody MyUser user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
	}

	@GetMapping("/home")
	public String getHomePage() {
		return "home";
	}
	
	@GetMapping("/home/user")
	public String getUserPage() {
		return "user";
	}
	
	@GetMapping("/home/admin")
	public String getAdminPage() {
		return "admin";
	}
}

package com.zettamine.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zettamine.security.model.User;
import com.zettamine.security.service.UserService;

@RestController
@RequestMapping("/zetta")
public class UserController {
	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUserByName() {
		
		return new ResponseEntity<List<User>>(service.getAllUsers() ,HttpStatus.OK);
	}
	
	@GetMapping("/users/{username}")
	public ResponseEntity<User> getUserByName(@PathVariable String username) {
		
		return new ResponseEntity<User>(service.getUserByName(username) ,HttpStatus.OK);
	}
	
	

}

package com.zettamine.spring.controllers;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonalRestController {

	@GetMapping(value = {"/personal/age/{name}/{yob}","/personal/age/{name}/"})
	public ResponseEntity<String> verifyAgeFOrInsurance( @RequestBody String body,
			                                             @PathVariable String name,
			                                             @PathVariable Integer yob)
	                                                   
	                                                   {
		String resp = "";
		System.err.println(body);
		Integer currentYear = LocalDate.now().getYear();
		
		if (yob != null && yob < currentYear)
			resp = "Hi " + name + ", you are " + (currentYear - yob) + " years of age and eligible for vote";
		else if (yob != null && yob >= currentYear)
			resp = "Hi " + name + ", you are not eligible for vote";
		else if (yob == null)
			resp = "Hi " + name + ", please provide required year";
		return new ResponseEntity<String>(resp, HttpStatus.OK);
	}
}

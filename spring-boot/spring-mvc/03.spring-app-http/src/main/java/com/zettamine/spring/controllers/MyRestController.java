package com.zettamine.spring.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

	@GetMapping("/today")
	public ResponseEntity<String> getData() {
		String date= LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyy"));
		HttpHeaders headers = new HttpHeaders();
		headers.add("company", "zettamine");
		
		ResponseEntity<String> res = new ResponseEntity<>( date,headers,HttpStatusCode.valueOf(200));
		return res;
	}
	
	@PostMapping("/data")
	public ResponseEntity<?> getAlldata(@RequestHeader String host,
			                            @RequestBody String body,
			                            @RequestParam String name
			                            
			                             ) {
		String reqBody = body;
		LoggerFactory.getLogger(MyRestController.class).info("{}",reqBody);
		System.err.println(reqBody.length());
		ResponseEntity<String> res = new ResponseEntity<>(reqBody, HttpStatusCode.valueOf(200));
		return res;
		
		
	}
}

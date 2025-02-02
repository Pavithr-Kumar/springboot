package com.zettamine.accounts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zettamine.accounts.dto.CustomerDetailsDto;
import com.zettamine.accounts.service.IAccountsService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CustomerDetailsController {
	
	private IAccountsService accService;

	@GetMapping("/customer-details")
	public ResponseEntity<CustomerDetailsDto> getAllDetails(@RequestParam String mobileNumber){
		return ResponseEntity.status(HttpStatus.OK)
				             .body(accService.getAllDetails(mobileNumber));
	}
}

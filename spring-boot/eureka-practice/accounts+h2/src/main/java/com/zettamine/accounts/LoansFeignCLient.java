package com.zettamine.accounts;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zettamine.accounts.dto.LoansDto;

@FeignClient(name ="loans")
public interface LoansFeignCLient {

	 @GetMapping(path = "/api/fetch", consumes = "application/json")
	  ResponseEntity<LoansDto> fetchLoanDetails(@RequestParam String mobileNumber);
}

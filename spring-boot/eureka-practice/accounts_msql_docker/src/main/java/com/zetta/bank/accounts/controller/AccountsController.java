package com.zetta.bank.accounts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zetta.bank.accounts.constants.AccountConstants;
import com.zetta.bank.accounts.dto.CustomerDto;
import com.zetta.bank.accounts.dto.ResponseDto;
import com.zetta.bank.accounts.service.AccountServiceInt;

@RestController
@RequestMapping("/zetta")
public class AccountsController {
	private AccountServiceInt accService;

	public AccountsController(AccountServiceInt accService) {
		super();
		this.accService = accService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDto> handleCreateAcc(@RequestBody CustomerDto custDto){
		accService.saveCustomer(custDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				             .body(new ResponseDto(AccountConstants.STATUS_201,AccountConstants.MESSAGE_201));
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<CustomerDto> fetchCustomer(@RequestParam String mobNo){
		return ResponseEntity.status(HttpStatus.OK).body(accService.findCustomer(mobNo));
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseDto> updateCustomer(@RequestBody CustomerDto customerDto){
		boolean isUpdated=accService.updateCustomer(customerDto);
		
		if(isUpdated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(AccountConstants.STATUS_200,AccountConstants.MESSAGE_200));
		}
		else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
					.body(new ResponseDto(AccountConstants.STATUS_417,AccountConstants.MESSAGE_417_UPDATE));
		}
	}

}

package com.zetta.bank.accounts.service;

import java.util.Optional;
import java.util.Random;


import org.springframework.stereotype.Service;

import com.zetta.bank.accounts.dto.AccountsDto;
import com.zetta.bank.accounts.dto.CustomerDto;
import com.zetta.bank.accounts.dto.ResponseDto;
import com.zetta.bank.accounts.entity.Account;
import com.zetta.bank.accounts.entity.Customer;
import com.zetta.bank.accounts.exceptions.CustomerAlreadyExistsException;
import com.zetta.bank.accounts.exceptions.ResourceNotFoundException;
import com.zetta.bank.accounts.mapper.AccountMapper;
import com.zetta.bank.accounts.mapper.CustomerMapper;
import com.zetta.bank.accounts.repository.AccountRepo;
import com.zetta.bank.accounts.repository.CustomerRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountService implements AccountServiceInt {
	private AccountRepo accRepo;
	private CustomerRepo custRepo;
	private static String accType[]= {"Savings","Salary"};
	
	@Override
	public void createAccount(Account acc) {
		acc.setAccNo(new Random().nextLong(111111111l, 9999999998l));
		acc.setAccType(accType[(new Random()).nextInt(0, 2)]);
		acc.setBranchAddress("246 Maple Court, Hamletown, New Zealand");
		accRepo.save(acc);
		
	}

	@Override
	public void saveCustomer(CustomerDto custDto) {
		Optional<Customer> optional= custRepo.findByMobileNo(custDto.getMobileNo());
		if(optional.isPresent())
			throw new CustomerAlreadyExistsException("Customer Already Exists with mobile no: "+custDto.getMobileNo());
		Customer cust = custRepo.save(CustomerMapper.mapToCustomer(new Customer(), custDto));	
		Account acc = new Account();
		acc.setCustId(cust.getCustId());
	    createAccount(acc);
	}

	@Override
	public CustomerDto findCustomer(String mobNo) {
	Customer cust =	custRepo.findByMobileNo(mobNo).orElseThrow(()->new ResourceNotFoundException("Customer", "Mobile Number", mobNo));
	
	CustomerDto custDto = CustomerMapper.mapToCustomerDto(new CustomerDto(),cust);
	custDto.setAccountsDto(AccountMapper.maptoAccDto(accRepo.findByCustId(cust.getCustId()), new AccountsDto()));
		return custDto;
	}

	@Override
	public boolean updateCustomer(CustomerDto customerDto) {
		boolean isUpdated=false;
		AccountsDto accDto = customerDto.getAccountsDto();
		if(accDto!=null) {
			Account acc= accRepo.findById(accDto.getAccountNumber())
					            .orElseThrow(()-> new ResourceNotFoundException("Account", "Account Number", accDto.getAccountNumber().toString()));
			
			Account updatedAcc = AccountMapper.maptoAcc(acc, accDto);
			accRepo.save(updatedAcc);
			Customer cust = custRepo.findById(acc.getCustId())
					                .orElseThrow(()->new ResourceNotFoundException("Customer", "Customer ID", acc.getCustId().toString()));
					                
			Customer updatedCust = CustomerMapper.mapToCustomer(cust, customerDto);
			custRepo.save(updatedCust);
			isUpdated=true;
		}
		return isUpdated;
	}
	
	
	
	

}

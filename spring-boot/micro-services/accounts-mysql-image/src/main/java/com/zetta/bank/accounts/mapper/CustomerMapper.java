package com.zetta.bank.accounts.mapper;

import com.zetta.bank.accounts.dto.CustomerDto;
import com.zetta.bank.accounts.entity.Customer;

public class CustomerMapper {
	public static Customer mapToCustomer(Customer customer,CustomerDto custDto) {
		customer.setCustEmail(custDto.getEmail());
		customer.setCustName(custDto.getName());
		customer.setMobileNo(custDto.getMobileNo());
		return customer;
	}
	
	public static CustomerDto mapToCustomerDto(CustomerDto custDto, Customer customer) {
		custDto.setEmail(customer.getCustEmail());
		custDto.setMobileNo(customer.getMobileNo());
		custDto.setName(customer.getCustName());
		return custDto;
	}

}

package com.zetta.bank.accounts.service;

import com.zetta.bank.accounts.dto.CustomerDto;
import com.zetta.bank.accounts.entity.Account;

public interface AccountServiceInt {

	void createAccount(Account acc);
	void saveCustomer(CustomerDto custDto);
	CustomerDto findCustomer(String mobNo);
	boolean updateCustomer(CustomerDto customerDto);

}
package com.zetta.bank.accounts.mapper;

import com.zetta.bank.accounts.dto.AccountsDto;
import com.zetta.bank.accounts.entity.Account;

public class AccountMapper {
	public static AccountsDto maptoAccDto(Account account, AccountsDto accDto) {
		accDto.setAccountNumber(account.getAccNo());
		accDto.setAccountType(account.getAccType());
		accDto.setBranchAddress(account.getBranchAddress());
		return accDto;
	}
	
	public static Account maptoAcc(Account account, AccountsDto accDto) {
		account.setAccNo(accDto.getAccountNumber());
		account.setAccType(accDto.getAccountType());
		account.setBranchAddress(accDto.getBranchAddress());
		return account;
	}
	
	

}

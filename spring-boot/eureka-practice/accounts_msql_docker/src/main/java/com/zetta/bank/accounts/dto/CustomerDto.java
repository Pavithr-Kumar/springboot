package com.zetta.bank.accounts.dto;

import com.zetta.bank.accounts.entity.Account;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
	private String name;
	private String email;
	private String mobileNo;
	private AccountsDto accountsDto;
	

}

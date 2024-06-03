package com.zettamine.accounts.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDetailsDto {
	 private String name;
	 private String email;
	 private String mobileNumber;
	 private AccountsDto accountsDto;
	 private LoansDto loansDto;
	 private CardsDto cardsDto;

}

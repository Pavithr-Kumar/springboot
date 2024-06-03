package com.zetta.bank.accounts.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zetta.bank.accounts.dto.AccountsDto;
import com.zetta.bank.accounts.entity.Account;


public interface AccountRepo extends JpaRepository<Account, Serializable> {

	Account findByCustId(Integer id);

}

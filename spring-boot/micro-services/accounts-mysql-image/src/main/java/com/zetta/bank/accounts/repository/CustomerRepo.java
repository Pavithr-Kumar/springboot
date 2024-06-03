package com.zetta.bank.accounts.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zetta.bank.accounts.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Serializable> {
  Optional<Customer> findByMobileNo(String mobNo);

}

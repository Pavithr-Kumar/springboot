package com.zettamine.data.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.data.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Serializable> {

}

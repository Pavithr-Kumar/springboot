package com.zettamine.data.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.data.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Serializable> {

}

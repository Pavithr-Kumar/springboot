package com.zettamine.spring.mi.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.spring.mi.entities.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Serializable> {

	List<Vendor> findAllByVendorActiveStatusOrderByVendorId(String string);

}

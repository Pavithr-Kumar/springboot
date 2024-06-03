package com.zettamine.spring.mi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zettamine.spring.mi.entities.Vendor;
import com.zettamine.spring.mi.repository.VendorRepository;

@Service
public class VendorService {

	private VendorRepository vendorRepository;

	public VendorService(com.zettamine.spring.mi.repository.VendorRepository vendorRepository) {
		super();
		this.vendorRepository = vendorRepository;
	}
	
	public void addNewVendor(Vendor vendor) {
		vendorRepository.save(vendor);
	}
	
	public List<Vendor> getAllVendors(){
		return vendorRepository.findAllByVendorActiveStatusOrderByVendorId("YES");
	}
	
	public void deleteVendor(Integer vendorId) {
		Vendor vendor = vendorRepository.findById(vendorId).get();
		vendor.setVendorActiveStatus("NO");
		vendorRepository.save(vendor);
		
	}

	public void updateVendor(Vendor vendor) {
		vendorRepository.save(vendor);
		
	}

	public Vendor getVendorById(Integer vendorId) {
		
		return vendorRepository.findById(vendorId).get();
	}
}

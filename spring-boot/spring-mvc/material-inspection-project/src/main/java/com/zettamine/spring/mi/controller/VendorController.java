package com.zettamine.spring.mi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zettamine.spring.mi.constants.AppConstants;

import com.zettamine.spring.mi.entities.Vendor;
import com.zettamine.spring.mi.service.VendorService;

@Controller
@RequestMapping("/zetta")
public class VendorController {
	private VendorService vendorService;
	
	
	public VendorController(VendorService vendorService) {
		super();
		this.vendorService = vendorService;
	}

	@GetMapping("/vendor")
	public String showVendorStarter() {
		return AppConstants.VENDOR_VIEW;
	}
	
	@GetMapping("/vendor/new")
	public String addVendor(Model model){
		
		model.addAttribute("vendor", new Vendor());
		return AppConstants.VENDOR_FORM_VIEW;
	}
	
	@PostMapping("/vendor/add")
	public String getVendor(Vendor vendor) {
		if(vendor.getVendorId()==null)
		    vendorService.addNewVendor(vendor);
		else
			vendorService.updateVendor(vendor);
		
		return AppConstants.VENDOR_VIEW;
	}
	
	@GetMapping("/vendor/edit")
	public String updateVendor(Model model,@RequestParam Integer vendorId) {
		model.addAttribute("vendor", vendorService.getVendorById(vendorId));
		return AppConstants.VENDOR_FORM_VIEW;
	}
	
	@GetMapping("/vendor/show-all")
	public String showAllVendors(Model model) {
		model.addAttribute("vendors",vendorService.getAllVendors());
		return AppConstants.VENDOR_VIEW;
	}
	
	@GetMapping("/vendor/delete")
	public String deleteVendor(@RequestParam Integer vendorId) {
		vendorService.deleteVendor(vendorId);
		return "redirect:show-all";
	}
	
	

}

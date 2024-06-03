package com.zettamine.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zettamine.spring.entities.Product;

@Controller
@RequestMapping("/pms")
public class ProductController {
	
	@GetMapping("/new-product")
	public String getProductDeatils(Model model) {
		Product product = new Product();
		model.addAttribute("product",product);
		
		return "index";
		
	}
	
	@PostMapping("/saveproduct")
	public String saveProduct(Product product, Model model) {
		System.out.println(product);
		
		return "redirect:success";
	}
	
	@GetMapping("/success")
	public String showSuccess() {
		return "success";
	}
	
	@GetMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("user", "suresh");
		return "NewFile";
	}
	
	@PostMapping("/validate-form")
	public String validateDetails(Model model) {
		//model.addAttribute("user", "suresh");
		
		return "redirect:form";
	}

}

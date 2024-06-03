package com.zettamine.boot.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zettamine.boot.configs.EmployeeConfigs;

@Service
public class EmployeeService {
	@Value("pavithra")
	private String name;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public EmployeeService() {
		LoggerFactory.getLogger(EmployeeService.class).info("\033[32mEmployee Service Bean\033[0m");
	}

}

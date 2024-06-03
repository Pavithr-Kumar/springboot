package com.zettamine.spring.core.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


public class Employee {
	@Value("Ravi Kumar")
	private String empName;
	@Value("20000")
	private float empSal;
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empSal=" + empSal + "]";
	}
	
	@PostConstruct
	public void myInit() {
		System.out.println("init called");
	}
	
	@PreDestroy
	public void myDestroy() {
		System.out.println("Destroy called");
	}
	

}

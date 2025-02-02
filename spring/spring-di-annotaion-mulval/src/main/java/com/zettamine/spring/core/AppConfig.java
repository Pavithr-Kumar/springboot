package com.zettamine.spring.core;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zettamine.spring.core.beans.Address;
import com.zettamine.spring.core.beans.Employee;

@Configuration
@ComponentScan(basePackages = {"com.zettamine.spring"})
public class AppConfig {
	@Bean
	@Qualifier("qualifier1")
	public Address getAddressObj1() {
		Address add = new Address();
		add.setCity("Gajuwaka");
		add.setState("Andhra Pradesh");
		return add;
		
	}
	
	@Bean
	public Address getAddressObj2() {
		Address add = new Address();
		add.setCity("Hyderabad");
		add.setState("Telangana");
		return add;
	}
	
	@Bean
	public Employee getEmployeeObj1() {
		Employee emp = new Employee();
		emp.setEmpName("Raja");
		return emp;
	}
	
	@Bean
	public Employee getEmployeeObj2() {
		Employee emp = new Employee();
		emp.setEmpName("Ravi");
		return emp;
	}

}

package com.zettamine.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zettamine.spring.core.beans.Employee;
import com.zettamine.spring.core.configs.EmpConfig;

public class EmployeeApp {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(EmpConfig.class);
		Employee emp = context.getBean(Employee.class);
		System.out.println(emp);
		
		((ConfigurableApplicationContext)context).close();
	}

}

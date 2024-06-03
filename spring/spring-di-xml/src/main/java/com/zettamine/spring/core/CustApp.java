package com.zettamine.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zettamine.spring.core.beans.Customer;

public class CustApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("cust-car.xml");
		
		Customer custUsingSetterInjection = context.getBean("cust1",Customer.class);
		
		Customer custUsingConstructorInjection = context.getBean("cust2",Customer.class);
		
		Customer custUsingFieldInjection = context.getBean("cust3",Customer.class);
		
		System.out.println("Inject using setter "+custUsingSetterInjection);
		
		System.out.println("Inject using constructor  "+custUsingConstructorInjection);
		
		System.out.println("Inject using Field  "+custUsingFieldInjection);

	}

}

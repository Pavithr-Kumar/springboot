package com.zettamine.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zettamine.spring.services.CalcServices;

@Configuration
@ComponentScan
public class BusinessLogic {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BusinessLogic.class);
		CalcServices ser = context.getBean(CalcServices.class);
		
		System.out.println("Highest value = "+ser.findMax());

	}

}

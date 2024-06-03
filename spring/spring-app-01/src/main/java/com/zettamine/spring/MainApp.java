package com.zettamine.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zettamine.spring.beans.User;
import com.zettamine.spring.configs.AppConfig;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println(context.getBeanDefinitionCount());
		
		User user = context.getBean(User.class);
		
		System.out.println(user);
		
		

	}

}

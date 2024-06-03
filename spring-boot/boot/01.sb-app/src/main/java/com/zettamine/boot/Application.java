package com.zettamine.boot;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Application {

	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println("Application class started");
		System.out.println("no of Beans :"+context.getBeanDefinitionCount());
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out :: println);
		System.out.println("Application class closed");
		
		context.close();
		
	}

}

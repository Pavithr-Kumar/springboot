package com.zettamine.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zettamine.boot.beans.Car;

@SpringBootApplication
public class SbAppDiApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext context = 	SpringApplication.run(SbAppDiApplication.class, args);
	System.out.println(context.getBeanDefinitionCount());
	context.getBean(Car.class).startJourney();
	
	context.close();
	}

}

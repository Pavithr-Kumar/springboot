package com.zettamine.spring.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.zettamine"})
@PropertySource(value = {"names.properties"})
public class AppConfig {

	public AppConfig() {
		System.out.println("Inside app config");
		
	}

}

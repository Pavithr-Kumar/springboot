package com.zettamine.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zettamine.boot.configs.DBConfigs;

@SpringBootApplication
public class Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
	ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
	
	LOGGER.info("No of beans = {}",context.getBeanDefinitionCount());
	DBConfigs config = context.getBean(DBConfigs.class);
	LOGGER.info("Driver = {} | Url = {}",config.getDriver(),config.getUrl());
  
	context.close();
	
		

	}

}

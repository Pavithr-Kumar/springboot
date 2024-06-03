package com.zettamine.boot;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zettamine.boot.configs.DBConnetion;

@SpringBootApplication
public class SbAppProfilesApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext context =	SpringApplication.run(SbAppProfilesApplication.class, args);
	LoggerFactory.getLogger(SbAppProfilesApplication.class).info("\033[32mDb Obj ={}",context.getBean(DBConnetion.class));
	context.close();
	}

}

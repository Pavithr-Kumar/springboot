package com.zettamine.spring.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

//@Configuration
public class MyMailConfigurtion {
	
	@Bean
	public JavaMailSender givemeMailSender() {
		JavaMailSenderImpl sender =new  JavaMailSenderImpl();
		return sender;
	}

}

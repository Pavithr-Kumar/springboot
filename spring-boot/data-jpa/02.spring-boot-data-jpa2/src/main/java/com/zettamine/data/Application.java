package com.zettamine.data;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zettamine.data.service.ContactService;
import com.zettamine.data.service.ContactServiceImpl;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
   ConfigurableApplicationContext context =		SpringApplication.run(Application.class, args);
   ContactService service = context.getBean(ContactService.class);
   service.getByExmpl().forEach(x->LoggerFactory.getLogger(ContactServiceImpl.class).info("\033[032m{}\033[0m",x));;
	}

}

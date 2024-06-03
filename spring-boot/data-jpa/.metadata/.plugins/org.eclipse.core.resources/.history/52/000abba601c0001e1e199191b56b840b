package com.zettamine.data;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zettamine.data.entities.Contact;
import com.zettamine.data.service.ContactService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(Application.class);
	ConfigurableApplicationContext context =	SpringApplication.run(Application.class, args);
	ContactService service = context.getBean(ContactService.class);
	
	//List<Contact> list = service.getContactInAscOfName();
	//List<Contact> list = service.getContactInDescOfName();
	List<Contact> list = service.getAll();
	list.forEach(x->logger.info("\033[32m{}\033[0m",x));
	}

}

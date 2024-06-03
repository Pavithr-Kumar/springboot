package com.zettamine.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zettamine.data.entities.Contact;
import com.zettamine.data.repository.ContactRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext context =	SpringApplication.run(Application.class, args);
	
	ContactRepo repo = context.getBean(ContactRepo.class);
	List<Contact> list = new ArrayList<>();
	list.add(new Contact(101,"Kiran Kumar","73837382798"));
	list.add(new Contact(102,"Harsha Vardhan","8876557598"));
	list.add(new Contact(103,"Gopi Krishna","7765363536"));
	list.add(new Contact(104,"Manoj Kumar","7787657876"));
	list.add(new Contact(105,"Raghav","73837382798"));
	list.add(new Contact(106,"Akash","8876557598"));
	list.add(new Contact(107,"Punya Koti","7765363536"));
	list.add(new Contact(108,"Shiva Mallesh","7787657876"));
	list.add(new Contact(109,"Bharath","73837382798"));
	list.add(new Contact(110,"Srikanth","8876557598"));
	list.add(new Contact(111,"Harinadh","7765363536"));
	list.add(new Contact(112,"Suresh","7787657876"));
	list.add(new Contact(113,"Suresh","9983738398"));
	
	Iterable<Contact> iterList = repo.saveAll(list);
	
	
//Contact con1 =	repo.save(new Contact(101,"Ravi Kumar","9848586878"));
	((List<Contact>) iterList).stream().forEach(x->LoggerFactory.getLogger(Application.class).info("\033[32m {}",x));
//LoggerFactory.getLogger(Application.class).info("\032[32m {}",con1);
	context.close();
	}

}

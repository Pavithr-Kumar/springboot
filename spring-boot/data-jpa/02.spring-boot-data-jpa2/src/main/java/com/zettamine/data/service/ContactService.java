package com.zettamine.data.service;

import java.util.List;

import com.zettamine.data.entities.Contact;

public interface ContactService {
	List<Contact> getContactInAscOfName();
	
	List<Contact> getContactInDescOfName();
	
	List<Contact> getAll();
	
	void printAllPages();
	
	List<Contact> getByExmpl();

}

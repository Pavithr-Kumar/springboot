package com.zettamine.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.zettamine.data.entities.Contact;

public interface ContactRepo extends CrudRepository<Contact, Integer> {

}

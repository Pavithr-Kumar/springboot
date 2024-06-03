package com.zettamine.data.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.zettamine.data.entities.Contact;

public interface ContactRepo extends CrudRepository<Contact, Serializable> {

}

package com.zettamine.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class User {
	@Value( value = "${user.fname}")
	private String firstName;
	@Value(value = "${user.lname}")
	private String lastName;
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	

}

package com.zettamine.spring.core.beans;

public class User {
	private String firstName;
	private String lastName;
	public User() {
		System.out.println("inside no args cons");
	}
	public User(String firstName, String lastName) {
		super();
		System.out.println("inside all args cons");
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		System.out.println("setter fname");
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		System.out.println("setter lastname");
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	public void myInit() {
		System.out.println("init called");
	}
	
	public void myDestroy() {
		System.out.println("Destroy called");
	}

}

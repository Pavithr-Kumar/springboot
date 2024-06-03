package com.zettamine.spring.core.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class Address {

	
	private String city;
	
	private String state;
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + "]";
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}

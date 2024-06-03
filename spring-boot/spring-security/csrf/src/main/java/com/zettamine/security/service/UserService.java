package com.zettamine.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zettamine.security.model.User;

@Service
public class UserService {
	private List<User> list = new ArrayList<>();
	
	
	public UserService() {
		list.add(new User("ravi", "ravi123"));
		list.add(new User("gowri", "gowri123"));
		list.add(new User("hari", "hari123"));
	}


	public List<User> getAllUsers() {
		return this.list;
	}
	
	public User getUserByName(String name) {
		//System.err.println("servcie");
		return this.list.stream().filter(us->us.getUsername().equals(name)).findAny().orElse(null);
	}

}

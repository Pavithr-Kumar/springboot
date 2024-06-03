package com.zettamine.spring.mi.service;

import org.springframework.stereotype.Service;

import com.zettamine.spring.mi.entities.User;
import com.zettamine.spring.mi.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	
	public boolean validateUser(User user) {
		if(userRepository.findByUserNameAndUserPassword(user.getUserName().trim(),user.getUserPassword()).isPresent())
			return true;
		return false;
	}

	public User getUserByName(String name) {
		return userRepository.findByUserName(name);
	}
}

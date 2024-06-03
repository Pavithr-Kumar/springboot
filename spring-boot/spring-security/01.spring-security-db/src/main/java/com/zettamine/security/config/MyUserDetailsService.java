package com.zettamine.security.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.zettamine.security.entity.MyUser;
import com.zettamine.security.repository.UserRepo;

@Component
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<MyUser> optional = repo.findByUsername(username);
		if(optional.isEmpty())
			throw new UsernameNotFoundException("user with "+username+" does not exist");
		else
			return User.builder()
					.username(optional.get().getUsername())
					.password(optional.get().getPassword())
					.roles(optional.get().getRoles())
					.build();
	}

}

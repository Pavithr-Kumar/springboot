package com.zettamine.spring.mi.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.spring.mi.entities.User;

public interface UserRepository extends JpaRepository<User, Serializable> {

	Optional<User> findByUserNameAndUserPassword(String userName, String userPassword);

	User findByUserName(String name);
    

}

package com.zettamine.security.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.zettamine.security.entity.MyUser;

public interface UserRepo extends  JpaRepository<MyUser, Serializable> {

	Optional<MyUser> findByUsername(String username);

}

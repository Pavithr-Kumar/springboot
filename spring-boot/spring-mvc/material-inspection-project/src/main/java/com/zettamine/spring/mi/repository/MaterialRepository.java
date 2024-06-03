package com.zettamine.spring.mi.repository;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.spring.mi.entities.Material;

public interface MaterialRepository extends JpaRepository<Material, Serializable> {

	//List<Material> findAllByMaterialId();

}

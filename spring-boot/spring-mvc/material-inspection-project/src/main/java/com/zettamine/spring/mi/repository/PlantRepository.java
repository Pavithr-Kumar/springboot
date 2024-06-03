package com.zettamine.spring.mi.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.spring.mi.entities.Plant;


public interface PlantRepository extends JpaRepository<Plant, Serializable>  {

	

	List<Plant> findAllByPlantActiveStatus(String string);
}

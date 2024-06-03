package com.zettamine.spring.mi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.spring.mi.entities.MaterialInspectionCharacteristics;

public interface InspectionCharacteristicsRepository extends JpaRepository<MaterialInspectionCharacteristics, Serializable> {

}

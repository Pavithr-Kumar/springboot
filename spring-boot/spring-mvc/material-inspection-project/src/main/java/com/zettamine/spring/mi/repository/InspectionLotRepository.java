package com.zettamine.spring.mi.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zettamine.spring.mi.entities.InspectionLot;



public interface InspectionLotRepository extends JpaRepository<InspectionLot, Serializable> {

//	List<InspectionLot> finAllByInspStartDateBetweenInspEndtDate(LocalDate startDate, LocalDate endDate);

	List<InspectionLot> findAllByInspStartDateBetween(LocalDate startDate, LocalDate endDate);

//	List<InspectionLot> findAllionLotId();

}

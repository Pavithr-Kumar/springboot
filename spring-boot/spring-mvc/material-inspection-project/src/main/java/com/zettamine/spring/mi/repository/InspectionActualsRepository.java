package com.zettamine.spring.mi.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zettamine.spring.mi.entities.InspectionActuals;

public interface InspectionActualsRepository extends JpaRepository<InspectionActuals, Serializable> {
	
	@Query(value =  "select  a.lot_id  from isp_act  a inner join mtrl_insp_char  b on a.ch_id= b.characteristic_id\r\n"
			+ "where a.actual_max_measure <= b.characteristic_tol_upper_limit \r\n"
			+ " and a.actual_min_measure  >=    b.characteristic_tol_lower_limit;"
			, nativeQuery = true)
	public List<Integer> getAllLotsWhichSatisfyLimits();
	
	@Query(value = "select * from isp_act where lot_id=:id",nativeQuery = true)
	public List<InspectionActuals> findByIspLot(Integer id);

}

package com.zettamine.spring.mi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.zettamine.spring.mi.entities.InspectionLot;
import com.zettamine.spring.mi.model.LotSearchCriteria;
import com.zettamine.spring.mi.repository.InspectionLotRepository;

@Service
public class InspectionLotService {
	private InspectionLotRepository inspectioLotrepository;

	public InspectionLotService(InspectionLotRepository inspectioLotrepository) {
		super();
		this.inspectioLotrepository = inspectioLotrepository;

	}

	public void saveLot(InspectionLot ispLot) {
		inspectioLotrepository.save(ispLot);
	}

	public List<InspectionLot> getAllLots() {
		inspectioLotrepository.findAll().stream().forEach(x -> System.err.println(x));
		return inspectioLotrepository.findAll();
	}

	public InspectionLot getIspLotById(Integer id) {
		return inspectioLotrepository.findById(id).get();
	}

//	public Map<Integer, Integer> getAddUpdateMap() {
//		Map<Integer,Integer> addUpdateMap= new HashMap<>();
//		List<InspectionLot> ispLots = inspectioLotrepository.findAll();
//	
//		int count=0;
//		for (InspectionLot lot : ispLots) {
//			Integer flag=0;
//			count=0;
//			for(MaterialInspectionCharacteristics ch:lot.getMaterial().getInspectionCharacteristics()) {
//				if(ch.getIspActuals().size()!=0)
//					count++;
//			}
//			if(lot.getMaterial().getInspectionCharacteristics().size()==count)
//				flag=1;
//			addUpdateMap.put(lot.getInspectionLotId(), flag);
//		}
//		System.err.println(addUpdateMap+" --> ISPLOT Service");
//		return addUpdateMap;
//	}

	public List<InspectionLot> getListOfLotsById(Integer id) {
		List<InspectionLot> list = new ArrayList<>();
		list.add(inspectioLotrepository.findById(id).get());
		return list;
	}

	public List<InspectionLot> findLotByCriteria(LotSearchCriteria criteria) {
		//System.err.println(criteria);
		List<InspectionLot> list = inspectioLotrepository
				.findAllByInspStartDateBetween(criteria.getStartDate(), criteria.getEndDate())
				.stream()
				
				.filter(lot -> {
					if (criteria.getMaterilaNo().equals("")) 
						return true;
					return lot.getMaterial().getMaterialId().equals(criteria.getMaterilaNo());})
				
				.filter(lot -> {
					if (criteria.getPlantId().equals("")) 
						return true;
						return lot.getPlant().getPlantId().equals(criteria.getPlantId());})
				
				.filter(lot -> {
					if (criteria.getResult() != null) 
						return lot.getInspectionResult().equals(criteria.getResult());
					return true;})
				.collect(Collectors.toList());
	//	System.err.println(list);
		return list;
	}

}

package com.zettamine.spring.mi.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.zettamine.spring.mi.entities.InspectionActuals;
import com.zettamine.spring.mi.entities.InspectionLot;
import com.zettamine.spring.mi.entities.Material;
import com.zettamine.spring.mi.entities.MaterialInspectionCharacteristics;
import com.zettamine.spring.mi.model.Actual;
import com.zettamine.spring.mi.repository.InspectionActualsRepository;
import com.zettamine.spring.mi.repository.InspectionCharacteristicsRepository;
import com.zettamine.spring.mi.repository.InspectionLotRepository;

@Service
public class InspectionActualsService {
	private InspectionActualsRepository actualsRepository;
	
    private InspectionLotRepository inspectionLotRepository;
    
	public InspectionActualsService(InspectionActualsRepository actualsRepository,
			InspectionCharacteristicsRepository characteristicsRepository,
			InspectionLotRepository inspectionLotRepository) {
		super();
		this.actualsRepository = actualsRepository;
		
		this.inspectionLotRepository = inspectionLotRepository;
		
	}

	public List<InspectionActuals> getAllIspActuals(){
		return actualsRepository.findAll();
	}
	
	public void saveIspActuals(InspectionActuals actuals,String endDate) {
		
		 actualsRepository.save(actuals);
		if(endDate.equals("true")) {
			
			saveInspLotAfterInsp(inspectionLotRepository.findById(actuals.getIspLot().getInspectionLotId()).get());
		}
		
	}
	
	public Map<Integer,Long> getLotsSatisfyingLimits(){
		 
		List<Integer> list = actualsRepository.getAllLotsWhichSatisfyLimits();
		Map<Integer,Long> tolerenceMap=	list.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
		List<InspectionLot> ispLotlist = inspectionLotRepository.findAll();
		return tolerenceMap;
	}

	public List<MaterialInspectionCharacteristics> getCorrespondingChar(List<InspectionActuals> actuals,Material material) {
		//System.err.println(actuals+" "+actuals);
		if(actuals.size()==0)
			return material.getInspectionCharacteristics();
		
		Map<Integer,MaterialInspectionCharacteristics > actualMap = new HashMap<>();
		for(InspectionActuals actual:actuals) {
			actualMap.put(actual.getIspCharacteristics().getCharacteristicId(), actual.getIspCharacteristics());
		}
		
		List<MaterialInspectionCharacteristics> list= new ArrayList<>();
//		List<Integer> charListIds = material.getInspectionCharacteristics().stream().map(ch->ch.getCharacteristicId()).collect(Collectors.toList());
		material.getInspectionCharacteristics().stream().forEach(ch->{
			if(!actualMap.containsKey(ch.getCharacteristicId()))
		     list.add(ch);
		});
		
		return list;
	}
	
	public void saveInspLotAfterInsp(InspectionLot lot) {
		lot.setInspEndtDate(Date.valueOf(LocalDate.now()));
		lot.setInspectionResult("Insp Completed");
		Map<Integer,Long> toleMap=getLotsSatisfyingLimits();
		System.err.println(toleMap+"\\\\\\\\\\\\\\\\\\");
		
		if(lot.getMaterial().getInspectionCharacteristics().size()==lot.getIspActuals().size()) {
			if(toleMap.containsKey(lot.getInspectionLotId()) && ( toleMap.get(lot.getInspectionLotId())==lot.getMaterial().getInspectionCharacteristics().size())) {
				lot.setInspectionResult("PASS");
			}
			
			inspectionLotRepository.save(lot);
		}
	}
	
	public Map<String,Actual> getInspActById(Integer id) {
		List<InspectionActuals> insActList =  actualsRepository.findByIspLot(id);
		Map<String,Actual> resultMap= new HashMap<>();
		//InspectionLot lot= insActList.get(0).getIspLot();
		insActList.forEach(act->{
			Actual actualObj = new Actual();
			actualObj.setIspLot(act.getIspLot());
			actualObj.setUpperTol(act.getIspCharacteristics().getCharacteristicTolUpperLimit());
			actualObj.setLowerTol(act.getIspCharacteristics().getCharacteristicTolLowerLimit());
			actualObj.setActualMax(act.getActualMaxMeasure());
			actualObj.setActualMin(act.getActualMinMeasure());
			actualObj.setCharUom(act.getIspCharacteristics().getCharacteristicUOM());
			resultMap.put(act.getIspCharacteristics().getCharacteristicDescription(), actualObj);
			System.err.println(actualObj);
			
		});
		//System.out.println(resultMap);
	//resultMap.keySet().stream().forEach(ch->System.err.println(resultMap.get(ch).getUpperTol()+" | "+resultMap.get(ch).getActualMax()));
		return resultMap;
	}
}

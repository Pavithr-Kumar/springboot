package com.zettamine.spring.mi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zettamine.spring.mi.entities.Material;
import com.zettamine.spring.mi.entities.MaterialInspectionCharacteristics;
import com.zettamine.spring.mi.repository.InspectionCharacteristicsRepository;
import com.zettamine.spring.mi.repository.MaterialRepository;

@Service
public class MaterialService {
private MaterialRepository materialRepository;
private InspectionCharacteristicsRepository inspectionCharRepository;

public MaterialService(MaterialRepository materialRepository,InspectionCharacteristicsRepository inspectionCharRepository) {
	super();
	this.materialRepository = materialRepository;
	this.inspectionCharRepository=inspectionCharRepository;
	
}
public void addNewMaterial(Material material) {
	materialRepository.save(material);
}

public List<Material> getAllMaterials(){
	return materialRepository.findAll();
}

//public void deleteMaterial(Integer materialId) {
//	Material material = materialRepository.findById(materialId).get();
//	material.setMaterialActiveStatus("NO");
//	materialRepository.save(material);
//	
//}

public void updateMaterial(Material material) {
	materialRepository.save(material);
	
}

public Material getMaterialById(String materialId) {
	
	return materialRepository.findById(materialId).get();
}

public Material getMaterialWithInspectionCharacteristics(Material material, Integer noOfCh) {
	List<MaterialInspectionCharacteristics> list = new ArrayList<>();
	for(int i=0;i<noOfCh;i++) {
		list.add(new MaterialInspectionCharacteristics());
	}
	material.setInspectionCharacteristics(list);
	return material;
}

public Material getTwoWayBindedMaterial(Material material) {
	
	material.getInspectionCharacteristics().stream().forEach(x->x.setMaterial(material));
	return material;
}

public List<MaterialInspectionCharacteristics> getAllCharacteristics(){
	return inspectionCharRepository.findAll();
}


@SuppressWarnings("unused")
private String getNextMaterialId() {
	String materialId="";
	Long count= materialRepository.count();
	if(count==0) {
		return materialId+"M-01";
	}
	if(count<10)
		return materialId="M-0"+count;
	return materialId="M-"+count;
}

}

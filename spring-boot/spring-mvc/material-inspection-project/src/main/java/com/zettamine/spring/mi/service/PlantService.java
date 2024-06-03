package com.zettamine.spring.mi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zettamine.spring.mi.entities.Plant;

import com.zettamine.spring.mi.repository.PlantRepository;

@Service
public class PlantService {

	private PlantRepository plantRepository;

	public PlantService(com.zettamine.spring.mi.repository.PlantRepository plantRepository) {
		super();
		this.plantRepository = plantRepository;
	}
	
	public void addNewPlant(Plant plant) {
		plantRepository.save(plant);
	}
	
	public List<Plant> getAllPlants(){
		return plantRepository.findAllByPlantActiveStatus("YES");
	}
	
	public void deletePlant(Integer plantId) {
		Plant plant = plantRepository.findById(plantId).get();
		plant.setPlantActiveStatus("NO");
		plantRepository.save(plant);
		
	}

	public void updatePlant(Plant plant) {
		plantRepository.save(plant);
		
	}

	public Plant getPlantById(String plantId) {
		
		return plantRepository.findById(plantId).get();
	}
}

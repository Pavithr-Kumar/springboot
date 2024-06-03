package com.zettamine.spring.mi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zettamine.spring.mi.constants.AppConstants;
import com.zettamine.spring.mi.entities.Plant;
import com.zettamine.spring.mi.service.PlantService;

	@Controller
	@RequestMapping("/zetta")
	public class PlantController {
		private PlantService plantService;
		
		
		public PlantController(PlantService plantService) {
			super();
			this.plantService = plantService;
		}

		@GetMapping("/plant")
		public String showPlantStarter() {
			return AppConstants.PLANT_VIEW;
		}
		
		@GetMapping("/plant/new")
		public String addPlant(Model model){
			
			model.addAttribute("plant", new Plant());
			return AppConstants.PLANT_FORM_VIEW;
		}
		
		@PostMapping("/plant/add")
		public String getPlant(Plant plant) {
			if(plant.getPlantId()==null)
			    plantService.addNewPlant(plant);
			else
				plantService.updatePlant(plant);
			
			return AppConstants.PLANT_VIEW;
		}
		
		@GetMapping("/plant/edit")
		public String updatePlant(Model model,@RequestParam String plantId) {
			model.addAttribute("plant", plantService.getPlantById(plantId));
			return AppConstants.PLANT_FORM_VIEW;
		}
		
		@GetMapping("/plant/show-all")
		public String showAllPlants(Model model) {
			model.addAttribute("plants",plantService.getAllPlants());
			return AppConstants.PLANT_VIEW;
		}
		
		@GetMapping("/plant/delete")
		public String deletePlant(@RequestParam Integer plantId) {
			plantService.deletePlant(plantId);
			return "redirect:show-all";
		}
		

}


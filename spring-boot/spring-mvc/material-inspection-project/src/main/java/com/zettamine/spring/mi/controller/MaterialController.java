package com.zettamine.spring.mi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zettamine.spring.mi.constants.AppConstants;
import com.zettamine.spring.mi.entities.Material;
import com.zettamine.spring.mi.service.MaterialService;


	@Controller
	@RequestMapping("/zetta")
	public class MaterialController {
		private MaterialService materialService;
		
		
		public MaterialController(MaterialService materialService) {
			super();
			this.materialService = materialService;
		}

		@GetMapping("/material")
		public String showPlantStarter() {
			return AppConstants.MATERIAL_VIEW;
		}
		
		@GetMapping("/material/new")
		public String addPlant(Model model){
			
			model.addAttribute("material", new Material());
			return AppConstants.MATERIAL_FORM_VIEW;
		}
		
		@PostMapping("/material/add")
		public String getPlant(Material material) {
				materialService.updateMaterial(material);
			
			return AppConstants.MATERIAL_VIEW;
		}
		
		@GetMapping("/material/edit")
		public String updatePlant(Model model,@RequestParam String materialId) {
			model.addAttribute("material", materialService.getMaterialById(materialId));
			return AppConstants.MATERIAL_FORM_VIEW;
		}
		
		@GetMapping("/material/show-all")
		public String showAllPlants(Model model) {
			model.addAttribute("materials",materialService.getAllMaterials());
			return AppConstants.MATERIAL_VIEW;
		}
		
		
//		@GetMapping("/material/delete")
//		public String deletePlant(@RequestParam Integer materialId) {
//			materialService.deletePlant(materialId);
//			return "redirect:show-all";
//		}
		
		/*--------------Count of Characteristics-----------*/ 	
		@GetMapping("/material/add-new-characteristics")
		public String addNewCharacteristicsWithCount(Model model) {
			model.addAttribute("materials", materialService.getAllMaterials());
			return AppConstants.CHARACTERISTICS_COUNT_FORM_VIEW;
		}
		
		@PostMapping("/material/get-characteristics-form")
		public String getCHaracteristicsForm(@RequestParam String materialId,@RequestParam Integer noOfCharacteristics,RedirectAttributes redirectAttributes){
			redirectAttributes.addFlashAttribute("material", 
					materialService.getMaterialWithInspectionCharacteristics(materialService.getMaterialById(materialId), noOfCharacteristics));
			
			return "redirect:add-characteristics";
		}
		
		/*--------------Actual Characteristics-----------*/
		@PostMapping("/material/add-characteristics")
		public String addCharacteristics(Material material, RedirectAttributes redirectAttributes) {
			System.err.println(material);
			System.err.println(materialService.getTwoWayBindedMaterial(material));
			materialService.addNewMaterial(material);
			
			return "redirect:show-all-characteristics";
		}
		
		
		@GetMapping("/material/add-characteristics")
		public String addNewCharacteristics(Model model,RedirectAttributes redirectAttributes) {

			return AppConstants.CHARACTERISTICS_FORM_VIEW;
		}
		
		@GetMapping("/material/show-all-characteristics")
		public String showAllCharacteristics(Model model) {
			model.addAttribute("characteristics",materialService.getAllCharacteristics() );
			return AppConstants.CHARACTERISTICS_VIEW;
		}
		
		@GetMapping("/material/characteristics")
		public String showCharacteristics(Model model) {
			
			return AppConstants.CHARACTERISTICS_VIEW;
		}
		
		@GetMapping("/material/charcteristics/view")
		public String showCharacteristicsOfMaterial(@RequestParam String materialId,Model model) {
			model.addAttribute("characteristics", materialService.getMaterialById(materialId).getInspectionCharacteristics());
			return AppConstants.CHARACTERISTICS_VIEW;
		}
		
		
		

}


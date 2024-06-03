package com.zettamine.spring.mi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zettamine.spring.mi.constants.AppConstants;
import com.zettamine.spring.mi.entities.InspectionActuals;
import com.zettamine.spring.mi.entities.InspectionLot;
import com.zettamine.spring.mi.service.InspectionActualsService;
import com.zettamine.spring.mi.service.InspectionLotService;
import com.zettamine.spring.mi.service.MaterialService;
import com.zettamine.spring.mi.service.PlantService;
import com.zettamine.spring.mi.service.UserService;
import com.zettamine.spring.mi.service.VendorService;

@Controller
@RequestMapping("/zetta/isp-lot")
public class ActualsController {
	private UserService userService;
	private MaterialService materialService;
	private VendorService vendorService;
	private PlantService plantService;
	private InspectionLotService inLotService;
	private InspectionActualsService actualsService;
	
	public ActualsController(MaterialService materialService, VendorService vendorService,
			PlantService plantService, InspectionLotService inLotService,
			UserService userService, InspectionActualsService actualsService) {
		super();
		this.materialService = materialService;
		this.vendorService = vendorService;
		this.plantService = plantService;
		this.inLotService = inLotService;
		this.userService=userService;
		this.actualsService=actualsService;
	}
	
	
	@GetMapping("/actuals/add")
	public String getActualFormData(@RequestParam Integer isplotId,Model model) {
		model.addAttribute("ispact", new InspectionActuals());
		InspectionLot lot = inLotService.getIspLotById(isplotId);
		model.addAttribute("charList",actualsService.getCorrespondingChar(lot.getIspActuals(),lot.getMaterial()));
		model.addAttribute("isplot", inLotService.getIspLotById(isplotId));
		return AppConstants.ACTUALS_FORM;
	}
	
	@PostMapping("/actuals/add")
	public String getActualMeasuresData(InspectionActuals ispActuals, Model model,@RequestParam(required = false,defaultValue = "false") String endDate) {
		
		actualsService.saveIspActuals(ispActuals, endDate);	
		model.addAttribute("actuals",actualsService.getInspActById(ispActuals.getIspLot().getInspectionLotId()));
	
		return AppConstants.ACTUALS_VIEW;
	}
	
	@GetMapping("/actuals/show-all")
	public String getAllActuals(Model model) {
		
		model.addAttribute("actuals", actualsService.getAllIspActuals());
		
		return AppConstants.ACTUALS_VIEW;
	}
	
	
	
	

}

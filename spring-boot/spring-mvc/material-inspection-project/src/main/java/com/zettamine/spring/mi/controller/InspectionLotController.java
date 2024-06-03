package com.zettamine.spring.mi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zettamine.spring.mi.constants.AppConstants;
import com.zettamine.spring.mi.entities.InspectionLot;
import com.zettamine.spring.mi.model.LotSearchCriteria;
import com.zettamine.spring.mi.service.InspectionActualsService;
import com.zettamine.spring.mi.service.InspectionLotService;
import com.zettamine.spring.mi.service.MaterialService;
import com.zettamine.spring.mi.service.PlantService;
import com.zettamine.spring.mi.service.UserService;
import com.zettamine.spring.mi.service.VendorService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/zetta")
public class InspectionLotController {
	private UserService userService;
	private MaterialService materialService;
	private VendorService vendorService;
	private PlantService plantService;
	private InspectionLotService inLotService;
	private InspectionActualsService actualsService;
	
	public InspectionLotController(MaterialService materialService, VendorService vendorService,
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
	
	@GetMapping("/isp-lot")
	public String goToInspectionLots() {
		return AppConstants.ISP_LOT_VIEW;
		
		
	}

	@GetMapping("/isp-lot/add")
	public String addNewInspectionLot(Model model) {
		model.addAttribute("materials",materialService.getAllMaterials() );
		model.addAttribute("plants", plantService.getAllPlants());
		model.addAttribute("vendors", vendorService.getAllVendors());
		model.addAttribute("isplot", new InspectionLot());
		return AppConstants.ISP_LOT_FORM;
	}
	
	@PostMapping("/isp-lot/add")
	public String getDataFromIspLotForm(@ModelAttribute InspectionLot ispLot,Model model,HttpSession session){
		if(userService.getUserByName(((String)session.getAttribute("user")))==null)
			return "redirect:login";
		ispLot.setUser(userService.getUserByName(((String)session.getAttribute("user"))));
		ispLot.setInspectionResult("Insp Started");
		System.err.println(ispLot);
		inLotService.saveLot(ispLot);
		return "redirect:show-all";
	}
	
	@GetMapping("/isp-lot/show-all")
	public String showAllLots(Model model) {
		model.addAttribute("ispLots", inLotService.getAllLots());
		System.err.println(actualsService.getLotsSatisfyingLimits());
		model.addAttribute("toleranceMap", actualsService.getLotsSatisfyingLimits());
		//model.addAttribute("lotFlagForActuals", inLotService.getAddUpdateMap());
		 return AppConstants.ISP_LOT_VIEW;
	}
	
	@PostMapping("/isp-lot/search")
	public String getLotById(@RequestParam("lotId") String lotId,Model model) {
		Integer id;
		try {
			id=Integer.parseInt(lotId);
			System.err.println(id);
				model.addAttribute("ispLots", inLotService.getIspLotById(id));
				System.err.println();
			      
		}catch(NoSuchElementException e){
			System.err.println(e);
			model.addAttribute("errMsg", "No Lots Found with id: "+lotId);
		}catch(Exception e){
		System.err.println(e);
		model.addAttribute("errMsg", "Only Numbers are allowed");
	}
		return AppConstants.ISP_LOT_VIEW;
	}
	
	@GetMapping("/isp-lot/actuals/show")
	public String showActualsById(@RequestParam Integer isplotId, Model model) {
		model.addAttribute("actuals", actualsService.getInspActById(isplotId));
		return AppConstants.ACTUALS_VIEW;
	}
	
	@GetMapping("/isp-lot/edit")
	public String addStage2LotDetails(Model model,@RequestParam Integer isplotId) {
		model.addAttribute("isplot",inLotService.getIspLotById(isplotId) );
		return AppConstants.ISP_LOT_FORM;
	}
	
	@PostMapping("/isp-lot/edit")
	public String saveStage2LotDetails(@RequestParam String result,@RequestParam String remarks,@RequestParam Integer inspectionLotId, HttpSession session) {
		InspectionLot lot = inLotService.getIspLotById(inspectionLotId);
		if(userService.getUserByName(((String)session.getAttribute("user")))==null)
			return "redirect:login";
		lot.setUser(userService.getUserByName(((String)session.getAttribute("user"))));
		lot.setInspectionRemarks(remarks);
		lot.setInspectionResult(result);
		inLotService.saveLot(lot);
		return AppConstants.ISP_LOT_VIEW;
	}
	
	@GetMapping("/isp-lot/find")
	public String getLotForm(Model model) {
		model.addAttribute("searchCriteria", new LotSearchCriteria());
		return AppConstants.LOT_SEARCH_FORM;
	}
	
	@PostMapping("/isp-lot/find")
	public String searchLot(LotSearchCriteria criteria,Model model) {
		
		model.addAttribute("ispLots", inLotService.findLotByCriteria(criteria));
		return AppConstants.ISP_LOT_VIEW;
	}

}

package com.zettamine.spring.mi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zettamine.spring.mi.constants.AppConstants;
import com.zettamine.spring.mi.entities.User;
import com.zettamine.spring.mi.service.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/zetta")
public class UserController {
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	/*-----------Login details validation----------*/
	@PostMapping("/login")
	public String validateLogin(
			                    //   @Valid User user,
			                     User user,
			                    HttpSession session,
			                    BindingResult results) {
		if(results.hasErrors()) {
			return AppConstants.LOGIN_VIEW;
		}
		
		session.setAttribute("user", user.getUserName().trim());
		if(userService.validateUser(user)) {
			
			return "redirect:home";
		}
		return "redirect:login";
	}
	
	@GetMapping("/login")
	public String invalidCredentials(Model model,HttpSession session) {
		String user =(String) session.getAttribute("user");
		model.addAttribute("user",new User());
		if(user==null) {
			return AppConstants.LOGIN_VIEW;
		}
		session.removeAttribute("user");
		model.addAttribute("message", "Invalid Login Credentials!! TRY AGAIN");
		return AppConstants.LOGIN_VIEW;
	}
	
	@GetMapping("/home")
	public String showHome() {
		return AppConstants.INDEX_VIEW;
	}

}

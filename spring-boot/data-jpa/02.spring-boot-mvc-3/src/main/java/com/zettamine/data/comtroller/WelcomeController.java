package com.zettamine.data.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@RequestMapping("/welcome")
	public ModelAndView show() {
		ModelAndView m = new ModelAndView();
		m.setViewName("welcome");
		m.addObject("message","Welcome to zettamine");
		return m;
	}

}

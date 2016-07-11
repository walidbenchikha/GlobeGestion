package com.globe.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(ModelMap model){
		System.out.println("in login method");
		return "login";
		
	}
	
	@RequestMapping(value="/loginFailed", method=RequestMethod.GET)
	public String loginFailed(ModelMap model){
		System.out.println("in login failed");
		model.addAttribute("error", "true");
		return "login";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(ModelMap model){
		System.out.println("in logout method");
		return "login";
	}
	
	@RequestMapping(value="/403", method=RequestMethod.GET)
	public String error403(ModelMap model){
		System.out.println("in 403 method");
		return "403";
	}
	

}


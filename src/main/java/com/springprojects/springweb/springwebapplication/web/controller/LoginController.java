package com.springprojects.springweb.springwebapplication.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springprojects.springweb.springwebapplication.web.service.LoginService;

//This is a controller
@Controller
public class LoginController {
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showloginMessage(ModelMap model) {
		return "/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showWelcomMessage(ModelMap model, @RequestParam String name, String password) {
		model.put("name", name);
		model.put("password", password);
		if (loginService.validateUser(name, password)) {
			return "/welcome";
		} else {
			model.put("errorMessage", "Invalid Credentails");
			return "/login";
		}

	}
}

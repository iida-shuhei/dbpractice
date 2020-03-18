package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.UserRegisterForm;
import com.example.service.UserRegisterService;

@Controller
@RequestMapping("")
public class UserRegisterController {

	@Autowired
	private UserRegisterService userRegisterService;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "toRegister";
	}
	
	@RequestMapping("/register")
	public String register(UserRegisterForm userRegisterForm) {
		userRegisterService.insert(userRegisterForm);
		return "redirect:/";
	}
}

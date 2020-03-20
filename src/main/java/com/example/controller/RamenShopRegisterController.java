package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.form.RamenShopRegisterForm;
import com.example.service.RamenShopRegisterService;

/**
 * ラーメン店舗を管理するコントローラー.
 * 
 * @author iidashuhei
 *
 */
@Controller
@RequestMapping("/ramenShop")
public class RamenShopRegisterController {

	@Autowired
	private RamenShopRegisterService ramenShopRegisterService;
	
	@ModelAttribute
	public RamenShopRegisterForm setUpForm() {
		return new RamenShopRegisterForm();
	}
	
	/**
	 * ラーメン店舗を登録する.
	 * 
	 * @return HTML
	 */
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "register_ramenShop";
	}
	
	@RequestMapping("/register")
	public String register(RamenShopRegisterForm ramenShopRegisterForm) {
		ramenShopRegisterService.insert(ramenShopRegisterForm);
		return "redirect:/ramen/toInsert";
	}
}

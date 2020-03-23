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
	 * ラーメン店舗を登録する画面へ遷移する.
	 * 
	 * @return 登録画面へ遷移
	 */
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "register_ramenShop";
	}
	
	/**
	 * ラーメン店舗を登録する.
	 * 
	 * @param ramenShopRegisterForm ラーメン店舗を登録するフォーム
	 * @return ラーメンを登録する画面
	 */
	@RequestMapping("/register")
	public String register(RamenShopRegisterForm ramenShopRegisterForm) {
		ramenShopRegisterService.insert(ramenShopRegisterForm);
		return "redirect:/ramen/toInsert";
	}
}

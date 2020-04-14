package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.LoginUser;
import com.example.form.RamenShopRegisterForm;
import com.example.repository.RamenImageRepository;
import com.example.repository.RamenShopTimeRepository;
import com.example.service.RamenShopRegisterService;
import com.example.service.RamenShopService;

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
	public RamenImageRepository ramenImageRepository;

	@Autowired
	public RamenShopTimeRepository ramenShopTimeRepository;
	
	@Autowired
	private RamenShopRegisterService ramenShopRegisterService;
	
	@Autowired
	public RamenShopService ramenShopService;
	
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
	public String register(RamenShopRegisterForm ramenShopRegisterForm,@AuthenticationPrincipal LoginUser loginUser) {
		ramenShopRegisterService.insert(ramenShopRegisterForm,loginUser);
		return "redirect:/ramenShopSearch";
	}
}
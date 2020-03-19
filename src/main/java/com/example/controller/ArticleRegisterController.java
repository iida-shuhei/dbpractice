package com.example.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.ArticleRegisterForm;
import com.example.service.RamenShopRegisterService;

/**
 * ラーメン店舗を管理するリポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Controller
@RequestMapping("/ramen")
public class ArticleRegisterController {

	@Autowired
	private RamenShopRegisterService ramenShopRegisterService;
	
	/**
	 * 入力値を受け取るフォーム.
	 * 
	 * @return 記事フォーム
	 */
	@ModelAttribute
	private ArticleRegisterForm setUpForm() {
		return new ArticleRegisterForm();
	}
	
	/**
	 * 記事投稿画面へ遷移.
	 * 
	 * @return 記事投稿画面
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "insert_article";
	}
	
	@RequestMapping("/insert")
	public String insert(@Validated ArticleRegisterForm articleRegisterForm, BindingResult result) throws IOException {
		ramenShopRegisterService.insert(articleRegisterForm);
		return "redirect:/";
	}
}

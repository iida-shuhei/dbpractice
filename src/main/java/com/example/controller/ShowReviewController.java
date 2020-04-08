package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.RamenShop;
import com.example.domain.Review;
import com.example.form.ReviewRegisterForm;
import com.example.repository.ReviewRepository;
import com.example.service.RamenShopService;

/**
 * 記事管理するリポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Controller
@RequestMapping("/showReview")
public class ShowReviewController {
	
	@Autowired
	public ReviewRepository reviewRepository;
	
	@Autowired
	public RamenShopService ramenShopService;
	
	/**
	 * 入力値を受け取るフォーム.
	 * 
	 * @return 記事フォーム
	 */
	@ModelAttribute
	private ReviewRegisterForm setUpForm() {
		return new ReviewRegisterForm();
	}

	/**
	 * トップページを表示する.
	 * 
	 * @param model モデル
	 * @return トップページ
	 */
	@RequestMapping("")
	public String index(Model model) {
		List<Review> reviewList = reviewRepository.findAll();
		model.addAttribute("reviewList", reviewList);
		return "review_list";
	}
	
	/**
	 * 記事投稿画面へ遷移.
	 * 
	 * @return 記事投稿画面
	 */
	@RequestMapping("/toInsert")
	public String toInsert(Integer shopId, Model model) {
		if(shopId != null) {
			RamenShop ramenShop = ramenShopService.load(shopId);
			model.addAttribute("ramenShop", ramenShop);
		}
		return "insert_article";
	}

}

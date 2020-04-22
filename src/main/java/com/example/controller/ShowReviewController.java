package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Comment;
import com.example.domain.LoginUser;
import com.example.domain.RamenShop;
import com.example.domain.Review;
import com.example.domain.User;
import com.example.form.ReviewRegisterForm;
import com.example.repository.CommentRepository;
import com.example.repository.ReviewRepository;
import com.example.service.RamenShopService;
import com.example.service.UserService;

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
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommentRepository commentRepository;

	
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
	public String index(Integer start, Model model,@AuthenticationPrincipal LoginUser loginUser) {
		// Maxページ数を求める
		Integer count = reviewRepository.countAllReview(loginUser.getUser().getUserId());
		
		//何番目から表示するかを求める
		if (start == null) {
			start = 0;
		};
		
		List<Review> reviewList = reviewRepository.findAll(start);
		if(reviewList.isEmpty()) {
			model.addAttribute("message", "誰も投稿していないようだ…");
		}
		for(Review review : reviewList) {
			List<Comment> commentList = commentRepository.findByReviewId(review.getReviewId());
			review.setCommentList(commentList);
		}
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("start", start);
		model.addAttribute("count", count);
		
		User user = userService.findByUserId(loginUser.getUser().getUserId());
		model.addAttribute("user", user);
		model.addAttribute("message","投稿されたラーメン記事");
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
package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Favorite;
import com.example.domain.LoginUser;
import com.example.domain.Review;
import com.example.domain.User;
import com.example.repository.FavoriteRepository;
import com.example.repository.ReviewRepository;
import com.example.service.UserService;

/**
 * お気に入りを管理するコントローラー.
 * 
 * @author iidashuhei
 *
 */
@Controller
@RequestMapping("/favorite")
public class FavoriteController {

	@Autowired
	private FavoriteRepository favoriteRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	/**
	 * レビューをお気に入りに登録か削除をする.
	 * 
	 * @param reviewId レビューID
	 * @param loginUser ログインユーザー
	 * @return レビュー詳細
	 */
	@RequestMapping("")
	public String registerOrDelete(Integer reviewId, @AuthenticationPrincipal LoginUser loginUser) {
		List<Favorite> favoriteList = favoriteRepository.findByUserIdAndReviewId(loginUser.getUser().getUserId(), reviewId);
		if(favoriteList.size() == 0) {
			favoriteRepository.register(loginUser.getUser().getUserId(), reviewId);
		} else {
			favoriteRepository.delete(loginUser.getUser().getUserId(), reviewId);
		}
		return "redirect:/detail?reviewId=" + reviewId;
	}
	
	/**
	 * ユーザーのお気に入りリストを参照する.
	 * 
	 * @param loginUser ログインユーザー
	 * @param model モデル
	 * @return お気に入りリスト
	 */
	@RequestMapping("/showFavoriteList")
	public String showFavoriteList(@AuthenticationPrincipal LoginUser loginUser, Integer start, Model model) {
		// Maxページ数を求める
		Integer count = reviewRepository.countFavoriteReview(loginUser.getUser().getUserId());

		//何番目から表示するかを求める
		if (start == null) {
			start = 0;
		};
		
		List<Review> reviewList = reviewRepository.findFavoriteReview(loginUser.getUser().getUserId(), start);
		if(reviewList.size() == 0) {
			String message = "お気に入りリストがまだ登録されていません";
			model.addAttribute("message", message);
		}
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("start", start);
		model.addAttribute("count", count);
		
		User user = userService.findByUserId(loginUser.getUser().getUserId());
		model.addAttribute("user", user);
		return "favorite_list";
	}
	
	/**
	 * ログインしていないユーザーのお気に入りリストを参照する.
	 * 
	 * @param loginUser ログインユーザー
	 * @param model モデル
	 * @return お気に入りリスト
	 */
	@RequestMapping("/notUserFavoriteList")
	public String notUserFavoriteList(Integer userId, @AuthenticationPrincipal LoginUser loginUser, Integer start, Model model) {
		
		if(userId == loginUser.getUser().getUserId()) {
			return "redirect:/favorite/showFavoriteList";
		}
		
		// Maxページ数を求める
		Integer count = reviewRepository.countFavoriteReview(userId);
		
		//何番目から表示するかを求める
		if (start == null) {
			start = 0;
		};
		
		List<Review> reviewList = reviewRepository.findFavoriteReview(userId, start);
		if(reviewList.size() == 0) {
			String message = "お気に入りリストがまだ登録されていません";
			model.addAttribute("message", message);
		}
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("start", start);
		model.addAttribute("count", count);
		
		User user = userService.findByUserId(loginUser.getUser().getUserId());
		model.addAttribute("user", user);
		
		User notUser = userService.findByUserId(userId);
		model.addAttribute("notUser", notUser);
		return "notuser_favorite_list";
	}
}
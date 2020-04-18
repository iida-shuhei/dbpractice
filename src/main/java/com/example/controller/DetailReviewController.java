package com.example.controller;

import java.sql.Timestamp;
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
import com.example.service.ReviewService;
import com.example.service.UserService;

/**
 * レビュー詳細を管理するコントローラー.
 * 
 * @author iidashuhei
 *
 */
@Controller
@RequestMapping("/detail")
public class DetailReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FavoriteRepository favoriteRepository;
	
	/**
	 * レビューIDからレビュー詳細を表示する.
	 * 
	 * @param reviewId レビューID
	 * @param model モデル
	 * @return レビュー詳細画面
	 */
	@RequestMapping("")
	public String load(Integer reviewId, Model model,@AuthenticationPrincipal LoginUser loginUser) {
		Review review = reviewService.load(reviewId);
		List<Review> reviewMondayList = reviewService.findByMonday(reviewId);
		List<Review> reviewTuesdayList = reviewService.findByTuesday(reviewId);
		List<Review> reviewWednesdayList = reviewService.findByWednesday(reviewId);
		List<Review> reviewThursdayList = reviewService.findByThursday(reviewId);
		List<Review> reviewFridayList = reviewService.findByFriday(reviewId);
		List<Review> reviewSaturdayList = reviewService.findBySaturday(reviewId);
		List<Review> reviewSundayList = reviewService.findBySunday(reviewId);
		model.addAttribute("review", review);
		model.addAttribute("reviewMondayList", reviewMondayList);
		model.addAttribute("reviewTuesdayList", reviewTuesdayList);
		model.addAttribute("reviewWednesdayList", reviewWednesdayList);
		model.addAttribute("reviewThursdayList", reviewThursdayList);
		model.addAttribute("reviewFridayList", reviewFridayList);
		model.addAttribute("reviewSaturdayList", reviewSaturdayList);
		model.addAttribute("reviewSundayList", reviewSundayList);
		
		List<Favorite> favoriteList = favoriteRepository.findByUserIdAndReviewId(loginUser.getUser().getUserId(), reviewId);
		if(favoriteList.size() == 0) {
			model.addAttribute("favorite", "favorite");
		} else {
			model.addAttribute("nofavorite", "nofavorite");
		}
		
		User user = userService.findByUserId(loginUser.getUser().getUserId());
		model.addAttribute("user", user);
		return "review_detail";
	}
	
	/**
	 * レビューID、ユーザーIDからレビューを削除する.
	 * 
	 * @param reviewId レビューID
	 * @param userId ユーザーID
	 * @param loginUser ログインユーザー
	 * @return 
	 */
	@RequestMapping("/delete")
	public String delete(Integer reviewId, Integer userId, @AuthenticationPrincipal LoginUser loginUser) {
		Review review = new Review();
		review.setReviewId(reviewId);
		review.setUserId(userId);
		review.setDeletedBy(loginUser.getUser().getUserName());
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		review.setDeletedAt(timestamp);
		reviewService.delete(review);
		return "redirect:/userDetail/toUserReviewList";
	}
}

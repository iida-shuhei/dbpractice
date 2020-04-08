package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Review;
import com.example.service.ReviewService;

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
	
	/**
	 * レビューIDからレビュー詳細を表示する.
	 * 
	 * @param reviewId レビューID
	 * @param model モデル
	 * @return レビュー詳細画面
	 */
	@RequestMapping("")
	public String load(Integer reviewId, Model model) {
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
		return "review_detail";
	}
}
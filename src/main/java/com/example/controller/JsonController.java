package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Favorite;
import com.example.domain.Good;
import com.example.domain.LoginUser;
import com.example.repository.FavoriteRepository;
import com.example.repository.GoodRepository;

@RestController
public class JsonController {

	@Autowired
	private GoodRepository goodRepository;
	
	@Autowired
	private FavoriteRepository favoriteRepository;

	/**
	 * いいねを返す.
	 * @param userId
	 * @param reviewId
	 * @param model
	 * @return
	 */
	@RequestMapping("/good")
	public List<Good> update(Integer userId,Integer reviewId,Model model){
		List<Good> goodList = goodRepository.findByUserIdAndReviewId(userId,reviewId);
		
	    if(goodList.size() == 0) {
	    	goodRepository.insert(userId, reviewId);
	    }else {
	    	goodRepository.delete(userId, reviewId);
	    }
	    return goodList;
	}
	
	/**
	 * いいね数を返す.
	 * @param reviewId
	 * @param model
	 * @return
	 */
	@RequestMapping("/countGood")
	public Integer good(Integer reviewId,Model model) {
		Integer good = goodRepository.good(reviewId);
		if(good == null) {
			good= 0;
		}
		model.addAttribute("good",good);
		return good;
	}
	
	/**
	 * レビューをお気に入りに登録か削除をする.
	 * 
	 * @param reviewId レビューID
	 * @param loginUser ログインユーザー
	 * @return レビュー詳細
	 */
	@RequestMapping("/favorite")
	public List<Favorite> registerOrDelete(Integer reviewId, @AuthenticationPrincipal LoginUser loginUser, Model model) {
		List<Favorite> favoriteList = favoriteRepository.findByUserIdAndReviewId(loginUser.getUser().getUserId(), reviewId);
		if(favoriteList.size() == 0) {
//			model.addAttribute("favorite", "favorite");
			favoriteRepository.register(loginUser.getUser().getUserId(), reviewId);
		} else {
//			model.addAttribute("nofavorite", "nofavorite");
			favoriteRepository.delete(loginUser.getUser().getUserId(), reviewId);
		}
		return favoriteList;
	}
}
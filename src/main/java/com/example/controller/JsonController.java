package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Good;
import com.example.repository.GoodRepository;

@RestController
public class JsonController {

	@Autowired
	private GoodRepository goodRepository;

	
	/**
	 * いいねを返す.
	 * @param userId
	 * @param reviewId
	 * @param model
	 * @return
	 */
	@RequestMapping("/good")
	public List<Good> update(Integer userId,Integer reviewId,Model model){
		
		System.out.println(userId);
		System.out.println(reviewId);
		
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
		
	}



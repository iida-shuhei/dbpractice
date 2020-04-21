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
		List<Good> goodList = goodRepository.findByUserIdAndReviewId(userId,reviewId);
			
			
	    if(goodList.size() == 0) {
	    	goodRepository.insert(userId, reviewId);
	    	
	    }else {
	    	goodRepository.delete(userId, reviewId);
	    }
	    return goodList;
		}
		
	}



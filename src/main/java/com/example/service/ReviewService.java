package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Review;
import com.example.repository.ReviewRepository;

/**
 * レビューを管理するサービス.
 * 
 * @author iidashuhei
 *
 */
@Service
@Transactional
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	/**
	 * レビュー詳細を表示する.
	 * 
	 * @param reviewId レビューID
	 * @return レビュー詳細
	 */
	public List<Review> load(Integer reviewId) {
		return reviewRepository.load(reviewId);
	}
	
	/**
	 * レビューを削除する.
	 * 
	 * @param review　レビュー
	 */
	public void delete(Review review) {
		reviewRepository.delete(review);
	}
}

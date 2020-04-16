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
	public Review load(Integer reviewId) {
		return reviewRepository.load(reviewId);
	}
	
	public List<Review> findByMonday(Integer reviewId) {
		return reviewRepository.findByMonday(reviewId);
	}
	public List<Review> findByTuesday(Integer reviewId) {
		return reviewRepository.findByTuesday(reviewId);
	}
	public List<Review> findByWednesday(Integer reviewId) {
		return reviewRepository.findByWednesday(reviewId);
	}
	public List<Review> findByThursday(Integer reviewId) {
		return reviewRepository.findByThursday(reviewId);
	}
	public List<Review> findByFriday(Integer reviewId) {
		return reviewRepository.findByFriday(reviewId);
	}
	public List<Review> findBySaturday(Integer reviewId) {
		return reviewRepository.findBySaturday(reviewId);
	}
	public List<Review> findBySunday(Integer reviewId) {
		return reviewRepository.findBySunday(reviewId);
	}
	
	public void delete(Review review) {
		reviewRepository.delete(review);
	}
}

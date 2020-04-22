package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.domain.UserIcon;
import com.example.domain.UserRank;
import com.example.repository.ReviewRepository;
import com.example.repository.UserIconRepository;
import com.example.repository.UserRankRepository;
import com.example.repository.UserRepository;

/**
 * ユーザーを管理するリポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private UserIconRepository userIconRepository;
	
	@Autowired
	private UserRankRepository userRankRepository;
	
	/**
	 * ユーザー登録をする.
	 * 
	 * @param userRegisterForm ユーザー登録フォーム
	 */
	public void insert(User user) {
		userRepository.insert(user);
	}
	
	/**
	 * メールアドレスの重複チェック.
	 * 
	 * @param mailAddress メールアドレス
	 * @return メールアドレス情報
	 */
	public User findByUserMail(String userMail) {
		return userRepository.findByUserMail(userMail);
	}
	
	/**
	 * ユーザー詳細を表示する.
	 * 
	 * @param userId userID
	 * @return ユーザー詳細
	 */
	public User findByUserId(Integer userId) {
		return userRepository.findByUserId(userId);
	}
	
	/**
	 * ユーザー情報を更新する.
	 * 
	 * @param user　ユーザー
	 */
	public void update(User user) {
		userRepository.update(user);
	}
	
	/**
	 * ユーザーのアイコンを登録する.
	 * 
	 * @param userIcon ユーザーアイコン
	 */
	public void registerIcon(UserIcon userIcon) {
		userIconRepository.insert(userIcon);
	}
	
	/**
	 * ユーザーIDからレビュー数を取得する.
	 * 
	 * @param userId ユーザーID
	 * @return レビュー数
	 */
	public Integer countUserReview(Integer userId) {
		return reviewRepository.countUserReview(userId);
	}
	
	/**
	 * ユーザーランクを更新する.
	 * 
	 * @param userId ユーザーID
	 * @param rankId ランクID
	 */
	public void updateUserRank(Integer userId, Integer rankId) {
		userRepository.updateUserRank(userId, rankId);
	}
	
	/**
	 * ユーザーランク一覧を取得する.
	 * 
	 * @return　ユーザーランク
	 */
	public List<UserRank> findAll() {
		return userRankRepository.findAll();
	}
	
	/**
	 * ユーザーを削除する.
	 * 
	 * @param user ユーザー
	 */
	public void delete(User user) {
		userRepository.delete(user);
	}
}
package com.example.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.domain.UserMail;
import com.example.form.UserRegisterForm;
import com.example.repository.UserMailRepository;
import com.example.repository.UserRepository;

/**
 * ユーザーを管理するリポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Service
@Transactional
public class UserRegisterService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMailRepository UserMailRepository;
	
	/**
	 * ユーザー登録をする.
	 * 
	 * @param userRegisterForm ユーザー登録フォーム
	 */
	public void insert(UserRegisterForm userRegisterForm) {
		User user = new User();
		user.setUserName(userRegisterForm.getUserName());
		user.setPassword(userRegisterForm.getPassword());
		user.setCreatedBy(userRegisterForm.getUserName());
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		user.setCreatedAt(timestamp);
		userRepository.insert(user);
		
		UserMail userMail = new UserMail();
		userMail.setUserId(user.getUserId());
		userMail.setMailTypeId(userRegisterForm.getMailTypeId());
		userMail.setMailAddress(userRegisterForm.getMailAddress());
		UserMailRepository.insert(userMail);
	}
	
	/**
	 * メールアドレスの重複チェック.
	 * 
	 * @param mailAddress メールアドレス
	 * @return メールアドレス情報
	 */
	public UserMail findByEmail(String mailAddress) {
		return UserMailRepository.findByEmail(mailAddress);
	}
}

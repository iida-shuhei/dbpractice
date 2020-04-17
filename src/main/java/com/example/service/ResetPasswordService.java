package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.repository.UserRepository;

@Service
@Transactional
public class ResetPasswordService {

	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 登録されているメールアドレス宛にパスワード再設定用のメールを送る.
	 * 
	 * @param token トークン
	 * @param registedUserMail 登録されてあるユーザーメール
	 */
	public void sendMail(String token, String userMail) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("rakus.yahoo@gmail.com");
		msg.setTo(userMail);
		msg.setSubject("パスワード再設定のお知らせ");
		msg.setText("英数字 : " + token + "\n"
        		   + "ブラウザの画面で英数字を入力後パスワードを再設定してください。");
		mailSender.send(msg);
	}
	
	/**
	 * パスワードを更新する.
	 * 
	 * @param userMail ユーザーメール
	 * @param password パスワード
	 */
	public void updatePass(String userMail, String password) {
		userRepository.updatePass(userMail, password);
	}
}

package com.example.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.ResetPasswordForm;
import com.example.service.ResetPasswordService;
import com.example.service.UserService;

/**
 * パスワード再設定用コントローラー.
 * 
 * @author iidashuhei
 *
 */
@Controller
@RequestMapping("/reset")
public class ResetPasswordController {
	
	@Autowired
	private ResetPasswordService resetPasswordService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private HttpSession session;
	// 32バイトのCSRFトークンを作成
	
	@Autowired
	private UserService userService;
	
	/**
	 * 入力されたものを受け取るフォーム.
	 * 
	 * @return ユーザー情報
	 */
	@ModelAttribute
	private ResetPasswordForm setUpForm() {
		return new ResetPasswordForm();
	}
	
	/**
	 * メールアドレスを入力するフォーム.
	 * 
	 * @return 入力フォーム
	 */
	@RequestMapping("")
	public String inputUserMail() {
		return "input_userMail";
	}
	
	/**
	 * トークンを作成する.
	 * 
	 * @param registeredUserMail 登録されているユーザーメール
	 * @return トークンを入力するフォーム
	 */
	@RequestMapping("/token")
	public String getToken(@Validated ResetPasswordForm resetPasswordForm, BindingResult result) {
		// メールアドレスの重複チェック
		User userMail = userService.findByUserMail(resetPasswordForm.getUserMail());
		if (userMail == null) {
			result.rejectValue("userMail", null, "そのメールアドレスは登録されていません");
		}
		// エラーが一つでもあれば入力画面に戻る
		if (result.hasErrors()) {
			return inputUserMail();
		}
		String token = UUID.randomUUID().toString().replace("-", "");
		session.setAttribute("token", token);
		session.setAttribute("userMail", resetPasswordForm.getUserMail());
		resetPasswordService.sendMail(token,resetPasswordForm.getUserMail());
		return "token_form";
	}
	
	/**
	 * パスワードをアップデートする.
	 * 
	 * @param token トークン
	 * @return パスワードリセットフォーム
	 */
	@RequestMapping("/updatePass")
	public String updatePass(@Validated ResetPasswordForm resetPasswordForm, BindingResult result) {
		if (!(resetPasswordForm.getToken().equals(session.getAttribute("token")))) {
			result.rejectValue("token", null, "入力したものとお送りした英数字が異なります");
		} else {
			return "reset_password";
		}
		return "token_form";
	}
	
	/**
	 * パスワードを再設定する.
	 * 
	 * @param password パスワード
	 * @param confirmationPassword 確認用パスワード
	 * @return ログイン画面
	 */
	@RequestMapping("/setPass")
	public String setPass(@Validated ResetPasswordForm resetPasswordForm, BindingResult result) {
		if(!(resetPasswordForm.getPassword().equals(resetPasswordForm.getConfirmationPassword()))) {
			result.rejectValue("confirmationPassword", null, "パスワードと確認用パスワードが異なります");
		} else {
			String email = (String) session.getAttribute("registeredUserMail");
			String encodePassword = passwordEncoder.encode(resetPasswordForm.getPassword());
			resetPasswordService.updatePass(email, encodePassword);
			return "redirect:/login";
		}
		return "reset_password";
	}
}
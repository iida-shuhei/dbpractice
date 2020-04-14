package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.UserRegisterForm;
import com.example.service.UserService;

/**
 * ユーザーを登録するコントローラー.
 * 
 * @author iidashuhei
 *
 */
@Controller
@RequestMapping("")
public class UserRegisterController {

	@Autowired
	private UserService userRegisterService;

	/**
	 * 入力されたものを受け取るフォーム.
	 * 
	 * @return ユーザー情報
	 */
	@ModelAttribute
	private UserRegisterForm setUpForm() {
		return new UserRegisterForm();
	}

	/**
	 * 新規登録画面へ遷移.
	 * 
	 * @return 新規登録ページ
	 */
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "register_user";
	}

	/**
	 * ユーザーを登録する.
	 * 
	 * @param userRegisterForm ユーザー登録フォーム
	 * @param result エラーの有無
	 * @return ログイン画面へ遷移.
	 */
	@RequestMapping("/register")
	public String register(@Validated UserRegisterForm userRegisterForm, BindingResult result) {
		// メールアドレスの重複チェック
		User userMail = userRegisterService.findByUserMail(userRegisterForm.getUserMail());
		if (userMail != null) {
			result.rejectValue("userMail", null, "そのメールアドレスはすでに使われています");
		}
		// パスワードと確認用パスワードのチェック
		if (!(userRegisterForm.getPassword().equals(userRegisterForm.getConfirmationPassword()))) {
			result.rejectValue("confirmationPassword", null, "パスワードと確認用パスワードが異なります");
		}
		// エラーが一つでもあれば入力画面に戻る
		if (result.hasErrors()) {
			return toRegister();
		}
		userRegisterService.insert(userRegisterForm);
		return "login";
	}
}

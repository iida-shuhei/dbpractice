package com.example.controller;

import java.sql.Timestamp;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.TmpUser;
import com.example.domain.User;
import com.example.form.UserRegisterForm;
import com.example.repository.MailRepository;
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
	private UserService userService;
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private MailRepository mailRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

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
	public String register(@Validated UserRegisterForm userRegisterForm, BindingResult result, Model model) {
		
		// メールアドレスの重複チェック
		User userMail = userService.findByUserMail(userRegisterForm.getUserMail());
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
		
		if(userMail == null) {
			String uuid = UUID.randomUUID().toString();
			TmpUser tmpUser = new TmpUser();
			tmpUser.setName(userRegisterForm.getUserName());
			tmpUser.setMail(userRegisterForm.getUserMail());
			tmpUser.setPassword(passwordEncoder.encode(userRegisterForm.getPassword()));
			tmpUser.setUuid(uuid);
			model.addAttribute("tmpUser", tmpUser);
			mailRepository.insert(tmpUser);
			
			String IPadnPort = "localhost:8080";
			String from = "rakus.yahoo@gmail.com";
			String title = "アカウント確認のお願い";
			String content = userRegisterForm.getUserName() + "さん" +"\n"+"\n"+"以下のリンクにアクセスしてアカウント認証をしてください"+"\n"+"http://"+IPadnPort+"/validate"+"?uuid="+uuid;
			
			SimpleMailMessage msg = new  SimpleMailMessage();
			msg.setFrom(from);
			msg.setTo(userRegisterForm.getUserMail());
			msg.setSubject(title);
			msg.setText(content);
			mailSender.send(msg);
		}
		return "waiting";
	}
	
	/**
	 * メール認証をする.
	 * 
	 * @param uuid uuid
	 * @return ログイン画面へ
	 */
	@RequestMapping("/validate")
    @CrossOrigin
    public String validate(@Validated UserRegisterForm userRegisterForm, BindingResult result) {
		TmpUser isExist = mailRepository.load(userRegisterForm.getUuid());
		
		if(isExist != null) {
			TmpUser tmp = mailRepository.load(userRegisterForm.getUuid());
			String name = tmp.getName();
			String mail = tmp.getMail();
			String password = tmp.getPassword();
			
		    User user = new User();
		    user.setUserName(name);
		    user.setUserMail(mail);
		    user.setPassword(password);
		    user.setCreatedBy(name);
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			user.setCreatedAt(timestamp);
			
		    userService.insert(user);
		    mailRepository.delete(userRegisterForm.getUuid());
		}
		return "complete";
	}
}
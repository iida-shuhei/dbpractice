package com.example.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.DeletedUser;
import com.example.domain.LoginUser;
import com.example.domain.Review;
import com.example.domain.User;
import com.example.domain.UserIcon;
import com.example.domain.UserRank;
import com.example.form.UpdateUserForm;
import com.example.repository.ReviewRepository;
import com.example.repository.UserRepository;
import com.example.service.UserService;

/**
 * ユーザー詳細を管理するコントローラー.
 * 
 * @author iidashuhei
 *
 */
@Controller
@RequestMapping("/userDetail")
public class UserDetailController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 * 入力されたものを受け取るフォーム.
	 * 
	 * @return ユーザー情報
	 */
	@ModelAttribute
	private UpdateUserForm setUpForm() {
		return new UpdateUserForm();
	}
	
	/**
	 * ユーザー詳細を表示する.
	 * 
	 * @param loginUser ログインユーザー
	 * @param model モデル
	 * @return ユーザー詳細
	 */
	@RequestMapping("/toDetail")
	public String toDetail(@AuthenticationPrincipal LoginUser loginUser, Model model) {
		User user = new User();
		Integer rankId = 0;
		Integer countReview = userService.countUserReview(loginUser.getUser().getUserId());
		if(countReview >= 0 && countReview <= 5) {
			rankId = 1;
		} else if(countReview >= 6 && countReview <= 10) {
			rankId = 2;
		} else if(countReview >= 11 && countReview <= 15) {
			rankId = 3;
		} else if(countReview >= 16 && countReview <= 20) {
			rankId = 4;
		} else if(countReview >= 21 && countReview <= 25) {
			rankId = 5;
		} else if(countReview >= 26 && countReview <= 30) {
			rankId = 6;
		} else if(countReview >= 31 && countReview <= 30) {
			rankId = 7;
		} else if(countReview >= 41 && countReview <= 50) {
			rankId = 8;
		} else if(countReview >= 51 && countReview <= 60) {
			rankId = 9;
		} else if(countReview >= 61 && countReview <= 70) {
			rankId = 10;
		} else if(countReview >= 71 && countReview <= 80) {
			rankId = 11;
		} else if(countReview >= 81 && countReview <= 90) {
			rankId = 12;
		} else if(countReview >= 91 && countReview <= 100) {
			rankId = 13;
		} else if(countReview >= 111 && countReview <= 130) {
			rankId = 14;
		} else if(countReview >= 131 && countReview <= 150) {
			rankId = 15;
		} else if(countReview >= 151 && countReview <= 180) {
			rankId = 16;
		} else if(countReview >= 181 && countReview <= 210) {
			rankId = 17;
		} else if(countReview >= 211 && countReview <= 240) {
			rankId = 18;
		} else {
			rankId = 19;
		}
		userService.updateUserRank(loginUser.getUser().getUserId(), rankId);
		
		List<UserRank> userRankList = userService.findAll();
		model.addAttribute("userRankList", userRankList);
		
		String totalRamens [] = {
				"０〜５杯","６〜１０杯","１１〜１５杯","１６〜２０杯","２１〜２５杯","２６〜３０杯","３１〜４０杯","４１〜５０杯","５１〜６０杯","６１〜７０杯",
				"７１〜８０杯","８１〜９０杯","９１〜１１０杯","１１１〜１３０杯","１３１〜１５０杯","１５１〜１８０杯","１８１〜２１０杯","２１１〜２４０杯","２４１〜杯"
		};
		model.addAttribute("totalRamens", totalRamens);
		
		user = userService.findByUserId(loginUser.getUser().getUserId());
		model.addAttribute("user", user);
		return "user_detail";
	}
	
	/**
	 * ユーザー詳細更新画面へ遷移.
	 * 
	 * @return ユーザー詳細更新画面へ
	 */
	@RequestMapping("/toUpdateUser")
	public String toUpdateUser(Integer userId, Model model) {
		User user = userService.findByUserId(userId);
		model.addAttribute("user", user);
		return "update_user";
	}
	
	/**
	 * ユーザー情報を更新する.
	 * 
	 * @param updateUserForm ユーザー更新フォーム
	 * @param result 結果
	 * @param model モデル
	 * @param loginUser ログインユーザー
	 * @return ユーザー詳細画面
	 * @throws IOException
	 */
	@RequestMapping("/update")
	public String update(@Validated UpdateUserForm updateUserForm, BindingResult result, Model model,@AuthenticationPrincipal LoginUser loginUser) throws IOException {
		UserIcon userIcon = null;
		
		// パスワードと確認用パスワードのチェック
		if (!(updateUserForm.getPassword().equals(updateUserForm.getConfirmationPassword()))) {
			result.rejectValue("confirmationPassword", "null", "パスワードと確認用パスワードが異なります");
		}

		//画像があれば登録
		if(!updateUserForm.getIconImagePath().getOriginalFilename().isEmpty()) {
			// 画像ファイル形式チェック
			MultipartFile image = updateUserForm.getIconImagePath();
			String fileExtension = null;
			try {
				fileExtension = getExtension(image.getOriginalFilename());
				if (!"jpg".equals(fileExtension) && !"png".equals(fileExtension)) {
					result.rejectValue("icon", "", "拡張子は.jpgか.pngのみに対応しています");
				}
			} catch (Exception e) {
				result.rejectValue("icon", "", "拡張子は.jpgか.pngのみに対応しています");
			}
			// 画像ファイルをBase64形式にエンコード
			String base64FileString = Base64.getEncoder().encodeToString(image.getBytes());
			if ("jpg".equals(fileExtension)) {
				base64FileString = "data:image/jpeg;base64," + base64FileString;
			} else if ("png".equals(fileExtension)) {
				base64FileString = "data:image/png;base64," + base64FileString;
			}
			userIcon = new UserIcon();
			userIcon.setIconImagePath(base64FileString);
			userService.registerIcon(userIcon);
		}
		
		User user = new User();
		user.setUserId(updateUserForm.getUserId());
		user.setUserName(updateUserForm.getUserName());
		user.setUserMail(updateUserForm.getUserMail());
		
		//パスワードがあれば登録
		if(!updateUserForm.getPassword().isEmpty()) {
			user.setPassword(passwordEncoder.encode(updateUserForm.getPassword()));
		} else {
			user.setPassword(passwordEncoder.encode(loginUser.getUser().getPassword()));
		}
		
		//画像があれば登録
		if(!updateUserForm.getIconImagePath().getOriginalFilename().isEmpty()) {
			user.setUserIconId(userIcon.getIconId());
		} else {
			user.setUserIconId(loginUser.getUser().getUserIconId());
		}
		
		if (result.hasErrors()) {
			return toUpdateUser(updateUserForm.getUserId(), model);
		}
		
		user.setUpdatedBy(loginUser.getUser().getUserName());
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		user.setUpdatedAt(timestamp);
		user.setVersion(1);
		userService.update(user);
		return "redirect:/userDetail/toDetail";
	}
	
	/*
	 * ファイル名から拡張子を返します.
	 * 
	 * @param originalFileName ファイル名
	 * 
	 * @return .を除いたファイルの拡張子
	 */
	private String getExtension(String originalFileName) throws Exception {
		if (originalFileName == null) {
			throw new FileNotFoundException();
		}
		int point = originalFileName.lastIndexOf(".");
		if (point == -1) {
			throw new FileNotFoundException();
		}
		return originalFileName.substring(point + 1);
	}
	
	/**
	 * ユーザーのラーメン記録を表示.
	 * 
	 * @param model     モデル
	 * @param loginUser ログインユーザー
	 * @return ユーザーのラーメン記録
	 */
	@RequestMapping("/toUserReviewList")
	public String toUserReviewList(Integer start, @AuthenticationPrincipal LoginUser loginUser, Model model) {
		// Maxページ数を求める
		Integer count = reviewRepository.countUserReview(loginUser.getUser().getUserId());

		// 何番目から表示するかを求める
		if (start == null) {
			start = 0;
		};
		
		List<Review> reviewList = reviewRepository.findByLoginUser(loginUser.getUser().getUserId(),start);
		if (reviewList.isEmpty()) {
			model.addAttribute("message", "あなたのラーメン記録はまだありません");
		}
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("start", start);
		model.addAttribute("count", count);
		
		User user = userService.findByUserId(loginUser.getUser().getUserId());
		model.addAttribute("user", user);
		return "user_review_list";
	}
	
	/**
	 * ユーザーを削除する.
	 * 
	 * @param userId ユーザーID
	 * @param loginUser ログインユーザー
	 * @return ログアウト
	 */
	@RequestMapping("/delete")
	public String delete(Integer userId, @AuthenticationPrincipal LoginUser loginUser) {
		User user = new User();
		user.setUserId(userId);
		user.setDeletedBy(loginUser.getUser().getUserName());
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		user.setDeletedAt(timestamp);
		
		DeletedUser deletedUser = new DeletedUser();
		deletedUser.setUserId(userId);
		deletedUser.setUserName(loginUser.getUser().getUserName());
		deletedUser.setUserMail(loginUser.getUser().getUserMail());
		deletedUser.setDeletedAt(timestamp);
		userRepository.insertDeletedUser(deletedUser);
		
		userService.delete(user);
		return "redirect:/logout";
	}
}
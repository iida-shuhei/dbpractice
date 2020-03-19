package com.example.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.Article;
import com.example.domain.Ramen;
import com.example.domain.RamenImage;
import com.example.domain.RamenShop;
import com.example.domain.RamenShopTime;
import com.example.form.ArticleRegisterForm;
import com.example.repository.ArticleRepository;
import com.example.repository.RamenImageRepository;
import com.example.repository.RamenRepository;
import com.example.repository.RamenShopRepository;
import com.example.repository.RamenShopTimeRepository;

/**
 * ラーメン店舗を管理するリポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Controller
@RequestMapping("/ramen")
public class ArticleRegisterController {

	@Autowired
	private RamenShopRepository ramenShopRepository;

	@Autowired
	private RamenRepository ramenRepository;
	
	@Autowired
	public RamenImageRepository ramenImageRepository;

	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	public RamenShopTimeRepository ramenShopTimeRepository;
	
	/**
	 * 入力値を受け取るフォーム.
	 * 
	 * @return 記事フォーム
	 */
	@ModelAttribute
	private ArticleRegisterForm setUpForm() {
		return new ArticleRegisterForm();
	}

	/**
	 * 記事投稿画面へ遷移.
	 * 
	 * @return 記事投稿画面
	 */
	@RequestMapping("/toInsert")
	public String toInsert(Model model) {
		List<RamenShop> ramenShopList = ramenShopRepository.findAll();
		for (RamenShop ramenShop : ramenShopList) {
			List<Ramen> ramenList = ramenRepository.findByShopId(ramenShop.getShopId());
			ramenShop.setRamenList(ramenList);
		}
		model.addAttribute("ramenShopList", ramenShopList);
		return "insert_article";
	}

	@RequestMapping("/insert")
	public String insert(@Validated ArticleRegisterForm articleRegisterForm, BindingResult result, Model model) throws IOException {
		RamenShop ramenShop = new RamenShop();
		ramenShop.setShopName(articleRegisterForm.getShopName());
		ramenShop.setZipcode(articleRegisterForm.getZipcode());
		ramenShop.setPrefecture(articleRegisterForm.getPrefecture());
		ramenShop.setCity(articleRegisterForm.getCity());
		ramenShop.setOther(articleRegisterForm.getOther());
		ramenShop.setHolidays(articleRegisterForm.getHolidays());
		ramenShop.setCreatedBy("飯田");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		ramenShop.setCreatedAt(timestamp);
		ramenShopRepository.insert(ramenShop);

		Article article = new Article();
		article.setUserId(1);
		article.setShopId(ramenShop.getShopId());
		articleRepository.insert(article);

		RamenShopTime ramenShopTime = new RamenShopTime();
		ramenShopTime.setShopId(ramenShop.getShopId());
		ramenShopTime.setDaysId(articleRegisterForm.getDaysId());
		ramenShopTime.setNoonStartTime(articleRegisterForm.getNoonStartTime());
		ramenShopTime.setNoonEndTime(articleRegisterForm.getNoonEndTime());
		ramenShopTime.setNightStartTime(articleRegisterForm.getNightStartTime());
		ramenShopTime.setNightEndTime(articleRegisterForm.getNightEndTime());
		ramenShopTime.setOtherTime(articleRegisterForm.getOtherTime());
		ramenShopTimeRepository.insert(ramenShopTime);

		// 画像ファイル形式チェック
		MultipartFile image = articleRegisterForm.getRamenImage();
		String fileExtension = null;
		try {
			fileExtension = getExtension(image.getOriginalFilename());
			if (!"jpg".equals(fileExtension) && !"png".equals(fileExtension)) {
				result.rejectValue("image", "", "拡張子は.jpgか.pngのみに対応しています");
			}
		} catch (Exception e) {
			result.rejectValue("image", "", "拡張子は.jpgか.pngのみに対応しています");
		}

		if (result.hasErrors()) {
			return toInsert(model);
		}

		RamenImage ramenImage = new RamenImage();
		// 画像ファイルをBase64形式にエンコード
		String base64FileString = Base64.getEncoder().encodeToString(image.getBytes());
		if ("jpg".equals(fileExtension)) {
			base64FileString = "data:image/jpeg;base64," + base64FileString;
		} else if ("png".equals(fileExtension)) {
			base64FileString = "data:image/png;base64," + base64FileString;
		}
		ramenImage.setImagePath(base64FileString);
		ramenImageRepository.insert(ramenImage);
		
		Ramen ramen = new Ramen();
		ramen.setShopId(ramenShop.getShopId());
		ramen.setRamenName(articleRegisterForm.getRamenName());
		ramen.setRamenPrice(articleRegisterForm.getRamenPrice());
		ramen.setRamenImagePathId(ramenImage.getImageId());
		ramen.setCreatedBy("飯田");
		ramen.setCreatedAt(timestamp);
		ramenRepository.insert(ramen);
		return "redirect:/";
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
}

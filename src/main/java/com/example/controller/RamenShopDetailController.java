package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.RamenShop;
import com.example.service.RamenShopService;

@Controller
@RequestMapping("/ramenShopDetail")
public class RamenShopDetailController {
	
	@Autowired
	private RamenShopService ramenShopService;
	
	
	/**
	 * ラーメン店舗の詳細情報を検索する。
	 * @param shopId
	 * @param model
	 * @return　店舗詳細画面
	 */
	@RequestMapping("")
	public String index(Integer shopId,Model model) {
		RamenShop ramenShop = ramenShopService.load(shopId);
		List<RamenShop> detailMondayList = ramenShopService.findByMonday(shopId);
		List<RamenShop> detailTuesdayList = ramenShopService.findByTuesday(shopId);
		List<RamenShop> detailWednesdayList = ramenShopService.findByWednesday(shopId);
		List<RamenShop> detailThursdayList = ramenShopService.findByThursday(shopId);
		List<RamenShop> detailFridayList = ramenShopService.findByFriday(shopId);
		List<RamenShop> detailSaturdayList = ramenShopService.findBySaturday(shopId);
		List<RamenShop> detailSundayList = ramenShopService.findBySunday(shopId);
		model.addAttribute("ramenShop",ramenShop);
		model.addAttribute("detailMondayList",detailMondayList);
		model.addAttribute("detailTuesdayList",detailTuesdayList);
		model.addAttribute("detailWednesdayList",detailWednesdayList);
		model.addAttribute("detailThursdayList",detailThursdayList);
		model.addAttribute("detailFridayList",detailFridayList);
		model.addAttribute("detailSaturdayList",detailSaturdayList);
		model.addAttribute("detailSundayList",detailSundayList);
		
		return "ramenShop_detail";
	}
}
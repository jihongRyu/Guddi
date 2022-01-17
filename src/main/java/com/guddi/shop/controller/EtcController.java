package com.guddi.shop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guddi.shop.dao.CartDao;
import com.guddi.shop.dao.EtcDao;
import com.guddi.shop.dto.CartDto;
import com.guddi.shop.dto.EtcDto;
import com.guddi.shop.service.CartService;
import com.guddi.shop.service.EtcService;

@Controller
public class EtcController {


	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired EtcService service;
	
	// 신상여부 카테고리 관련  유지홍 2022.01.17 Start
	@RequestMapping(value = "/toNewFlgCategory", method = RequestMethod.GET)
	public String toNewFlgCategory(Model model , HttpSession session) {
		logger.info("toNewFlgCategory 요청");
		
		ArrayList<EtcDto> dto = service.getNewFlgInfo();
		model.addAttribute("newFlgList", dto);

		return "etc/newFlgCategory";
	}
	
	@RequestMapping(value = "/registNewflg", method = RequestMethod.GET)
	public String registNewflg(Model model , HttpSession session) {
		logger.info("registNewflg 요청");
		

		return "etc/registNewflg";
	}
	
	@RequestMapping(value = "/doRegistNewFlg", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> doRegistNewFlg(Model model , @RequestParam String newname) {
		logger.info("doRegistNewFlg 요청");
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int result = service.doRegistNewFlg(newname);
		
		if (result>0) {
			map.put("result", result);
		}

		return map;
	}
	
	@RequestMapping(value = "/doUpdateUseFlg", method = RequestMethod.GET)
	public String doUpdateUseFlg(Model model , @RequestParam int idx, @RequestParam int use_flg) {
		logger.info("doUpdateUseFlg 요청");
		
		service.doUpateUseFlg(use_flg, idx);

		return "redirect:/toNewFlgCategory";
	}
	
	
	// 신상여부 카테고리 관련  유지홍 2022.01.17 End

	
}

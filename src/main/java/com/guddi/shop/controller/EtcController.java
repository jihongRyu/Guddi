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
	
	// 신상여부, 판매여부 카테고리 관련  유지홍 2022.01.17 Start
	@RequestMapping(value = "/toNewFlgCategory", method = RequestMethod.GET)
	public String toNewFlgCategory(Model model , HttpSession session) {
		logger.info("toNewFlgCategory 요청");
		
		ArrayList<EtcDto> dto = service.getNewFlgInfo();//신상여부 리스트를 가져옮		
		ArrayList<EtcDto> uDto = service.getUseFlgInfo();//사용여부정보를 가져옮
		
		model.addAttribute("newFlgList", dto);
		model.addAttribute("useFlgList", uDto);
		

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
	
	@RequestMapping(value = "/doUpdateUseFlg", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> doUpdateUseFlg(Model model , @RequestParam String idx, @RequestParam String use_flgName) {
		
		logger.info("doUpdateUseFlg 요청");
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int use_flg = 100;
		ArrayList<EtcDto> uDto = service.getUseFlgInfo();//사용여부정보를 가져옮
		
		for (int i = 0; i < uDto.size(); i++) {
			if (uDto.get(i).getUseFlg_name().equals(use_flgName)) {
				use_flg=uDto.get(i).getIdx();
			}
		}
		
		if (use_flg!=100) {
			int result = service.doUpateUseFlg(use_flg , Integer.parseInt(idx));
			map.put("result", result);
		}
		

		return map;
	}
	
	@RequestMapping(value = "/toSellFlgCategory", method = RequestMethod.GET)
	public String toSellFlgCategory(Model model , HttpSession session) {
		logger.info("toSellFlgCategory 요청");
		
		ArrayList<EtcDto> dto = service.getSellFlgInfo();//신상여부 리스트를 가져옮		
		ArrayList<EtcDto> uDto = service.getUseFlgInfo();//사용여부정보를 가져옮
		
		model.addAttribute("sellFlgList", dto);
		model.addAttribute("useFlgList", uDto);
		

		return "etc/sellFlgCategory";
	}
	
	@RequestMapping(value = "/registSellflg", method = RequestMethod.GET)
	public String registSellflg(Model model , HttpSession session) {
		logger.info("registNewflg 요청");
		

		return "etc/registSellflg";
	}
	
	@RequestMapping(value = "/doRegistSellFlg", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> doRegistSellFlg(Model model , @RequestParam String newname) {
		logger.info("doRegistSellFlg 요청");
		HashMap<String, Object> map = new HashMap<String, Object>();		
		int result = service.doRegistSellFlg(newname);
		
		if (result>0) {
			map.put("result", result);
		}
		return map;
	}
	
	@RequestMapping(value = "/doUpdateSellUseFlg", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> doUpdateSellUseFlg(Model model , @RequestParam String idx, @RequestParam String use_flgName) {
		
		logger.info("doUpdateSellUseFlg 요청");
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int use_flg = 100;
		ArrayList<EtcDto> uDto = service.getUseFlgInfo();//사용여부정보를 가져옮
		
		for (int i = 0; i < uDto.size(); i++) {
			if (uDto.get(i).getUseFlg_name().equals(use_flgName)) {
				use_flg=uDto.get(i).getIdx();
			}
		}
		
		if (use_flg!=100) {
			int result = service.doUpdateSellUseFlg(use_flg , Integer.parseInt(idx));
			map.put("result", result);
		}
		

		return map;
	}
	
	
	// 신상여부, 판매여부 카테고리 관련  유지홍 2022.01.17 End

	
}

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
	public HashMap<String, Object> doUpdateUseFlg(Model model , @RequestParam String idx, @RequestParam String use_flg) {
		
		logger.info("doUpdateUseFlg 요청");
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		logger.info("use_flg : {}",use_flg);
		logger.info("idx :  {}",idx);
				
		int result = service.doUpateUseFlg(Integer.parseInt(use_flg) , Integer.parseInt(idx));
		map.put("result", result);
		
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
	public HashMap<String, Object> doRegistSellFlg(Model model , @RequestParam String sellname) {
		logger.info("doRegistSellFlg 요청");
		HashMap<String, Object> map = new HashMap<String, Object>();		
		int result = service.doRegistSellFlg(sellname);
		
		if (result>0) {
			map.put("result", result);
		}
		return map;
	}
	
	@RequestMapping(value = "/doUpdateSellUseFlg", method = RequestMethod.POST)
	@ResponseBody            
	public HashMap<String, Object> doUpdateSellUseFlg(Model model , @RequestParam String idx, @RequestParam String use_flg) {
		
		logger.info("doUpdateSellUseFlg 요청");
		HashMap<String, Object> map = new HashMap<String, Object>();		
		
		logger.info("use_flg : {}",use_flg);
		logger.info("idx :  {}",idx);
	
		int result = service.doUpdateSellUseFlg(Integer.parseInt(use_flg) , Integer.parseInt(idx));
		map.put("result", result);
		
		

		return map;
	}
	
	@RequestMapping(value = "/doUpdateMemFlg", method = RequestMethod.POST)
	@ResponseBody            
	public HashMap<String, Object> doUpdateMemFlg(Model model , @RequestParam String idx, @RequestParam(value="mem_flg",required=false,defaultValue="") String mem_flg) {
		
		logger.info("doUpdateMemFlg 요청");
		HashMap<String, Object> map = new HashMap<String, Object>();		
		
		logger.info("use_flg : {}",mem_flg);
		logger.info("idx :  {}",idx);
	
		int result = service.doUpdateMemFlg(Integer.parseInt(mem_flg) , Integer.parseInt(idx));
		map.put("result", result);
		
		

		return map;
	}
	
	
	// 신상여부, 판매여부 카테고리 관련  유지홍 2022.01.17 End

	
}

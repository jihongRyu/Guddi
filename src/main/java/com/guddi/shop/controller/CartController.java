package com.guddi.shop.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guddi.shop.dto.CartDto;
import com.guddi.shop.service.MemberService;

@Controller
public class CartController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired MemberService service;
	
	
	// =====cart controller 추가하기 수정 START YuSeonhwa===== 
	
	
	
//	@RequestMapping(value = "/cart", method = RequestMethod.GET)
//	public String doRegistQna(Model model, @RequestParam HashMap<String, String> params, HttpSession session) {		
//		
//		logger.info("cart 요청");
//		service.doRegistQna(params, session);
//		return "/cart/userCart";
//	}
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cart(Model model , HttpSession session) {
		logger.info("cart 페이지 요청");
		String userId = "liujihong";// 로그인 미완성으로 아이디를 session에 그냥 넣어줌 - 실행했는데 아이디가 넘어가지 않는다. 
		logger.info("userId : {}", userId);
		if (userId!=null) {
			ArrayList<CartDto> list = service.getCartInfo(userId);
			
			logger.info("상품코드 : {}",list.get(0).getProduct_name());
			model.addAttribute("list", list);
		}
		return "cart/userCart";
	}
}

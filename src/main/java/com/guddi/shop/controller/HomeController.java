package com.guddi.shop.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		logger.info("홈페이지 요청");
		// liujihong --> asd123 으로 수정 --ysh 사유 : 장바구니기능구현시 제품이 등록된 아이디로 세션
		session.setAttribute("userId", "asd123");	
		
		return "index";
	}
	
}

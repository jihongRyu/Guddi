package com.guddi.shop.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guddi.shop.service.CartService;

@Controller
public class CartController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired CartService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {

		logger.info("홈페이지 요청");					
		

		return "index";
	}

}

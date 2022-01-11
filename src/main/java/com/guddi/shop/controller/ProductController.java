package com.guddi.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guddi.shop.service.MemberService;

@Controller
public class ProductController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired MemberService service;
	
	//제품의 상세페이지에서 장바구니버튼 클릭 시 해당 idx를 get방식으로 넘긴다.  
	@RequestMapping(value = "/tocart", method = RequestMethod.GET)
	public String tocart(Model model) {		
	
		return "cart";
	}
	
	
}

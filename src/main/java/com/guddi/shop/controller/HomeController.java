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

import com.guddi.shop.dto.EtcDto;
import com.guddi.shop.service.HomeService;



@Controller
public class HomeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired HomeService Service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {

		logger.info("홈페이지 요청");	
		
		session.setAttribute("userId", "liujihong");
		session.setAttribute("mem_flg", "1");
		session.setAttribute("username", "유지홍");

		//각종 카테고리를 가져와 세션에 저장
		ArrayList<EtcDto> brandcategory = Service.getBrandcategory();
		ArrayList<EtcDto> bagtype = Service.getBagtype();
		ArrayList<EtcDto> sellflg = Service.getSellflg();
		ArrayList<EtcDto> answertype = Service.getAnswertype();
		ArrayList<EtcDto> newflg = Service.getNewflg();
		
		logger.info("brandcategory, bagtype, sellflg, answertype,newflg 사이즈:{}", 
				brandcategory.size()+ " : " + bagtype.size()+ " : " +sellflg.size()+ " : " +answertype.size()+ " : " +newflg.size());

		session.setAttribute("newflg", newflg);
		session.setAttribute("brandcategory", brandcategory);
		session.setAttribute("bagtype", bagtype);
		session.setAttribute("sellflg", sellflg);
		session.setAttribute("answertype", answertype);		
				
		

		return "index";
	}
	
}

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
import org.springframework.web.bind.annotation.RequestParam;


import com.guddi.shop.dto.EtcDto;
import com.guddi.shop.dto.PageDto;
import com.guddi.shop.dto.ProductDto;
import com.guddi.shop.service.ManagerService;
import com.guddi.shop.service.ProductService;

@Controller
public class ProductController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired ProductService service;
	@Autowired ManagerService managerService;
	
	//2022.01.13 유지홍 제품 리스트 관련 소스 Start
	@RequestMapping(value = "/productPageList", method = RequestMethod.GET)
	public String getListPageSearch(Model model, @RequestParam("num") int num, @RequestParam("type") int type, 
			@RequestParam(value = "searchType",required = false, defaultValue = "subject") String searchType,
			@RequestParam(value = "keyword",required = false, defaultValue = "") String keyword) throws Exception {
		
	  logger.info("페이지 정보 : {}." ,type +" : "+ searchType +" : " +keyword +" : "+ num);
	  //페이징 처리를 위한 작업
	  PageDto page = new PageDto();
	  
	  page.setNum(num);
	  page.setCount(service.searchCount(searchType, keyword, type));
	  
	  //검색타입과 검색어
	  page.setSearchType(searchType);
	  page.setKeyword(keyword);
	  
	  ArrayList<ProductDto> list = null; 
	  list = service.listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword, type);
	  
	  	String product_type = "전체";
	  	
	  	if (type==1) {
	  		product_type="채소";
		}else if (type==2) {
			product_type="과일/견과/쌀";
		}else if (type==3) {
			product_type="면/양념/오일";
		}else if (type==4) {
			product_type="건강식품";
		}else if (type==5) {
			product_type="기타";
		}
	  	
	  
	  model.addAttribute("list", list); //리스트 보내기
	  model.addAttribute("page", page); //페이징처리
	  model.addAttribute("select", num);//페이징처리
	  
	  model.addAttribute("searchType", searchType); //검색 타입
	  model.addAttribute("keyword", keyword); //검색어
	  
	  model.addAttribute("type", product_type); //카테고리 명
	  model.addAttribute("type_num", type);  //카테고리 번호
	  
	  return "product/productPage";
	  
	 }	
	//2022.01.13 유지홍 제품 리스트 관련 소스 End
	
	
	
	
	//2022.01.13 유지홍 제품 리스트 관련 소스 Start
	public void getCategory(HttpSession session){
		
		//각종 카테고리를 가져와 세션에 저장
		ArrayList<EtcDto> brandcategory = managerService.getBrandcategory();
		ArrayList<EtcDto> bagtype = managerService.getBagtype();
		ArrayList<EtcDto> sellflg = managerService.getSellflg();
		ArrayList<EtcDto> answertype = managerService.getAnswertype();
		ArrayList<EtcDto> newflg = managerService.getNewflg();
				
		session.setAttribute("newflg", newflg);
		session.setAttribute("brandcategory", brandcategory);
		session.setAttribute("bagtype", bagtype);
		session.setAttribute("sellflg", sellflg);
		session.setAttribute("answertype", answertype);	
		
	}
	
	
	
	//2022.01.13 유지홍 제품 리스트 관련 소스 End
}














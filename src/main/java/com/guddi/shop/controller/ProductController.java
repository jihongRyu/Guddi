package com.guddi.shop.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guddi.shop.dto.EtcDto;
import com.guddi.shop.dto.ProductDto;
import com.guddi.shop.service.ProductService;

@Controller
public class ProductController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired ProductService service;
	
	@RequestMapping(value = "/productPageList", method = RequestMethod.GET)
	public String productPageList(Model model, @RequestParam String brandIdx) {	
		logger.info("productPageList 이동 {}", brandIdx);	
		int brandNum = Integer.parseInt(brandIdx);
		ArrayList<ProductDto> productList = service.productPageList(brandNum);
		ArrayList<EtcDto> bagTypeList = service.bagTypeList();
		model.addAttribute("productList", productList);
		model.addAttribute("bagTypeList", bagTypeList);
		return "product/productPageList";
	}
	
	@RequestMapping(value = "/productSearch", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<ProductDto> productSearch(@RequestParam String bagType, @RequestParam String productName) {	
		//HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<ProductDto> dto = service.productSearch(bagType, productName);
		logger.info("productSearch 이동 {}, {}", bagType, productName);
		//map.put("searchProductdto", dto);
		System.out.println("검색 결과 갯수 : "+dto.size());
		return dto;
	}
	
}





















































































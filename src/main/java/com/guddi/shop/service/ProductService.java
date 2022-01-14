package com.guddi.shop.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.guddi.shop.dao.ProductDao;
import com.guddi.shop.dto.EtcDto;
import com.guddi.shop.dto.PageDto;
import com.guddi.shop.dto.ProductDto;

@Service
public class ProductService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired ProductDao dao;
		
	//2022.01.13 유지홍 제품 리스트 관련 소스 Start
	public int searchCount(int brand_idx, String bag_name, String keyword) {
		// TODO Auto-generated method stub
		
		PageDto dto = new PageDto();
		  
		dto.setBrand_type(brand_idx);
		dto.setKeyword(keyword);
		dto.setBag_name(bag_name);
		
		return dao.searchCount(dto);
	}

	public ArrayList<ProductDto> listPageSearch(int displayPost, int postNum, 
			String keyword, int brand_idx, String bag_name) {
		// TODO Auto-generated method stub
		
		PageDto dto = new PageDto();
		
		dto.setBag_name(bag_name);
		dto.setBrand_type(brand_idx);
		logger.info("displayPost : {}", displayPost);
		logger.info("postNum : {}", postNum);
		dto.setPostNum(postNum);
		dto.setDisplayPost(displayPost);
		dto.setKeyword(keyword);		
		
		return dao.listPageSearch(dto);
	}
	//2022.01.13 유지홍 제품 리스트 관련 소스 End



}

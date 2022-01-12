package com.guddi.shop.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guddi.shop.dao.ManagerDao;
import com.guddi.shop.dto.EtcDto;
import com.guddi.shop.dto.PageDto;
import com.guddi.shop.dto.ProductDto;
import com.guddi.shop.dto.ReviewQnaDto;

@Service
public class ManagerService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired ManagerDao dao;
	
	
	//각종  카테고리 정보를 가져오는 메서드 Start ryujihong 2022.01.11
	public ArrayList<EtcDto> getBrandcategory() {
		// TODO Auto-generated method stub
		return dao.getBrandcategory();
	}

	public ArrayList<EtcDto> getBagtype() {
		// TODO Auto-generated method stub
		return dao.getBagtype();
	}

	public ArrayList<EtcDto> getSellflg() {
		// TODO Auto-generated method stub
		return dao.getSellflg();
	}

	public ArrayList<EtcDto> getAnswertype() {
		// TODO Auto-generated method stub
		return dao.getAnswertype();
	}

	public ArrayList<EtcDto> getNewflg() {
		// TODO Auto-generated method stub
		return dao.getNewflg();
	}	
	//각종  카테고리 정보를 가져오는 메서드 End ryujihong 2022.01.11
	
	//관리자페이지 제품 리스트, 수정 관련 Start ryujihong 2022.01.11
	
	//제품에 대한 정보를 가져오는 함수
	public ProductDto productInfo(int idx) {
		// TODO Auto-generated method stub
		
		return dao.productInfo(idx);
	}
	
	public ArrayList<ProductDto> productImageInfo(int idx) {
		// TODO Auto-generated method stub
		return dao.productImageInfo(idx);
	}

	public String getNewIdx() {
		// TODO Auto-generated method stub
		return dao.getNewIdx();
	}
	
	public int productSearchCount(String keyword, String brand_name, String bag_name) {
		// TODO Auto-generated method stub
		
		PageDto dto = new PageDto();
		 
		dto.setBrand_name(brand_name);
		dto.setBag_name(bag_name);
		dto.setKeyword(keyword);			
		
		return dao.productSearchCount(dto);
		
	}

	public ArrayList<ProductDto> productList(int displayPost, int postNum, String keyword, String brand_name,
			String bag_name) {
		// TODO Auto-generated method stub
		PageDto dto = new PageDto();
		
		dto.setBag_name(bag_name);
		dto.setBrand_name(brand_name);
		logger.info(" dto.getBrand_name() : {}", dto.getBrand_name() );
		logger.info(" dto.getBag_name() : {}", dto.getBag_name()) ;
		dto.setPostNum(postNum);
		dto.setDisplayPost(displayPost);
		dto.setKeyword(keyword);
					
		logger.info("postNum : {}", postNum);
		
		return dao.productList(dto);
	}
	//관리자페이지 제품 리스트, 수정 관련 End ryujihong 2022.01.11

}

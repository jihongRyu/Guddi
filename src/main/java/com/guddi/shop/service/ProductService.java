package com.guddi.shop.service;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.guddi.shop.dao.ProductDao;
import com.guddi.shop.dto.PageDto;
import com.guddi.shop.dto.ProductDto;


@Service
public class ProductService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired ProductDao dao;
		
	//2022.01.13 유지홍 제품 리스트 관련 소스 Start
	public int searchCount(String searchType, String keyword, int type) {
		// TODO Auto-generated method stub
		
		PageDto dto = new PageDto();
		  
		dto.setType(type);
		dto.setKeyword(keyword);
		dto.setSearchType(searchType);	
		
		return dao.searchCount(dto);
	}

	public ArrayList<ProductDto> listPageSearch(int displayPost, int postNum, String searchType, String keyword, int type) {
		// TODO Auto-generated method stub
		
		PageDto dto = new PageDto();
		
		dto.setType(type);
		logger.info("type : {}", dto.getType());
		dto.setPostNum(postNum);
		dto.setDisplayPost(displayPost);
		dto.setKeyword(keyword);
		dto.setSearchType(searchType);				
		
		return dao.listPageSearch(dto);
	}
	//2022.01.13 유지홍 제품 리스트 관련 소스 End

}

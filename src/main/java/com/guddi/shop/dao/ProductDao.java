package com.guddi.shop.dao;

import java.util.ArrayList;

import com.guddi.shop.dto.CartDto;
import com.guddi.shop.dto.EtcDto;
import com.guddi.shop.dto.PageDto;
import com.guddi.shop.dto.ProductDto;

public interface ProductDao {
	
	int searchCount(PageDto dto);

	ArrayList<ProductDto> listPageSearch(PageDto dto);
	
	//상세페이지 관련 충구형님 2022.01.17 Start
	ArrayList<ProductDto> detail(String idx);
	
	ArrayList<ProductDto> productimage();

	int cartupdate(CartDto dto);

	ArrayList<EtcDto> review(String idx);
	
	
	
	//상세페이지 관련 충구형님 2022.01.17 End

	

}

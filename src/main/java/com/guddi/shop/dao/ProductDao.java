package com.guddi.shop.dao;

import java.util.ArrayList;

import com.guddi.shop.dto.EtcDto;
import com.guddi.shop.dto.PageDto;
import com.guddi.shop.dto.ProductDto;

public interface ProductDao {
	
	int searchCount(PageDto dto);

	ArrayList<ProductDto> listPageSearch(PageDto dto);

	

}

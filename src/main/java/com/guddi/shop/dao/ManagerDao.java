package com.guddi.shop.dao;

import java.util.ArrayList;

import com.guddi.shop.dto.EtcDto;
import com.guddi.shop.dto.PageDto;
import com.guddi.shop.dto.ProductDto;
import com.guddi.shop.dto.ReviewQnaDto;

public interface ManagerDao {
	
	ArrayList<EtcDto> getBrandcategory();

	ArrayList<EtcDto> getBagtype();

	ArrayList<EtcDto> getSellflg();

	ArrayList<EtcDto> getAnswertype();

	ArrayList<EtcDto> getNewflg();

	ProductDto productInfo(int idx);	

	ArrayList<ProductDto> productImageInfo(int idx);

	String getNewIdx();

	int productSearchCount(PageDto dto);

	ArrayList<ProductDto> productList(PageDto dto);

	void doUpdateProduct(ProductDto dto);


}

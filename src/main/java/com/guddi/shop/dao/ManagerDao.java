package com.guddi.shop.dao;

import java.util.ArrayList;

import com.guddi.shop.dto.EtcDto;
import com.guddi.shop.dto.PageDto;
import com.guddi.shop.dto.ProductDto;
import com.guddi.shop.dto.ReviewQnaDto;

public interface ManagerDao {
	
	//관리자페이지 제품리스트, 제품정보 수정 관련 ryujihong 2022.01.13
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
	//관리자페이지 제품리스트, 제품정보 수정 관련  End ryujihong 2022.01.13
	
	//관리자페이지 제품등록 Start ryujihong 2022.01.14
	void doRegistProduct(ProductDto dto);	

	int getU_idx(String userId);

	int doRegistPhoto(ProductDto pdto);
	//관리자페이지 제품등록 End ryujihong 2022.01.14
}

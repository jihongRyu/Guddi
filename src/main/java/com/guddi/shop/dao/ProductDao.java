package com.guddi.shop.dao;

import java.util.ArrayList;

import com.guddi.shop.dto.CartDto;
import com.guddi.shop.dto.EtcDto;
import com.guddi.shop.dto.PageDto;
import com.guddi.shop.dto.ProductDto;
import com.guddi.shop.dto.ReviewQnaDto;

public interface ProductDao {
	
	int searchCount(PageDto dto);

	ArrayList<ProductDto> listPageSearch(PageDto dto);
	
	
	//상세페이지 관련 충구형님 2022.01.17 Start
	ArrayList<ProductDto> detail(String idx);
		
	ArrayList<ProductDto> productimage(String idx);

	int doCartUpdate(CartDto dto);
		
	ArrayList<ReviewQnaDto> reviewlist(PageDto dto);
		
	String reviewupdatedetail(String product_name);
		
	int reviewupdate(ReviewQnaDto dto);

	int reviewdelete(int idx);

	int searchReviewCount(String idx);

	int checkOrder(String product_code, String userId);

	ArrayList<ReviewQnaDto> answerLsit(String idx);
	
	//상세페이지 관련 충구형님 2022.01.17 End

	

}

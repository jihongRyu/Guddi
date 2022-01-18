package com.guddi.shop.dao;

import java.util.ArrayList;

import com.guddi.shop.dto.CartDto;
import com.guddi.shop.dto.EtcDto;
import com.guddi.shop.dto.ListPageDto;
import com.guddi.shop.dto.PageDto;
import com.guddi.shop.dto.ProductDto;

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

	int delImage(int photoNum, int idx);
	//관리자페이지 제품리스트, 제품정보 수정 관련  End ryujihong 2022.01.13
	
	//관리자페이지 제품등록 Start ryujihong 2022.01.14
	void doRegistProduct(ProductDto dto);	

	int getU_idx(String userId);
	
	int getPhoto_num(int idx);

	int doRegistPhoto(ProductDto pdto);
	//관리자페이지 제품등록 End ryujihong 2022.01.14
	//관리자페이지 제품리스트, 제품정보 수정 관련  Start ryujihong 2022.01.14
	void updatePhotoNum(int newPhotoNum, int oriPhotoNum);

	void updateImageOrder(int newOrder, String newFileName);
	//관리자페이지 제품리스트, 제품정보 수정 관련  End ryujihong 2022.01.14
	
	//2022.01.15 유지홍 제품 삭제,관리자 Qna 관련 소스 Start
	int delProductInfo(String idx);
	
	int registQnaAnswer(int idx, String answer, String userId);
	
	void updateAnswerFlg(String flg, int idx);

	void doUpdateAnswer(String content, String userId, int q_idx);

	int doDelAnswer(String userId, int a_idx);

	
	//2022.01.15 유지홍 제품 삭제, 관리자 Qna 관련 소스 End
	
	
	// 주문정보내역 리스트 orderInfoList yuSeonhwa 2022.01.17 START
	ArrayList<CartDto> orderInfoList();
	
	ArrayList<ListPageDto> Mybatispage();
	
	
	// 주문정보내역 리스트 orderInfoList yuSeonhwa 2022.01.17 END
	
	
	


}

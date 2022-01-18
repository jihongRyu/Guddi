package com.guddi.shop.dao;

import java.util.ArrayList;

import com.guddi.shop.dto.EtcDto;
import com.guddi.shop.dto.MemberDto;
import com.guddi.shop.dto.PageDto;
import com.guddi.shop.dto.ReviewQnaDto;

public interface EtcDao {
	
	// 신상여부 카테고리 관련  유지홍 2022.01.17 Start

	ArrayList<EtcDto> getNewFlgInfo();

	int doRegistNewFlg(int idx, String newname);

	int getNewFlgIdx();

	int doUpateUseFlg(int use_flg, int idx);

	ArrayList<EtcDto> getUseFlgInfo();
	
	ArrayList<EtcDto> getBrand();
	
	ArrayList<EtcDto> getSellFlgInfo();

	int doRegistSellFlg(int newIdx, String sellname);

	int getSellFlgIdx();

	int doUpdateSellUseFlg(int use_flg, int idx);

	// 신상여부 카테고리 관련  유지홍 2022.01.17 End

	// 메인이미지 제어  유지홍 2022.01.18 Start
	ArrayList<EtcDto> getMainImageList();

	ArrayList<MemberDto> getUserInfo();

	int getMainImageIdx();

	int doRegistMainImage(EtcDto pdto);

	int getU_idx(String userId);

	void delMainImage(int idx);

	int doUpdateImageUseFlg(int use_flg, int idx);

	void updateImageOrder(int idx, String string);

	int reviewSearchCount(EtcDto dto);

	ArrayList<ReviewQnaDto> reviewInfo(PageDto dto);

	ArrayList<EtcDto> getbagCategoryList();

	ArrayList<EtcDto> getbrandCategoryList();

	ArrayList<EtcDto> getanswerList();

	ReviewQnaDto getReviewDetail(int idx);

	ReviewQnaDto getReviewAnswer(int idx);

	int doReviewAnswer(ReviewQnaDto dto);

	void doDelReviewAnswer(int a_idx);

	void doUpdateReviewAnswer(ReviewQnaDto dto);
	
	
	// 메인이미지 제어  유지홍 2022.01.18 End
}

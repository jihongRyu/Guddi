package com.guddi.shop.dao;

import java.util.ArrayList;

import com.guddi.shop.dto.EtcDto;

public interface EtcDao {
	
	// 신상여부 카테고리 관련  유지홍 2022.01.17 Start

	ArrayList<EtcDto> getNewFlgInfo();

	int doRegistNewFlg(int idx, String newname);

	int getNewFlgIdx();

	int doUpateUseFlg(int use_flg, int idx);

	ArrayList<EtcDto> getUseFlgInfo();

	ArrayList<EtcDto> getBrand();
	// 신상여부 카테고리 관련  유지홍 2022.01.17 End

	//브랜드 카테고리 김도연 start 2022.01.17	
	int getBrandIdx();

	int doRegistBrand(int newidx, String name, String code);

	int doUpdateBrandUse(int useflg, int brand_idx);
	
	
	

	
	

}

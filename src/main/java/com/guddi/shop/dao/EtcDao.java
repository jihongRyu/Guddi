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

	ArrayList<EtcDto> getSellFlgInfo();

	int doRegistSellFlg(int newIdx, String sellname);

	int getSellFlgIdx();

	int doUpdateSellUseFlg(int use_flg, int idx);
	
	
	
	
	
	// 신상여부 카테고리 관련  유지홍 2022.01.17 End

	
	

}

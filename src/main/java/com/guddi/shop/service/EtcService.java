package com.guddi.shop.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guddi.shop.dao.EtcDao;
import com.guddi.shop.dto.EtcDto;


@Service
public class EtcService {

	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired EtcDao dao;
	
	// 신상여부 카테고리 관련  유지홍 2022.01.17 Start
	public ArrayList<EtcDto> getNewFlgInfo() {
		// TODO Auto-generated method stub
		return dao.getNewFlgInfo();
	}

	public int doRegistNewFlg(String newname) {
		// TODO Auto-generated method stub
		int idx = dao.getNewFlgIdx();
		int newIdx = idx+1;
		return dao.doRegistNewFlg(newIdx ,newname);
	}

	public int doUpateUseFlg(int use_flg, int idx) {
		// TODO Auto-generated method stub
		return dao.doUpateUseFlg(use_flg,idx);
	}

	public ArrayList<EtcDto> getUseFlgInfo() {
		// TODO Auto-generated method stub
		return dao.getUseFlgInfo();
	}
	// 신상여부 카테고리 관련  유지홍 2022.01.17 End
	
	
	//브랜드 카테고리 김도연 start 2022.01.17
	public ArrayList<EtcDto> getBrand() {
		logger.info("브랜드 가져오기 서비스");
		return dao.getBrand();
	}

	public int doRegistBrand(String name, String code) {
		logger.info("브랜드 추가하기 서비스");
		int idx = dao.getBrandIdx();
		int newidx = idx+1;
		logger.info("브랜드 인덱스 : "+idx+" -> "+newidx);
		
		return dao.doRegistBrand(newidx,name, code);
	}

	public int doUpdateBrandUse(int useflg, int brand_idx) {
		logger.info("브랜드 사용여부 서비스");
		return dao.doUpdateBrandUse(useflg,brand_idx);
	}

}

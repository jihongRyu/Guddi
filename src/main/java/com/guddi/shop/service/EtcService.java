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

	public ArrayList<EtcDto> getSellFlgInfo() {
		// TODO Auto-generated method stub
		return dao.getSellFlgInfo();
	}

	public int doRegistSellFlg(String sellname) {
		// TODO Auto-generated method stub
		int idx = dao.getSellFlgIdx();
		int newIdx = idx+1;
		return dao.doRegistSellFlg(newIdx, sellname);
	}

	public int doUpdateSellUseFlg(int use_flg, int idx) {
		// TODO Auto-generated method stub
		return dao.doUpdateSellUseFlg(use_flg, idx);
	}

	public int doUpdateMemFlg(int mem_flg, int idx) {
		// TODO Auto-generated method stub
		return dao.doUpdateMemFlg(mem_flg, idx);
	}
	
	
	// 신상여부 카테고리 관련  유지홍 2022.01.17 End
	


}

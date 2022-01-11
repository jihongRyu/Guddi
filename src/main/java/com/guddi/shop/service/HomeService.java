package com.guddi.shop.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guddi.shop.dao.HomeDao;
import com.guddi.shop.dto.EtcDto;


@Service
public class HomeService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired HomeDao dao;

	public ArrayList<EtcDto> getBrandcategory() {
		// TODO Auto-generated method stub
		return dao.getBrandcategory();
	}

	public ArrayList<EtcDto> getBagtype() {
		// TODO Auto-generated method stub
		return dao.getBagtype();
	}

	public ArrayList<EtcDto> getSellflg() {
		// TODO Auto-generated method stub
		return dao.getSellflg();
	}

	public ArrayList<EtcDto> getAnswertype() {
		// TODO Auto-generated method stub
		return dao.getAnswertype();
	}

	public ArrayList<EtcDto> getNewflg() {
		// TODO Auto-generated method stub
		return dao.getNewflg();
	}	
	

}

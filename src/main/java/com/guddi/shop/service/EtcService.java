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
	
	public ArrayList<EtcDto> getNewFlgInfo() {
		// TODO Auto-generated method stub
		return dao.getNewFlgInfo();
	}
	
	


}

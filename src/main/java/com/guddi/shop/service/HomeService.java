package com.guddi.shop.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guddi.shop.dao.HomeDao;

@Service
public class HomeService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired HomeDao dao;


	

}

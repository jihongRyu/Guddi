package com.guddi.shop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guddi.shop.dao.CartDao;

@Service
public class CartService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired CartDao dao;

}

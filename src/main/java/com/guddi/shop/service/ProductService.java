package com.guddi.shop.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guddi.shop.dao.ProductDao;
import com.guddi.shop.dto.EtcDto;
import com.guddi.shop.dto.ProductDto;

@Service
public class ProductService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired ProductDao dao;
	
	public ArrayList<ProductDto> productPageList(int brandIdx) {
		logger.info("선택한 brandIdx{}", brandIdx);
		return dao.productPageList(brandIdx);
	}

	public ArrayList<EtcDto> bagTypeList() {
		return dao.bagTypeList();
	}

	public ArrayList<ProductDto> productSearch(String bagType, String productName) {
		return dao.productSearch(bagType, productName);
	}


}

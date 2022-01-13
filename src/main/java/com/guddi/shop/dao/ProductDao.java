package com.guddi.shop.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.guddi.shop.dto.EtcDto;
import com.guddi.shop.dto.ProductDto;

public interface ProductDao {

	ArrayList<ProductDto> productPageList(int brandIdx);

	ArrayList<EtcDto> bagTypeList();

	ArrayList<ProductDto> productSearch(String bagType, String productName);

}

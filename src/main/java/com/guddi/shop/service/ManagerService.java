package com.guddi.shop.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guddi.shop.dao.ManagerDao;
import com.guddi.shop.dto.EtcDto;
import com.guddi.shop.dto.PageDto;
import com.guddi.shop.dto.ProductDto;

@Service
public class ManagerService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired ManagerDao dao;
	
	
	//각종  카테고리 정보를 가져오는 메서드 Start ryujihong 2022.01.11
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
	//각종  카테고리 정보를 가져오는 메서드 End ryujihong 2022.01.11
	
	//관리자페이지 제품 리스트, 수정 관련 Start ryujihong 2022.01.11
	
	//제품에 대한 정보를 가져오는 함수
	public ProductDto productInfo(int idx) {
		// TODO Auto-generated method stub
		
		return dao.productInfo(idx);
	}
	
	public ArrayList<ProductDto> productImageInfo(int idx) {
		// TODO Auto-generated method stub
		return dao.productImageInfo(idx);
	}

	public String getNewIdx() {
		// TODO Auto-generated method stub
		return dao.getNewIdx();
	}
	
	public int productSearchCount(String keyword, String brand_name, String bag_name) {
		// TODO Auto-generated method stub
		
		PageDto dto = new PageDto();
		 
		dto.setBrand_name(brand_name);
		dto.setBag_name(bag_name);
		dto.setKeyword(keyword);			
		
		return dao.productSearchCount(dto);
		
	}

	public ArrayList<ProductDto> productList(int displayPost, int postNum, String keyword, String brand_name,
			String bag_name) {
		// TODO Auto-generated method stub
		PageDto dto = new PageDto();
		
		dto.setBag_name(bag_name);
		dto.setBrand_name(brand_name);
		logger.info(" dto.getBrand_name() : {}", dto.getBrand_name() );
		logger.info(" dto.getBag_name() : {}", dto.getBag_name()) ;
		dto.setPostNum(postNum);
		dto.setDisplayPost(displayPost);
		dto.setKeyword(keyword);
					
		logger.info("postNum : {}", postNum);
		
		return dao.productList(dto);
	}
	//관리자페이지 제품 리스트, 수정 관련 End ryujihong 2022.01.11

	public void doUpdateProduct(HashMap<String, String> params, HttpSession session, ArrayList<EtcDto> brandtypeInfo
				, ArrayList<EtcDto> bagtypeInfo, int u_idx) {
		// TODO Auto-generated method stub
		
		int brand_type = Integer.parseInt(params.get("brand_type"));
		int bag_type = Integer.parseInt(params.get("bag_type"));
		
		String brand_name = null;
		String bag_name = null;		
		
		if (brand_type!=0) {
			for (int i = 0; i < brandtypeInfo.size(); i++) {
				if (brandtypeInfo.get(i).getBrand_idx()==brand_type) {
					brand_name = brandtypeInfo.get(i).getBrand_name();
				}
			}			
		}
		if (bag_type!=0) {
			for (int i = 0; i < bagtypeInfo.size(); i++) {
				if (bagtypeInfo.get(i).getType_idx()==bag_type) {
					bag_name = bagtypeInfo.get(i).getType_name();
				}
			}			
		}		
		
		ProductDto dto = new ProductDto();
		dto.setIdx(Integer.parseInt(params.get("idx")));
		dto.setProduct_name(params.get("product_name"));
		dto.setBrand_name(brand_name);
		dto.setBag_type(bag_name);
		dto.setSell_flg(Integer.parseInt(params.get("sell_flg")));
		dto.setNew_flg(Integer.parseInt(params.get("new_flg")));
		dto.setProduct_code(params.get("product_code"));
		dto.setProduct_content(params.get("content"));
		dto.setPrice(Integer.parseInt(params.get("price")));
		dto.setU_idx(u_idx);
		
		logger.info("업데이트 정보 : {}", dto.getProduct_name()+ dto.getBrand_name()+ dto.getBag_type()+dto.getSell_flg()+dto.getNew_flg()+
				dto.getProduct_code()+ dto.getProduct_content()+dto.getPrice()+dto.getU_idx());
		
		dao.doUpdateProduct(dto);
		
	}

}

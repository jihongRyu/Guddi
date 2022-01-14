package com.guddi.shop.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.guddi.shop.dao.ManagerDao;
import com.guddi.shop.dto.EtcDto;
import com.guddi.shop.dto.PageDto;
import com.guddi.shop.dto.ProductDto;

@Service
public class ManagerService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired ManagerDao dao;
	@Autowired ServletContext servletContext;
	
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

	//관리자페이지 제품 리스트, 수정 관련 Start ryujihong 2022.01.13
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
	
	public int delImage(int photoNum, int idx) {
		// TODO Auto-generated method stub
		return dao.delImage(photoNum, idx);
	}
	

	public int doAddImage(int idx, MultipartFile file, String userId) {
		// TODO Auto-generated method stub
		
		//U_idx 추출
		int u_idx = dao.getU_idx(userId);
		//photo_num가져오기
		int photo_num = dao.getPhoto_num(idx);
		int result =0;
		//저장 경로
		String realPath = servletContext.getRealPath("/resources/photo");
				
		String oriFileName = file.getOriginalFilename();
		if (oriFileName.lastIndexOf(".")>0) {
			String ext = oriFileName.substring(oriFileName.lastIndexOf("."));
			String newFileName = System.currentTimeMillis() + ext;
			logger.info(oriFileName +" >>>> "+ newFileName);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			ProductDto pdto = new ProductDto();
			
			pdto.setNewFileName(newFileName);
			pdto.setOriFileName(oriFileName);
			pdto.setB_idx(idx);
			pdto.setU_idx(u_idx);
			pdto.setPhoto_num(photo_num+1);		
			
			//이미지 DB에 등록
			result = dao.doRegistPhoto(pdto);
						
			if (result>0) {
				
				try {
					byte[] bytes = file.getBytes();
					Path path = Paths.get(realPath +"/"+ newFileName);
					Files.write(path, bytes);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}					
			}	
		}
		
		return result;
		
	}

	
	//관리자페이지 제품 리스트, 수정 관련 End ryujihong 2022.01.13
	
	//관리자페이지 제품등록 Start ryujihong 2022.01.14
	public int doRegistProduct(HashMap<String, String> params, MultipartFile[] files, String userId, String brand_name, String bag_name) {
		// TODO Auto-generated method stub
		
		//U_idx 추출
		int u_idx = dao.getU_idx(userId);
		
		//이미지 정보 DTO에 저장
		ProductDto dto = new ProductDto();
		dto.setProduct_content(params.get("content"));
		dto.setProduct_name(params.get("product_name"));
		dto.setPrice(Integer.parseInt(params.get("price")));
		dto.setBag_type(bag_name);
		dto.setBrand_idx(Integer.parseInt(params.get("brand_type")));
		dto.setBrand_name(brand_name);
		dto.setProduct_code(params.get("product_code"));
		dto.setSell_flg(Integer.parseInt(params.get("sell_flg")));
		dto.setNew_flg(Integer.parseInt(params.get("new_flg")));
		dto.setU_idx(u_idx);
		
		//제품 등록
		dao.doRegistProduct(dto);
		
		//제품 idx 저장
		int idx = dto.getIdx();
		
		logger.info("idx: {}", idx);
		
		//이미지 저장 경로 설정
		String realPath = servletContext.getRealPath("/resources/photo");
		int photo_num =1;
		
		//상품이미지 저장
		for (MultipartFile multipartFile : files) {
			String oriFileName = multipartFile.getOriginalFilename();
			if (oriFileName.lastIndexOf(".")>0) {
				String ext = oriFileName.substring(oriFileName.lastIndexOf("."));
				String newFileName = System.currentTimeMillis() + ext;
				logger.info(oriFileName +" >>>> "+ newFileName);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
				ProductDto pdto = new ProductDto();
				
				pdto.setNewFileName(newFileName);
				pdto.setOriFileName(oriFileName);
				pdto.setB_idx(idx);
				pdto.setU_idx(u_idx);
				pdto.setPhoto_num(photo_num);		
				
				//이미지 DB에 등록
				int result = dao.doRegistPhoto(pdto);
				photo_num +=  1;
				
				
				if (result>0) {
					
					try {
						byte[] bytes = multipartFile.getBytes();
						Path path = Paths.get(realPath +"/"+ newFileName);
						Files.write(path, bytes);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}				
			}		
		}		
		
		
		return idx;
	}
	//관리자페이지 제품등록 End ryujihong 2022.01.14

	public void updatePhotoNum(int newPhotoNum, int oriPhotoNum) {
		// TODO Auto-generated method stub
		dao.updatePhotoNum(newPhotoNum, oriPhotoNum);
		
	}

	public int updateImageOrder(String[] newOrder, String[] newFileName) {
		// TODO Auto-generated method stub
	
		int success = 0;
		for (int i = 0; i < newOrder.length; i++) {
			dao.updateImageOrder(Integer.parseInt(newOrder[i]), newFileName[i]);
			success++;
		}
		
		return success;
	}

	
}
